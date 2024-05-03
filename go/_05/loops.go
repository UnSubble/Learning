package main

import "fmt"

func main() {
	for i := 0; i < 10; i++ {
		println(i)
	}

	/* for {
		println("infinite")
	} */

	var numbers = []int{1, 2, 3, 4, 5, 6}
	for index, value := range numbers {
		fmt.Println(index, value)
	}
	for _, value := range numbers {
		fmt.Println(value)
	}

	var name string = "Go Lang"
	for _, char := range name {
		fmt.Println(string(char))
	}

	var names = map[string]int{
		"Mustafa": 1,
		"Ahmet":   2,
	}
	for key, value := range names {
		fmt.Println(key, value)
	}
}
