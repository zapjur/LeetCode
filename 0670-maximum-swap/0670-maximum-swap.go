func maximumSwap(num int) int {
    
    nums := []rune(strconv.Itoa(num))
    maxDigit := '0'
    maxI := -1
    swapI, swapJ := -1, -1

    for i := len(nums) - 1; i >= 0; i-- {

        if nums[i] > maxDigit {
            maxDigit = nums[i]
            maxI = i
        }

        if nums[i] < maxDigit {
            swapI, swapJ = i, maxI
        }
    }

    if swapI != -1 && swapJ != -1 {
        nums[swapI], nums[swapJ] = nums[swapJ], nums[swapI]
    }

    result, _ := strconv.Atoi(string(nums))

    return result

}