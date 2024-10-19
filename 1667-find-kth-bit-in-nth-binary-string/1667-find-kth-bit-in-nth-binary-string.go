func findKthBit(n int, k int) byte {
    len := 1 << n-1
    invert := false

    for len > 1 {
        half := len / 2

        if k <= half {
            len = half
        } else if k > half+1 {
            k = 1 + len - k
            len = half
            invert = !invert
        } else {
            if invert {
                return '0'
            }
            return '1'
        }
    }

    if invert {
                return '1'
        }
    return '0'
}