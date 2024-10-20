package main

import "fmt"

func main_temp_8() {
	channel := make(chan int, 1)

	channel <- 6

	select {
	case c1 := <-channel:
		fmt.Println(c1)
	}
}

func main_temp_9() {
	channel1 := make(chan int, 1)
	channel2 := make(chan int, 1)

	channel1 <- 6
	channel2 <- 5

	select {
	case c1 := <-channel1:
		fmt.Println(c1)
	case c2 := <-channel2:
		fmt.Println(c2)
	}
}

func main() {
	channel1 := make(chan int, 1)
	channel2 := make(chan int, 1)

	channel1 <- 6
	channel2 <- 5

	done := false

	for !done {
		select {
		case c1 := <-channel1:
			fmt.Println(c1)
		case c2 := <-channel2:
			fmt.Println(c2)
		default:
			done = true
		}
	}
}
