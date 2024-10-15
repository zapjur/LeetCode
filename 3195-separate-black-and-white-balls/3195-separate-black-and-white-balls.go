func minimumSteps(s string) int64 {
    res, l := 0, 0

    for r := 0; r < len(s); r++ {
        if s[r] == '0' {
            res += r-l
            l++
        }
    }
    return int64(res)
}