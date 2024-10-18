func backtrack(nums []int, index, currentOR int, maxOR *int, count *int) {

	if index == len(nums) {

		if currentOR > *maxOR {
			*maxOR = currentOR
			*count = 1
		} else if currentOR == *maxOR {
			(*count)++
		}
		return
	}

	backtrack(nums, index+1, currentOR|nums[index], maxOR, count)
	backtrack(nums, index+1, currentOR, maxOR, count)            
}

func countMaxOrSubsets(nums []int) int {
	maxOR, count := 0, 0
	backtrack(nums, 0, 0, &maxOR, &count)
	return count
}