func firstUniqChar(s string) int {
    count := make([]int, 26)

    for _, c := range s {
        count[c-'a']++
    }

    for i, c := range s {
        if count[c-'a'] == 1 {
            return i
        }
    }

    return -1
}