package main

import (
	"fmt"
	"sync"
)

func main() {
	// go f1() // -> main bittiği zaman program biter. f1'in çalışmasını beklemez.
	// fmt.Println("End of main")
	// time.Sleep(1 * time.Second)

	wg := sync.WaitGroup{}
	wg.Add(2)

	go func() {
		defer wg.Done()
		fmt.Println("f1")
	}()

	go func() {
		fmt.Println("f2")
		wg.Done()
	}()

	wg.Wait()

	fmt.Println("End of main")
}

func f1() {
	fmt.Println("f1")
}
