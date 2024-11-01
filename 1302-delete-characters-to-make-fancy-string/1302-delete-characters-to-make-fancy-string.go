func makeFancyString(s string) string {
    res := []byte{}
    for i := 0; i < len(s); i++ {
        n := len(res)
        if n < 2 || !(res[n-1] == s[i] && res[n-2] == s[i]) {
            res = append(res, s[i])
        }
    }
    return string(res)
}