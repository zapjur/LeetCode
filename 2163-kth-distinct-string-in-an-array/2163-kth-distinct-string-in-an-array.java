class Solution {
    public String kthDistinct(String[] arr, int k) {
        
    Map<String, Boolean> map = new HashMap<>();
    int count = 0;

    for(int i = 0; i < arr.length; i++) {
        if(map.containsKey(arr[i])) {
            map.put(arr[i], false);
        }
        else {
            map.put(arr[i], true);
        }
    }

    for(String str : arr) {
        if(map.get(str) == true) {
            count++;
            if(count == k) {
                return str;
            }
        }
    }

    return "";
    }
}