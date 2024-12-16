type Pair struct {
    val int
    idx int
}

type IntHeap []*Pair

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { 
    if h[i].val == h[j].val {
		return h[i].idx < h[j].idx 
	}
    return h[i].val < h[j].val 
}
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x any) { *h = append(*h, x.(*Pair)) }

func (h *IntHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func getFinalState(nums []int, k int, multiplier int) []int {
    h := &IntHeap{}
    heap.Init(h)

    for i, num := range nums {
        heap.Push(h, &Pair{val: num, idx: i})
    }

    for k > 0 {
        pair := heap.Pop(h).(*Pair)
        pair.val *= multiplier
        nums[pair.idx] = pair.val
        heap.Push(h, pair)
        k--
    }

    return nums
}