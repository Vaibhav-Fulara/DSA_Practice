class Solution {
    public String largestNumber(int[] arr) {
        String[]sarr = new String[arr.length];
        for(int i=0; i<arr.length; i++) {
            sarr[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(sarr, (a,b) -> {
            return (b+a).compareTo(a+b);
        });
        StringBuilder ans = new StringBuilder();
        for(String val:sarr) ans.append(val);
        while(ans.charAt(0) == '0' && ans.length() > 1) ans.deleteCharAt(0);
        return ans.toString();
    }
}