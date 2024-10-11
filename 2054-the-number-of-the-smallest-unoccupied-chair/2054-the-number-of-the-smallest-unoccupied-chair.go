type IntHeap []int

func (h IntHeap) Len() int { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}
func (h *IntHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0 : n-1]
    return x
}

type EventHeap [][2]int

func (h EventHeap) Len() int { return len(h) }
func (h EventHeap) Less(i, j int) bool { return h[i][0] < h[j][0] }
func (h EventHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }
func (h *EventHeap) Push(x interface{}) {
    *h = append(*h, x.([2]int))
}
func (h *EventHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0 : n-1]
    return x
}

func smallestChair(times [][]int, targetFriend int) int {
    
    n := len(times)

    arr := make([][2]int, n)
    for i := 0; i < n; i++ {
        arr[i] = [2]int{times[i][0], i}
    }

    sort.Slice(arr, func(i, j int) bool {
        return arr[i][0] < arr[j][0]
    })

    avCh := &IntHeap{}
    heap.Init(avCh)
    for i := 0; i < n; i++ {
        heap.Push(avCh, i)
    }

    leavQ := &EventHeap{}
    heap.Init(leavQ)

    for _, arrival := range arr {
        arrTime, fId := arrival[0], arrival[1]

        for leavQ.Len() > 0 && (*leavQ)[0][0] <= arrTime {
            heap.Push(avCh, heap.Pop(leavQ).([2]int)[1])
        }

        chair := heap.Pop(avCh).(int)

        if fId == targetFriend {
            return chair
        }

        heap.Push(leavQ, [2]int{times[fId][1], chair})
    }

    return -1

}