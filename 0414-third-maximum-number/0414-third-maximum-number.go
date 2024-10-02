func thirdMax(nums []int) int {

    if len(nums) == 0 {
        return 0
    }

    sort.Ints(nums)
    count := 1
    max := nums[len(nums)-1]

    for i := len(nums)-1; i >= 0; i-- {
        if nums[i] != max {
            count++
            max = nums[i]
        }
        
        if count == 3 {
            return max
        }
    }

    return nums[len(nums)-1]
    
}