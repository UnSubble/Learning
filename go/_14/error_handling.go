package main

import (
	"errors"
	"fmt"
	"os"
)

func main() {

	var x int
	var ptr1 *int

	fmt.Println(x)
	fmt.Println(ptr1)

	fileData, err := os.ReadFile("text.txt")

	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(fileData)
	}

	result, err := divide(10, 0)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(result)
	}
}

func divide(x int, y int) (int, error) {
	if y == 0 {
		return 0, errors.New("Payda 0 olamaz")
	}
	return x / y, nil
}
