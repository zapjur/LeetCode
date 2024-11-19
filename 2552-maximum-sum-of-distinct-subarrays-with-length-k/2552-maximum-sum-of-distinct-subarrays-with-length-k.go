func maximumSubarraySum(nums []int, k int) int64 {
    res := int64(0)
    prevIdx := make(map[int]int)
    currSum := int64(0)
    l := 0

    for r := 0; r < len(nums); r++ {
        currSum += int64(nums[r])

        i, exists := prevIdx[nums[r]]
        if !exists {
            i = -1
        }

        for l <= i || r-l+1 > k {
            currSum -= int64(nums[l])
            l++
        }

        if r-l+1 == k {
            if currSum > res {
                res = currSum
            }
        }
        prevIdx[nums[r]] = r
    }
    return res
}