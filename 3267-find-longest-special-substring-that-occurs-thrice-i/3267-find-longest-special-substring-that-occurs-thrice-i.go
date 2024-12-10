func maximumLength(s string) int {
    minRange, maxRange := 1, len(s)-2
    length := -1

    for i := minRange; i <= maxRange; i++ {
        record := make(map[string]int)
        for j := 0; j <= len(s)-i; j++ {
            sub := s[j : j+i]
            if isSpecial(sub) {
                record[sub]++
            }
        }
        for _, val := range record {
            if val >= 3 {
                length = i
            }
        }
    }
    return length
}

func isSpecial(s string) bool {
    for i := 1; i < len(s); i++ {
        if s[i] != s[0] {
            return false
        }
    }
    return true
}