func maxChunksToSorted(arr []int) int {
    ans := 0
    max := arr[0]

    for i := 0; i < len(arr); i++ {
        if arr[i] > max {
            max = arr[i]
        }

        if max == i {
            ans ++
        }
    }
    return ans
}