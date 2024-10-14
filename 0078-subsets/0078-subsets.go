func subsets(nums []int) [][]int {
    res := [][]int{}
    list := []int{}
    helper(&res, 0, nums, list)
    return res
}

func helper(res *[][]int, start int, nums []int, list []int) {
    if start >= len(nums) {
        temp := make([]int, len(list))
        copy(temp, list)
        *res = append(*res, temp)
    } else {
        list = append(list, nums[start])
        helper(res, start+1, nums, list)
        list = list[:len(list)-1]
        helper(res, start+1, nums, list)
    }
}