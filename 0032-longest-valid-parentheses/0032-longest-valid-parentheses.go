func longestValidParentheses(s string) int {
    
    stack := []int{-1}
    max := 0

    for id, ch := range s {

        if ch == '(' {
            stack = append(stack, id)
        } else {
            stack = stack[:len(stack)-1]

            if len(stack) == 0 {
                stack = append(stack, id)
            } else {
                max = Max(max, id - stack[len(stack)-1])
            }
        }
    }
    return max
}


func Max(a, b int) int {
    if a > b {
        return a
    }
    return b
}