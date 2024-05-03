package main

import "fmt"

func main() {
	a := 10

	var p *int

	p = &a
	fmt.Println(a)

	*p = 20
	fmt.Println(a)

	add12(p)
	fmt.Println(a)

}

func add12(x *int) {
	*x += 12
}
