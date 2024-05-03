package main

import "fmt"

func main() {
	defer fmt.Println("Hello") // fonksiyon bittikten sonra çalışır (test() fonksiyonuna girdiği için onun da bitmesini bekler)
	fmt.Println("World")
	test()
	// panic("An error occured!") // -> java'daki System.exit(1); gibi
}

func test() {
	defer fmt.Println("1. defer")
	fmt.Println("test Func")
	defer fmt.Println("2. defer")
	defer fmt.Println("3. defer")
}
