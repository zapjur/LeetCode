func maximumBeauty(items [][]int, queries []int) []int {
    sort.Slice(items, func(i, j int) bool {
        return items[i][0] < items[j][0]
    })

    priceBeauty := make([][2]int, 0)
    maxBeauty := 0

    for _, item := range items {
        price, beauty := item[0], item[1]
        maxBeauty = max(maxBeauty, beauty)
        priceBeauty = append(priceBeauty, [2]int{price, maxBeauty})
    }

    res := make([]int, len(queries))
    for i, query := range queries {
        idx := sort.Search(len(priceBeauty), func(j int) bool {
            return priceBeauty[j][0] > query
        }) - 1
        if idx >= 0 {
            res[i] = priceBeauty[idx][1]
        } else {
            res[i] = 0
        }
    }
    return res
}