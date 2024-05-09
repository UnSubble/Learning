package service

import (
	"errors"
	"product-app/domain"
	"product-app/persistence"
	"product-app/service/model"
)

type IProductService interface {
	Add(productCreate *model.ProductCreate) error
	DeleteById(id int) error
	GetById(id int) (domain.Product, error)
	UpdatePrice(id int, newPrice float32) error
	GetAllProducts() []domain.Product
	GetAllProductsByStore(storeName string) []domain.Product
}

type ProductService struct {
	productRepository persistence.IProductRepository
}

func NewProductService(productRepository persistence.IProductRepository) IProductService {
	return ProductService{productRepository: productRepository}
}

func (productService ProductService) Add(productCreate *model.ProductCreate) error {
	err := validateProductCreate(productCreate)

	if err != nil {
		return err
	}

	return productService.productRepository.AddProduct(&domain.Product{
		Name:     productCreate.Name,
		Price:    productCreate.Price,
		Discount: productCreate.Discount,
		Store:    productCreate.Store,
	})
}

func (productService ProductService) DeleteById(id int) error {
	return productService.productRepository.DeleteById(id)
}

func (productService ProductService) GetById(id int) (domain.Product, error) {
	return productService.productRepository.GetById(id)
}

func (productService ProductService) UpdatePrice(id int, newPrice float32) error {
	return productService.productRepository.UpdatePrice(id, newPrice)
}

func (productService ProductService) GetAllProducts() []domain.Product {
	return productService.productRepository.GetAllProducts()
}

func (productService ProductService) GetAllProductsByStore(storeName string) []domain.Product {
	return productService.productRepository.GetAllProductsByStore(storeName)
}

func validateProductCreate(productCreate *model.ProductCreate) error {
	if productCreate.Discount > 70.0 {
		return errors.New("Discount can not be greater than 70.0")
	}
	return nil
}
