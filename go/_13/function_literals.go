package main

import (
	"fmt"
	"reflect"
)

func main() {
	func() {
		fmt.Println("f1")
	}()

	add := func(x int, y int) int {
		return x + y
	}

	fmt.Println(reflect.TypeOf(add))

	fmt.Println(add(3, 5))

	sub := func(x int, y int) int {
		return x - y
	}

	r1, r2 := Calculator(6, 5, add, sub)

	fmt.Println(r1, r2)
}

func Calculator(x int, y int, f1 func(int, int) int, f2 func(int, int) int) (int, int) {
	return f1(x, y), f2(x, y)
}
