package main

import (
	"fmt"
	"time"
)

func main() {
	myChannel := make(chan int, 2)

	go func() {
		myChannel <- 2
		myChannel <- 1
		time.Sleep(1 * time.Second)
		myChannel <- 3
	}()

	<-myChannel

	fmt.Println("End of the main")
}
