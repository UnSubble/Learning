package main

import (
	"fmt"
	"sync"
)

func main_temp_2() {
	wg := sync.WaitGroup{}
	wg.Add(1)

	go func() {
		fmt.Println("hello from routine!")
		wg.Done()
	}()

	wg.Wait()

	fmt.Println("hello from main")
}
