package main

import (
	"fmt"
	"sync"
)

type RaceTest struct {
	val int
}

func main_temp_5() {
	raceTest := &RaceTest{}
	wg := sync.WaitGroup{}
	wg.Add(1000)

	for i := 0; i < 1000; i++ {
		go increment(raceTest, &wg) // lock veya mutex kullanabiliriz.
	}

	wg.Wait()

	fmt.Println(raceTest)
}

func increment(rt *RaceTest, wg *sync.WaitGroup) {
	rt.val++
	wg.Done()
}
