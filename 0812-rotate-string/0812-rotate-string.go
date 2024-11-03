func rotateString(s string, goal string) bool {
    if len(s) != len(goal) {
        return false
    }
    doubled := s + s
    
    return strings.Contains(doubled, goal)
}