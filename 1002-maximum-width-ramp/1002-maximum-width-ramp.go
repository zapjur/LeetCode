func maxWidthRamp(nums []int) int {
    
    maxRight := make([]int, len(nums))
    prevMax := 0

    for i := len(nums)-1; i >= 0; i-- {
        maxRight[i] = Max(nums[i], prevMax)
        prevMax = maxRight[i]
    }

    res := 0
    l := 0

    for r, _ := range nums {
        for nums[l] > maxRight[r] {
            l++
        }

        res = Max(res, r-l)
    }

    return res

}

func Max(a, b int) int {
    if a > b {
        return a
    }
    return b
}