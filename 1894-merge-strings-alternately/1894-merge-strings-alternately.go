func mergeAlternately(word1 string, word2 string) string {
    res := ""
	i, j := 0, 0
	for i < len(word1) && j < len(word2) {
		res += string(word1[i]) + string(word2[j])
		i++
		j++
	}

	for i < len(word1) {
		res += string(word1[i])
		i++
	}

	for j < len(word2) {
		res += string(word2[j])
		j++
	}

	return res
}