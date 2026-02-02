func longestConsecutive(nums []int) int {
    set := make(map[int]struct{})
    for _, n := range nums {
        set[n] = struct{}{}
    }

    longest := 0

    for n := range set {
        if _, ok := set[n-1]; !ok {
            len := 1
            for {
                if _, ok = set[n+len]; ok {
                    len++
                    continue
                }
                longest = max(len, longest)
                break
            }
        }
    }

    return longest
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}