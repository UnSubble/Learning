package main

import (
	"fmt"
)

func main() {
	var customer Customer
	customer = Customer{id: 1, name: "Murat", age: 30}

	fmt.Println(customer)

	var customer2 = Customer{id: 2, name: "Mustafa", age: 44}
	fmt.Println(customer2)

	fmt.Println(customer.ToString())

	fmt.Println("----------------------------------------")

	ChangeName(customer)
	fmt.Println(customer.ToString())

	ChangeNamePtr(&customer)
	fmt.Println(customer.ToString())
}

type Customer struct {
	id   int64
	name string
	age  int
}

func (customer Customer) ToString() string {
	return fmt.Sprintf("id: %d, name: %s, age: %d", customer.id, customer.name, customer.age)
}

func ChangeName(customer Customer) {
	customer.name = "Mehmet"
}

func ChangeNamePtr(customer *Customer) {
	customer.name = "Mehmet"
}
