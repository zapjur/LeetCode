class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();

        for(int student: students) {
            q.offer(student);
        }

        int i = 0;
        int cycle = 0;
        while(i < sandwiches.length) {

            if(q.peek() == sandwiches[i]){
                i++;
                q.poll();
                cycle = 0;
            }

            else {
                q.offer(q.poll());
                cycle++;
            }

            if(cycle == q.size()) return q.size();
        }

        return 0;
    }
}