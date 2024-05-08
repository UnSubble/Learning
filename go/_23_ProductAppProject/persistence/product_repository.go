package persistence

import (
	"context"
	"database/sql"
	"errors"
	"fmt"
	"product-app/domain"
	"product-app/persistence/common"

	"github.com/labstack/gommon/log"
)

type IProductRepository interface {
	GetAllProducts() []domain.Product
	GetAllProductsByStore(storeName string) []domain.Product
	AddProduct(product *domain.Product) error
	GetById(id int) (domain.Product, error)
}

type ProductRepository struct {
	dbConn *sql.Conn
}

func NewProductRepository(conn *sql.Conn) IProductRepository {
	return &ProductRepository{dbConn: conn}
}

func (productRepository *ProductRepository) GetAllProducts() []domain.Product {
	ctx := context.Background()
	rows, err := productRepository.dbConn.QueryContext(ctx, "SELECT * FROM products")

	if err != nil {
		log.Error("Error while getting all products %v\n", err)
		return []domain.Product{}
	}

	return extractProductsFromRows(rows)
}

func (productRepository *ProductRepository) GetAllProductsByStore(storeName string) []domain.Product {
	ctx := context.Background()

	query := `SELECT * FROM products WHERE store = $1`

	rows, err := productRepository.dbConn.QueryContext(ctx, query, storeName)

	if err != nil {
		log.Error("Error while getting all products by storeName %v\n", err)
		return []domain.Product{}
	}

	return extractProductsFromRows(rows)
}

func (productRepository *ProductRepository) AddProduct(product *domain.Product) error {
	ctx := context.Background()

	query := `INSERT INTO products(name, price, discount, store) VALUES($1, $2, $3, $4)`

	newProduct, err := productRepository.dbConn.ExecContext(ctx, query, product.Name, product.Price, product.Discount, product.Store)

	if err != nil {
		log.Error("Failed to add new product %v\n", err)
		return err
	}

	log.Info(fmt.Sprintf("Product added with %v", newProduct))
	return nil
}

func (productRepository *ProductRepository) GetById(id int) (domain.Product, error) {
	ctx := context.Background()

	query := `SELECT * FROM products WHERE id = $1`

	row := productRepository.dbConn.QueryRowContext(ctx, query, id)

	var newId int
	var name string
	var price float32
	var discount float32
	var store string

	err := row.Scan(&newId, &name, &price, &discount, &store)

	if err != nil && err.Error() == common.NOT_FOUND {
		return domain.Product{}, errors.New(fmt.Sprintf("Product not found with id %d", id))
	}

	if err != nil {
		return domain.Product{}, errors.New(fmt.Sprintf("Error while getting product with id %d", id))
	}

	return domain.Product{
		Id:       newId,
		Name:     name,
		Price:    price,
		Discount: discount,
		Store:    store,
	}, nil
}

func extractProductsFromRows(rows *sql.Rows) []domain.Product {
	var products = []domain.Product{}

	var id int
	var name string
	var price float32
	var discount float32
	var store string

	for rows.Next() {
		rows.Scan(&id, &name, &price, &discount, &store)
		product := domain.Product{Id: id, Name: name, Price: price, Discount: discount, Store: store}
		products = append(products, product)
	}

	return products
}
