package infrastructure

import (
	"context"
	"database/sql"
	"os"
	"product-app/common/sqlite"
	"product-app/domain"
	"product-app/persistence"
	"testing"

	"github.com/stretchr/testify/assert"
)

var productRepository persistence.IProductRepository
var conn *sql.Conn
var ctx context.Context

func TestMain(m *testing.M) {
	ctx = context.Background()

	conn = sqlite.GetConnectionPool(ctx, &sqlite.Config{
		DriverName:            "sqlite3",
		DbName:                "../../database.db",
		MaxConnections:        10,
		MaxConnectionIdleTime: 3,
		IsFile:                true,
	})

	productRepository = persistence.NewProductRepository(conn)

	exitCode := m.Run()
	os.Exit(exitCode)
}

func setup(ctx context.Context, dbConn *sql.Conn) {
	TestDataInitialize(ctx, dbConn)
}

func clear(ctx context.Context, dbConn *sql.Conn) {
	TruncateTestData(ctx, dbConn)
}

func TestGetAllProducts(t *testing.T) {
	setup(ctx, conn)

	expectedProducts := []domain.Product{
		{
			Id:       1,
			Name:     "AirFryer",
			Price:    3000.0,
			Discount: 22.0,
			Store:    "ABC TECH",
		},
		{
			Id:       2,
			Name:     "Ütü",
			Price:    1500.0,
			Discount: 10.0,
			Store:    "ABC TECH",
		},
		{
			Id:       3,
			Name:     "Çamaşır Makinesi",
			Price:    10000.0,
			Discount: 15.0,
			Store:    "ABC TECH",
		},
		{
			Id:       4,
			Name:     "Lambader",
			Price:    2000.0,
			Discount: 0.0,
			Store:    "Dekorasyon Sarayı",
		},
	}

	t.Run("GetAllProducts", func(t *testing.T) {
		actualProducts := productRepository.GetAllProducts()
		assert.Equal(t, 4, len(actualProducts))
		assert.Equal(t, expectedProducts, actualProducts)
	})

	clear(ctx, conn)
}

func TestGetAllProductsByStore(t *testing.T) {
	setup(ctx, conn)

	expectedProducts := []domain.Product{
		{
			Id:       1,
			Name:     "AirFryer",
			Price:    3000.0,
			Discount: 22.0,
			Store:    "ABC TECH",
		},
		{
			Id:       2,
			Name:     "Ütü",
			Price:    1500.0,
			Discount: 10.0,
			Store:    "ABC TECH",
		},
		{
			Id:       3,
			Name:     "Çamaşır Makinesi",
			Price:    10000.0,
			Discount: 15.0,
			Store:    "ABC TECH",
		},
	}

	t.Run("GetAllProductsByStore", func(t *testing.T) {
		actualProducts := productRepository.GetAllProductsByStore("ABC TECH")
		assert.Equal(t, 3, len(actualProducts))
		assert.Equal(t, expectedProducts, actualProducts)
	})

	clear(ctx, conn)
}

func TestAddProduct(t *testing.T) {

	expectedProducts := []domain.Product{
		{
			Id:       1,
			Name:     "Kupa",
			Price:    100.0,
			Discount: 0.0,
			Store:    "Kırtasiye Merkezi",
		},
	}

	newProduct := domain.Product{
		Name:     "Kupa",
		Price:    100.0,
		Discount: 0.0,
		Store:    "Kırtasiye Merkezi",
	}

	t.Run("TestAddProduct", func(t *testing.T) {
		err := productRepository.AddProduct(&newProduct)
		assert.Equal(t, nil, err)
		products := productRepository.GetAllProducts()
		assert.Equal(t, 1, len(products))
		assert.Equal(t, expectedProducts, products)
	})

	clear(ctx, conn)
}

func TestGetProductById(t *testing.T) {
	setup(ctx, conn)

	expectedProduct := domain.Product{
		Id:       1,
		Name:     "AirFryer",
		Price:    3000.0,
		Discount: 22.0,
		Store:    "ABC TECH",
	}

	t.Run("TestGetProductById", func(t *testing.T) {
		product, _ := productRepository.GetById(1)
		assert.Equal(t, expectedProduct, product)
	})

	clear(ctx, conn)
}
