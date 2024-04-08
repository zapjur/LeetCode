class MinStack {

    private List<Integer> list;
    private TreeSet<Integer> ts = new TreeSet<>();

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(0, val);
        ts.add(val);
    }
    
    public void pop() {
        int toRemove = list.get(0);
        list.remove(0);
        if(!list.contains(toRemove)) {
            ts.remove(toRemove);
        }
    }
    
    public int top() {
        return list.get(0);
    }
    
    public int getMin() {
        return ts.first();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */