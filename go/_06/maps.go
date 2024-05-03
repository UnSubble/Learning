package main

import "fmt"

func main() {
	var names map[string]int

	names = make(map[string]int, 0)

	names["Mustafa"] = 1
	names["Mehmet"] = 3
	names["Ahmet"] = 6

	fmt.Println(names)
	println(names)

	nameMap := map[string]int{
		"Mustafa": 1,
		"Mehmet":  2,
		"Ahmet":   3,
	}

	delete(nameMap, "Mustafa")

	fmt.Println(nameMap)
}
