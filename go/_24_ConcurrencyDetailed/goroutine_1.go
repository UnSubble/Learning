package main

import "fmt"

func main_temp_1() {
	go func() {
		fmt.Println("hello from routine!")
	}()

	fmt.Println("hello from main")
}
