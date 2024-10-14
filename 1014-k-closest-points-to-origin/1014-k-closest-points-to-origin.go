type Point struct {
	distance float64
	x        int
	y        int
}

type PointHeap []Point

func (h PointHeap) Len() int { return len(h) }
func (h PointHeap) Less(i, j int) bool { return h[i].distance > h[j].distance }
func (h PointHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }
func (h *PointHeap) Push(x interface{}) {
	*h = append(*h, x.(Point))
}
func (h *PointHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}


func kClosest(points [][]int, k int) [][]int {
    pq := &PointHeap{}   
    heap.Init(pq)

    for _, point := range points {
        dist := math.Sqrt(float64(point[0]*point[0] + point[1]*point[1]))
        heap.Push(pq, Point{distance: dist, x: point[0], y: point[1]})
        if pq.Len() > k {
            heap.Pop(pq)
        }
    }

    res := make([][]int, k) 
    for i:= 0; i < k; i++ {
        point := heap.Pop(pq).(Point)
        res[i] = []int{point.x, point.y}
    }
    return res
}