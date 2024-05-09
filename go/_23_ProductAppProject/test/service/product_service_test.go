package service

import (
	"os"
	"product-app/domain"
	"product-app/service"
	"product-app/service/model"
	"testing"

	"github.com/stretchr/testify/assert"
)

var productService service.IProductService

func TestMain(m *testing.M) {
	initialProducts := []domain.Product{
		{
			Id:    1,
			Name:  "AirFryer",
			Price: 1000.0,
			Store: "ABC TECH",
		},
		{
			Id:    2,
			Name:  "Ütü",
			Price: 4000.0,
			Store: "ABC TECH",
		},
	}

	fakeProductRepository := NewFakeProductRepository(initialProducts)
	productService = service.NewProductService(fakeProductRepository)

	exitCode := m.Run()
	os.Exit(exitCode)
}

func TestGetAllProducts(t *testing.T) {

	t.Run("GetAllProducts", func(t *testing.T) {
		actual := productService.GetAllProducts()
		assert.Equal(t, 2, len(actual))
	})
}

func TestAddProduct(t *testing.T) {
	t.Run("AddProduct", func(t *testing.T) {
		productService.Add(&model.ProductCreate{
			Name:     "Ütü",
			Price:    2000.0,
			Discount: 50,
			Store:    "ABC TECH",
		})
		actual := productService.GetAllProducts()
		assert.Equal(t, 3, len(actual))
	})
}
