package main

import "fmt"

func main() {
	var age = 17

	if age < 18 {
		fmt.Println("You can't vote")
	} else {
		fmt.Println("You can vote")
	}

	a := 10
	b := 20

	if a > b {
		println("a")
	} else if a < b {
		println("b")
	} else {
		println("eq")
	}
}
