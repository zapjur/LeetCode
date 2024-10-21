func maxUniqueSplit(s string) int {
    return dfs(make(map[string]int), s)
}

func dfs(cache map[string]int, s string) int {
    if s == "" {
        return len(cache)
    }

    res := 0
    for i, _ := range s {
        _, ok := cache[s[:i+1]]

        if !ok {
            cache[s[:i+1]] = 1
            res = max(res, dfs(cache, s[i+1:]))
            delete(cache, s[:i+1])
        }
    }
    return res
}