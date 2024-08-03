class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(0, 0, "", n, res);

        return res;
    }

    private void dfs(int open, int close, String s, int n, List<String> res) {
        if(open == close && close + open == n*2) {
            res.add(s);
            return;
        }

        if(open < n) {
            dfs(open + 1, close, s +"(", n, res);
        }

        if(close < open) {
            dfs(open, close+1, s+")", n, res);
        }
    }
}