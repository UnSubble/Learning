package service

import (
	"errors"
	"fmt"
	"product-app/domain"
	"product-app/persistence"
)

type FakeProductRepository struct {
	Products []domain.Product
}

func NewFakeProductRepository(initialProducts []domain.Product) persistence.IProductRepository {
	return &FakeProductRepository{Products: initialProducts}
}

func (fakeProductRepository *FakeProductRepository) GetAllProducts() []domain.Product {
	return fakeProductRepository.Products
}

func (fakeProductRepository *FakeProductRepository) GetAllProductsByStore(storeName string) []domain.Product {
	result := []domain.Product{}
	for _, product := range fakeProductRepository.Products {
		if product.Store == storeName {
			result = append(result, product)
		}
	}
	return result
}

func (fakeProductRepository *FakeProductRepository) AddProduct(product *domain.Product) error {
	fakeProductRepository.Products = append(fakeProductRepository.Products, domain.Product{
		Id:       len(fakeProductRepository.Products) + 1,
		Name:     product.Name,
		Price:    product.Price,
		Discount: product.Discount,
		Store:    product.Store,
	})
	return nil
}

func (fakeProductRepository *FakeProductRepository) GetById(id int) (domain.Product, error) {
	for _, product := range fakeProductRepository.Products {
		if product.Id == id {
			return product, nil
		}
	}
	return domain.Product{}, errors.New(fmt.Sprintf("Cannot found any product that specified by id %v", id))
}

func (fakeProductRepository *FakeProductRepository) DeleteById(id int) error {
	index := -1
	for i, product := range fakeProductRepository.Products {
		if product.Id == id {
			index = i
			break
		}
	}

	if index == -1 {
		return errors.New("The product not found")
	}

	newProducts := []domain.Product{}

	newProducts = append(newProducts, fakeProductRepository.Products...)

	fakeProductRepository.Products = newProducts

	return nil
}

func (fakeProductRepository *FakeProductRepository) UpdatePrice(id int, newPrice float32) error {
	for _, product := range fakeProductRepository.Products {
		if product.Id == id {
			product.Price = newPrice
			return nil
		}
	}

	return errors.New("The product not found")
}
