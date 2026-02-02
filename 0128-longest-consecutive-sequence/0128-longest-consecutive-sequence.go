func longestConsecutive(nums []int) int {
	set := make(map[int]struct{}, len(nums))
	for _, n := range nums {
		set[n] = struct{}{}
	}

	longest := 0

	for _, n := range nums {
		if _, ok := set[n]; !ok {
			continue
		}

		delete(set, n)
		length := 1

		for x := n - 1; ; x-- {
			if _, ok := set[x]; !ok {
				break
			}
			delete(set, x)
			length++
		}

		for x := n + 1; ; x++ {
			if _, ok := set[x]; !ok {
				break
			}
			delete(set, x)
			length++
		}

		if length > longest {
			longest = length
		}
	}

	return longest
}
