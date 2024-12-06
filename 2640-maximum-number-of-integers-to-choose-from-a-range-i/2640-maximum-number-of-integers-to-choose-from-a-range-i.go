func maxCount(banned []int, n int, maxSum int) int {
    count := 0
    sum := 0
    sort.Ints(banned)

    for i := 1; i <= n; i++ {
        if !bs(banned, i) {
            sum += i
            if sum <= maxSum {
                count++
            } else {
                return count
            }
        }
    }
    return count
}

func bs(arr []int, target int) bool {
    n := len(arr)
    l, r := 0, n-1

    for l <= r {
        mid := l + (r-l)/2

        if arr[mid] == target {
            return true
        } else if arr[mid] > target {
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    return false
}