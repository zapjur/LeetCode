func areSentencesSimilar(sentence1 string, sentence2 string) bool {

    w1 := strings.Split(sentence1, " ")
    w2 := strings.Split(sentence2, " ")

    if len(w1) < len(w2) {
        w1, w2 = w2, w1
    }

    start, end := 0, 0
    n1, n2 := len(w1), len(w2)

    for start < n2 && w1[start] == w2[start] {
        start++
    }

    for end < n2 && w1[n1-end-1] == w2[n2-end-1] {
        end++
    }

    return start+end >= n2

}