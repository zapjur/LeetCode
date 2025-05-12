func findEvenNumbers(digits []int) []int {
    
    cnt := make([]int, 10)
    for _, d := range digits { cnt[d]++ }

    res := make([]int, 0)
    for i := 100; i < 1000; i+=2 {
        if can(cnt, i) { res = append(res, i)}
    }

    return res
}

func can(cnt []int, n int) bool {
    for d := 0; d < 10; d++ {
        dc := 0
        if n / 100 == d {dc++}
        if (n % 100) / 10 == d {dc++}
        if n % 10 == d {dc++}
        if dc > cnt[d] {return false}
    }
    return true
}