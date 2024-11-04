func compressedString(word string) string {
    if len(word) == 0 {
        return ""
    }
    var builder strings.Builder
    count := 1

    for i := 1; i < len(word); i++ {
        if word[i] == word[i-1] && count < 9 {
            count++
        } else {
            builder.WriteString(fmt.Sprintf("%d%c", count, word[i-1]))
            count = 1
        }
    }
    builder.WriteString(fmt.Sprintf("%d%c", count, word[len(word)-1]))

    return builder.String()
}