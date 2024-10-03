func minSubarray(nums []int, p int) int {
    totalSum := sum(nums)
    rest := totalSum % p

    if rest == 0 {
        return 0
    }

    modMap := make(map[int]int)
    modMap[0] = -1 

    currentSum := 0
    minLength := len(nums)

    for i, v := range nums {
        currentSum = (currentSum + v) % p

        target := (currentSum - rest + p) % p

        if idx, found := modMap[target]; found {
            minLength = min(minLength, i-idx)
        }

        modMap[currentSum] = i
    }

    if minLength == len(nums) {
        return -1
    }
    return minLength
}

func sum(nums []int) int {
    sum := 0
    for _, v := range nums {
        sum += v
    }
    return sum
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
