package main

import "fmt"

type Product interface {
	ShippingCost() int
}

type Book struct {
	desi int
}

type Electronic struct {
	desi int
}

func (electronic *Electronic) ShippingCost() int {
	return 5 + electronic.desi*3
}

func (book *Book) ShippingCost() int {
	return 5 + book.desi*2
}

func main() {
	book := &Book{desi: 10}
	fmt.Println(book.ShippingCost())

	electronic := &Electronic{desi: 20}
	fmt.Println(electronic.ShippingCost())

	fmt.Println(calculateTotalShippingCosts(book, electronic))
}

func calculateTotalShippingCosts(products ...Product) int {
	var total int = 0
	for _, product := range products {
		total += product.ShippingCost()
	}
	return total
}
