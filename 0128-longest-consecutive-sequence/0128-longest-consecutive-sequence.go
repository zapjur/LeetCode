func longestConsecutive(nums []int) int {
	set := make(map[int]struct{}, len(nums))
	for _, n := range nums {
		set[n] = struct{}{}
	}

	longest := 0

	for n := range set {
		if _, ok := set[n-1]; ok {
			continue
		}

		length := 1
		for m := n + 1; ; m++ {
			if _, ok := set[m]; !ok {
				if length > longest {
					longest = length
				}
				break
			}
			length++
		}
	}

	return longest
}
