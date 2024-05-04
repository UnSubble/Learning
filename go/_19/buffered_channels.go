package main

import "fmt"

func main() {
	myChannel := make(chan int, 2)

	myChannel <- 1
	myChannel <- 2
	// myChannel <- 3 // -> 3.yü eklemeden önce okumamız gerekiyor yoksa deadlock'a girer.
	data := <-myChannel
	myChannel <- 4
	fmt.Println(data)
	fmt.Println("End of the main")
}
