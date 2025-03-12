class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        generate(res, new StringBuilder(), n, -1);
        return res;
    }

    private void generate(List<String> res, StringBuilder sb, int n, int last) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        sb.append('1');
        generate(res, sb, n, 1);
        sb.deleteCharAt(sb.length()-1);

        if(last != 0) {
            sb.append('0');
            generate(res, sb, n, 0);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}