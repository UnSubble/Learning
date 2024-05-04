package main

import (
	"fmt"
)

func main() {
	sample1()

	sample2()

	sample3()
}

func f1() int {
	return 5
}

func sample1() {
	// data := go f1() // -> yapamayız

	myChannel := make(chan string)

	go func() {
		myChannel <- "Hello World"
	}()

	data, isOpen := <-myChannel // bekler (sadece yazma işlemi de bekletir çünkü okuyan yok!)

	fmt.Println(data)
	fmt.Println(isOpen)
}

func sample2() {
	myChannel := make(chan string)

	go func() {
		message := <-myChannel // bekler
		fmt.Println(message)
	}()

	myChannel <- "Hello world"
}

func sample3() {
	myChannel := make(chan string)
	done := make(chan bool)

	go func() {
		myChannel <- "Hello World"
	}()

	go func() {
		message := <-myChannel
		fmt.Println(message)
		done <- true
	}()

	<-done // böyle de kullanılabilir
	fmt.Println("end of the sample3")
}
