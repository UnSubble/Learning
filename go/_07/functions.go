package main

import "fmt"

func main() {
	fmt.Println(add(54, 46))
	n, m := calc(5, 5)
	fmt.Println(n, m)
	fmt.Println(sum(1, 2, 3, 4, 5, 6, 7))
}

func add(a, b int) int {
	return a + b
}

func calc(x int, y int) (int, int) {
	return x + y, x - y
}

func sum(a ...int) int {
	var res int = 0
	for _, val := range a {
		res += val
	}
	return res
}
