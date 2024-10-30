func minimumMountainRemovals(nums []int) int {
    n := len(nums)
    lis := make([]int, n)
    lds := make([]int, n)
    for i := range lis {
        lis[i] = 1
        lds[i] = 1
    }

    for i := 0; i < n; i++ {
        for j := 0; j < i; j++ {
            if nums[i] > nums[j] {
                lis[i] = max(lis[i], lis[j] + 1)
            }
        }
    }

    for i := n-1; i >= 0; i-- {
        for j := n-1; j > i; j-- {
            if nums[i] > nums[j] {
                lds[i] = max(lds[i], lds[j] + 1)
            }
        }
    }

    res := 0
    for i := 1; i < n-1; i++ {
        if lis[i] > 1 && lds[i] > 1 {
            res = max(res, lis[i]+lds[i]-1)
        }
    }

    return n-res
}