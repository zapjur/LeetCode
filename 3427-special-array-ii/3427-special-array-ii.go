func isArraySpecial(nums []int, queries [][]int) []bool {
    n := len(nums)
    isSpecialPrefix := make([]bool, n)
    for i := 1; i < n; i++ {
        isSpecialPrefix[i] = (nums[i]%2 != nums[i-1]%2)
    }

    prefixSum := make([]int, n)
    for i := 1; i < n; i ++ {
        prefixSum[i] = prefixSum[i-1]
        if !isSpecialPrefix[i] {
            prefixSum[i]++
        }
    }

    res := make([]bool, len(queries))
    for i, query := range queries {
        from, to := query[0], query[1]
        if from == to {
            res[i] = true
        } else {
            specialCount := prefixSum[to] - prefixSum[from]
            res[i] = (specialCount == 0)
        }
    }
    return res
}