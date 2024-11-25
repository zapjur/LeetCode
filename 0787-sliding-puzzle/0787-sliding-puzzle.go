type State struct {
	board string
	moves int
}

func slidingPuzzle(board [][]int) int {
	target := "123450"
	
	start := ""
	for _, row := range board {
		for _, num := range row {
			start += fmt.Sprintf("%d", num)
		}
	}

	neighbors := map[int][]int{
		0: {1, 3}, 1: {0, 2, 4}, 2: {1, 5},
		3: {0, 4}, 4: {1, 3, 5}, 5: {2, 4},
	}

	queue := []State{{board: start, moves: 0}}
	visited := make(map[string]bool)
	visited[start] = true

	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]

		state := current.board
		moves := current.moves

		if state == target {
			return moves
		}

		zeroIndex := strings.Index(state, "0")

		for _, neighbor := range neighbors[zeroIndex] {
			newState := []byte(state)
			newState[zeroIndex], newState[neighbor] = newState[neighbor], newState[zeroIndex]
			newStateStr := string(newState)

			if !visited[newStateStr] {
				visited[newStateStr] = true
				queue = append(queue, State{board: newStateStr, moves: moves + 1})
			}
		}
	}

	return -1
}

