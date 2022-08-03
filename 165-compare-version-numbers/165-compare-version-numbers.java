class Solution {
    public int compareVersion(String version1, String version2) {
        String[]arr1 = version1.split("\\.");
        String[]arr2 = version2.split("\\.");
        
        // System.out.println(arr1.length + " " + arr2.length);
        
        int i=0;
        while(i < arr1.length && i < arr2.length) {
            if(Integer.valueOf(arr1[i]) > Integer.valueOf(arr2[i])) {
                return 1;
            } else if(Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[i])) {
                return -1;
            }
            i++;
        }
        
        if(i != arr1.length) {
            for(; i<arr1.length; i++) if(Integer.valueOf(arr1[i]) != 0) return 1;
        } else if(i != arr2.length) {
            for(; i<arr2.length; i++) if(Integer.valueOf(arr2[i]) != 0) return -1;
        }
        
        return 0;
    }
}