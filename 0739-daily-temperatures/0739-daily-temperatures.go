func dailyTemperatures(temperatures []int) []int {

    arr := make([]int, len(temperatures))

    stack := []int{}

    for i, v := range temperatures {

        for len(stack) > 0 && temperatures[stack[len(stack)-1]] < v {
         
            idx := stack[len(stack)-1]
            stack = stack[:len(stack)-1]
            arr[idx] = i - idx
        }
  
        stack = append(stack, i)
    }

    return arr
}
