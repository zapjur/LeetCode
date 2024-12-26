func findTargetSumWays(nums []int, target int) int {
    res := 0
    var backtrack func([]int, int, int, int) 
    backtrack = func(nums []int, target, currSum, currIndex int) {
        if currIndex == len(nums) {
            if currSum == target {
                res++
                return
            }
            return
        }
        backtrack(nums, target, currSum+nums[currIndex], currIndex+1)
        backtrack(nums, target, currSum-nums[currIndex], currIndex+1)
    }
    backtrack(nums, target, 0, 0)
    return res
}