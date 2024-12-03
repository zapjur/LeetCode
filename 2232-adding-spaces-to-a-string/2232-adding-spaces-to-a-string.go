func addSpaces(s string, spaces []int) string {
    res := make([]byte, len(s)+len(spaces))
    writePos := 0
    readPos := 0

    for _, spacePos := range spaces {
        for readPos < spacePos {
            res[writePos] = s[readPos]
            writePos++
            readPos++
        }
        res[writePos] = ' '
        writePos++
    }

    for readPos < len(s) {
        res[writePos] = s[readPos]
        writePos++
        readPos++
    }

    return string(res)
}