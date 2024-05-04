package main

import (
	"fmt"
	"time"
)

func main() {
	sample1()
	sample2()
	sample3()
}

func sample1() {
	channel1 := make(chan string)
	channel2 := make(chan string)

	go func() {
		time.Sleep(5 * time.Second)
		channel1 <- "hello"
	}()

	go func() {
		time.Sleep(1 * time.Second)
		channel2 <- "world"
	}()

	var data1 string
	var data2 string
	data1 = <-channel1
	data2 = <-channel2

	fmt.Println("Data1 came:", data1)
	fmt.Println("Data2 came:", data2)
} // hello world olarak gelir ve data2 önce gelmesine rağmen data1'i beklemek zorunda kalır

func sample2() {
	channel1 := make(chan string)
	channel2 := make(chan string)

	go func() {
		time.Sleep(5 * time.Second)
		channel1 <- "hello"
	}()

	go func() {
		time.Sleep(1 * time.Second)
		channel2 <- "world"
	}()

	var data1 string
	var data2 string

	select {
	case data1 = <-channel1:
		fmt.Println("Received data from channel1", data1)
	case data2 = <-channel2:
		fmt.Println("Received data from channel2", data2)
	}
} // hangisi erken gelirse o print edilir ve biter

func sample3() {
	channel1 := make(chan string)
	channel2 := make(chan string)

	go func() {
		time.Sleep(5 * time.Second)
		channel1 <- "hello"
	}()

	go func() {
		time.Sleep(1 * time.Second)
		channel2 <- "world"
	}()

	var data1 string
	var data2 string

	for len(data1) == 0 || len(data2) == 0 {
		select {
		case data1 = <-channel1:
			fmt.Println("Received data from channel1", data1)
		case data2 = <-channel2:
			fmt.Println("Received data from channel2", data2)
		default:
			fmt.Println("No data came")
		}
		time.Sleep(500 * time.Millisecond)
	}
}
