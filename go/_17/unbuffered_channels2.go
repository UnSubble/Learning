package main

import (
	"fmt"
	"time"
)

func main() {
	myChannel := make(chan int)

	go func() {
		for i := 1; i <= 10; i++ {
			myChannel <- i
			fmt.Println("sent data:", i)
			time.Sleep(600 * time.Millisecond)
		}
		close(myChannel) // bittikten sonra kapatıyoruz.
	}()

	for {
		data, isOpen := <-myChannel

		if isOpen == false {
			break
		}

		fmt.Println(data)
	}
}
