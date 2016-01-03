package main

import (
	"fmt"
	"time"
)

func fib(n int) int {
	if (n < 2) { return n }
	return fib(n - 2) + fib(n - 1)
}

func main() {
	fmt.Println("Start warming up.")
	sum := fib(38)
	fmt.Println("Finish warming up.")

	start := time.Now()
	sum += fib(38)
	duration := time.Now().Sub(start)

	fmt.Printf("Duration: %f\n", duration.Seconds())
	fmt.Printf("Result: %d\n", sum)
}
