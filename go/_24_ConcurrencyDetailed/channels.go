package main

import "fmt"

func main_temp_6() {
	unbufferedChan := make(chan int)

	go func(unbufChan <-chan int) {
		value := <-unbufChan
		fmt.Println(value)
	}(unbufferedChan)

	unbufferedChan <- 1
}

func main_temp_7() {
	bufferedChan := make(chan int, 5) // 2. argüman size, 5'ten sonrasında block'lanıcak ve verinin okunmasını bekleyecek.
	// okunduğu an push'lamaya devam edecek.

	go func(bufChan <-chan int) {
		value := <-bufChan
		fmt.Println(value)
	}(bufferedChan)

	bufferedChan <- 1
}
