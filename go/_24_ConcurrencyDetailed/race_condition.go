package main

import (
	"fmt"
	"sync"
	"sync/atomic"
)

func main_temp_4() {
	raceExample()
	raceExampleFixed()
	raceExampleFixed2()
}

func raceExample() {
	wg := sync.WaitGroup{}
	wg.Add(2)

	val := 0

	go func() {
		for i := 0; i < 1000000; i++ {
			val++
		}

		wg.Done()
	}()

	go func() {
		for i := 0; i < 1000000; i++ {
			val++
		}

		wg.Done()
	}()

	wg.Wait()

	fmt.Println(val)
}

func raceExampleFixed() {
	wg := sync.WaitGroup{}
	wg.Add(2)

	lock := sync.Mutex{}

	val := 0

	go func() {
		for i := 0; i < 1000000; i++ {
			lock.Lock()
			val++
			lock.Unlock()
		}

		wg.Done()
	}()

	go func() {
		for i := 0; i < 1000000; i++ {
			lock.Lock()
			val++
			lock.Unlock()
		}

		wg.Done()
	}()

	wg.Wait()

	fmt.Println(val)
}

func raceExampleFixed2() {
	wg := sync.WaitGroup{}
	wg.Add(2)

	var val int32 = 0

	go func() {
		for i := 0; i < 1000000; i++ {
			atomic.AddInt32(&val, 1)
		}

		wg.Done()
	}()

	go func() {
		for i := 0; i < 1000000; i++ {
			atomic.AddInt32(&val, 1)
		}

		wg.Done()
	}()

	wg.Wait()

	fmt.Println(val)
}
