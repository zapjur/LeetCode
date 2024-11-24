func maxMatrixSum(matrix [][]int) int64 {
    var sum int64 = 0
    countNeg := 0
    smallestAbs := int64(1e5)

    for i := 0; i < len(matrix); i++ {
        for j := 0; j < len(matrix[0]); j++ {
            val := int64(matrix[i][j])
            if val < 0 {
                countNeg++
            }
            sum += abs(val)
            smallestAbs = min(smallestAbs, abs(val))
        }
    }
    if countNeg%2 == 0 {
        return sum
    }

    return sum - 2*smallestAbs
}

func abs(v int64) int64 {
    if v < 0 {
        return -v
    }
    return v
}

func min(a, b int64) int64 {
    if a < b {
        return a
    }
    return b
}
