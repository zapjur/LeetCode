func minAddToMakeValid(s string) int {
    close, open := 0, 0

    for _, c := range s {
        if c == '(' {
            open++
        } else if c == ')' && open > 0 {
            open--
        } else {
            close++
        }
    }

    return open + close

}