func longestSquareStreak(nums []int) int {
    
    numSet := make(map[int]bool)

    for _, num := range nums {
        numSet[num] = true
    }

    maxLength := 0

    for num := range numSet {
        length := 0
        curr := num

        for numSet[curr] {
            length++
            if curr > 46340 {
                break
            }
            curr *= curr
        }

        if length > 1 {
            maxLength = max(maxLength, length)
        }
    }
    
    if maxLength > 1 {
        return maxLength
    }
    return -1
}