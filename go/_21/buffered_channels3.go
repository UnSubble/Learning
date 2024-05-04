package main

import (
	"fmt"
	"time"
)

func main() {
	bufferedChannel := make(chan int, 4)

	go func() {
		for i := 1; i <= 10; i++ {
			bufferedChannel <- i
		}
		close(bufferedChannel)
	}()

	time.Sleep(100 * time.Millisecond)
	for data := range bufferedChannel {
		fmt.Println(data)
	}

	fmt.Println("End of the main")
}
