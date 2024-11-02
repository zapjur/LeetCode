import "strings"
func isCircularSentence(sentence string) bool {
    words := strings.Split(sentence, " ")
    for i := 0; i < len(words); i++ {
        lastChar := words[i][len(words[i])-1]
        firstChar := words[(i+1)%len(words)][0]
        if lastChar != firstChar {
            return false
        }
    }
    return true
}