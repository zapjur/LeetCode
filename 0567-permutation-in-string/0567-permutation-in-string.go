func checkInclusion(s1 string, s2 string) bool {
    
    if len(s1) > len(s2) {
        return false
    }

    s1C := make([]int, 26)
    s2C := make([]int, 26)

    for i := 0; i < len(s1); i++ {
        s1C[s1[i] - 'a']++
        s2C[s2[i] - 'a']++
    }

    for i := 0; i < len(s2)-len(s1); i++ {
        if check(s1C, s2C) {
            return true
        }

        s2C[s2[i]-'a']--
        s2C[s2[i+len(s1)]-'a']++
    }

    return check(s1C, s2C)

}

func check(a, b []int) bool {
    for i := 0; i < 26; i++ {
        if a[i] != b[i] {
            return false
        }
    }

    return true
}