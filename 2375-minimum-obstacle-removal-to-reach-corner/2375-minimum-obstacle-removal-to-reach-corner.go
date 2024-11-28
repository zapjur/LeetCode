type Node struct {
	obstacles int
	r, c      int
}

type MinHeap []Node

func (h MinHeap) Len() int            { return len(h) }
func (h MinHeap) Less(i, j int) bool  { return h[i].obstacles < h[j].obstacles }
func (h MinHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *MinHeap) Push(x interface{}) { *h = append(*h, x.(Node)) }
func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func minimumObstacles(grid [][]int) int {
	rows, cols := len(grid), len(grid[0])
	minHeap := &MinHeap{}
	heap.Init(minHeap)
	heap.Push(minHeap, Node{obstacles: 0, r: 0, c: 0})

	visited := make(map[[2]int]bool)
	visited[[2]int{0, 0}] = true

	directions := [][2]int{
		{1, 0}, {-1, 0}, {0, 1}, {0, -1},
	}

	for minHeap.Len() > 0 {
		current := heap.Pop(minHeap).(Node)

		if current.r == rows-1 && current.c == cols-1 {
			return current.obstacles
		}

		for _, dir := range directions {
			nr, nc := current.r+dir[0], current.c+dir[1]

			if nr < 0 || nc < 0 || nr >= rows || nc >= cols {
				continue
			}
			if visited[[2]int{nr, nc}] {
				continue
			}

			heap.Push(minHeap, Node{obstacles: current.obstacles + grid[nr][nc], r: nr, c: nc})
			visited[[2]int{nr, nc}] = true
		}
	}

	return -1
}