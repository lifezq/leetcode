package main

import "fmt"

func firstNoRepeat(s string) string {
	cs := [26]int{}
	for _, c := range s {
		cs[c-'A']++
	}

	for _, c := range s {
		if cs[c-'A'] == 1 {
			return string(c)
		}
	}

	return ""
}

func main() {
	fmt.Println(firstNoRepeat("GOOGLE"))
}
