type Pair struct {
    c byte
    num int
}

type Heap []Pair

func (h Heap) Len() int {return len(h)}
func (h Heap) Less(i, j int) bool {return h[i].num > h[j].num}
func (h Heap) Swap(i, j int) {h[i], h[j] = h[j], h[i]}
func (h *Heap) Push(x interface{}) {*h = append(*h, x.(Pair))}
func (h *Heap) Pop() interface{} {
    n := len(*h)
    x := (*h)[n-1]
    *h = (*h)[0:n-1]
    return x
}

func longestDiverseString(a int, b int, c int) string {
    pq := &Heap{}
    heap.Init(pq)
    
    if a > 0 {heap.Push(pq, Pair{'a', a})}
    if b > 0 {heap.Push(pq, Pair{'b', b})}
    if c > 0 {heap.Push(pq, Pair{'c', c})}

    var ans []byte

    for pq.Len() > 0 {
        curr := heap.Pop(pq).(Pair)

        if len(ans) >= 2 && ans[len(ans)-1] == curr.c && ans[len(ans)-2] == curr.c {

            if pq.Len() == 0 {
                break
            }
            next := heap.Pop(pq).(Pair)
            ans = append(ans, next.c)
            if next.num > 1 {
                next.num--
                heap.Push(pq, next)
            }
            heap.Push(pq, curr)

        } else {
            ans = append(ans, curr.c)
            if curr.num > 1 {
                curr.num--
                heap.Push(pq, curr)
            }
        }
    }
    return string(ans)
}