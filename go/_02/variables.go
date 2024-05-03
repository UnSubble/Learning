package main

import (
	"fmt"
	"reflect"
)

func main() {

	var productName string
	var quantity int
	var discount float32
	var isInStock bool

	productName = "Go Lang"
	quantity = 10
	discount = 0.37
	isInStock = true

	fmt.Println(productName)
	fmt.Println(reflect.TypeOf(productName))
	fmt.Println(quantity, discount)
	fmt.Println(isInStock, reflect.TypeOf(isInStock))

	var name string = "Go Lang"
	fmt.Println(name)

	var name2 = "Go Lang"
	fmt.Println(name2)

	name3 := "Go Lang"
	fmt.Println(name3)

}
