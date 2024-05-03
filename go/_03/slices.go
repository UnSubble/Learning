package main

import "fmt"

func main() {
	var arr [3]int
	arr[0] = 1
	arr[1] = 2
	arr[2] = 3
	fmt.Println(arr)

	var arr2 = []int{1, 2, 3}
	fmt.Println(arr2)
	fmt.Println(arr2[1:3])

	var names = []string{"Mustafa", "Ahmet"}
	fmt.Println(names)
	names = append(names, "Mehmet")
	fmt.Println(names)
}
