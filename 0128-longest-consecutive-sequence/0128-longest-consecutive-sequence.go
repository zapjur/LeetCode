func longestConsecutive(nums []int) int {
    if len(nums) == 0 {
        return 0
    }

    set := make(map[int]bool)
    for _, num := range nums {
        set[num] = true
    }
    max := 1
    var curr int
    var length int
    for num := range set {
        if !set[num-1] {
            curr = num
            length = 1 
        }

        for set[curr+1] {
            curr++
            length++
        }
        if length > max {
            max = length
        }
    }
    return max
}