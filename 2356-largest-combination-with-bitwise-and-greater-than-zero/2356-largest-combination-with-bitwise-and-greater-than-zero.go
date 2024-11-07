func largestCombination(candidates []int) int {
    ans := make([]int, 32)
    
    for _, x := range candidates {
        find(x, ans)
    }
    
    res := 0
    for i := 0; i < 32; i++ {
        if ans[i] > res {
            res = ans[i]
        }
    }
    
    return res
}

func find(n int, ans []int) {
    j := 31
    
    for n > 0 {
        a := n & 1
        ans[j] += a
        n >>= 1
        j--
    }
}