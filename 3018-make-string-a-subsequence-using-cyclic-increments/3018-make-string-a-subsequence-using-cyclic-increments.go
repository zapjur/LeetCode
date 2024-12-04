func canMakeSubsequence(str1 string, str2 string) bool {
    targetIdx, targetLen := 0, len(str2)

    for _, currChar := range str1 {
        if targetIdx < targetLen && (int(str2[targetIdx]) - int(currChar) + 26) % 26 <= 1 {
            targetIdx++
        }
    }
    return targetIdx == targetLen
}