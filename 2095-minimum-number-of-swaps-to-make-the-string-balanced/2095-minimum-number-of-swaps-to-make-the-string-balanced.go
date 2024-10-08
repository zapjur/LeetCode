func minSwaps(s string) int {
    res := 0

    for _, c := range s {
        if c == '[' {
            res++
        } else if res > 0 {
            res--
        }
    }

    return (res+1)/2
}