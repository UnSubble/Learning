package main

import (
	"fmt"
	"sync"
)

func main_temp_3() {
	wg := sync.WaitGroup{}
	wg.Add(10)

	for i := 0; i < 10; i++ {
		go func(i int) {
			fmt.Println("hello from routine!", i) // i func literali olmadığı zaman sonuncu değeri ile çalışıyor.
			wg.Done()
		}(i)
	}

	wg.Wait()

	fmt.Println("hello from main")
}
