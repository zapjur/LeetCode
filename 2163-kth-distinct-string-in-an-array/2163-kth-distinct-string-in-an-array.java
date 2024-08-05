class Solution {
    public String kthDistinct(String[] arr, int k) {
        List<String> diststr = new ArrayList<>();
        List<String> helper = new ArrayList<>();

        for(String str : arr) {
            if(helper.contains(str)) {
                continue;
            }
            if(diststr.contains(str)) {
                diststr.remove(str);
                helper.add(str);
                continue;
            }
            diststr.add(str);
        }

        System.out.println(diststr);

        return diststr.size() >= k ? diststr.get(k-1) : "";
    }
}