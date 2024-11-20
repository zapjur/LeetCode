func takeCharacters(s string, k int) int {
    count := make([]int, 3)
    for _, c := range s {
        count[c-'a']++
    }

    if min(count[0], min(count[1], count[2])) < k {
        return -1
    }

    res := len(s) + 1
    l := 0

    for r := 0; r < len(s); r++ {
        count[s[r]-'a']--

        for min(count[0], min(count[1], count[2])) < k {
            count[s[l]-'a']++
            l++
        }
        res = min(res, len(s)-(r-l+1))
    }
    return res
}