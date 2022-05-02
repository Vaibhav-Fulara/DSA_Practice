class Solution {
    public int[] sortEvenOdd(int[]arr) {
        List<Integer>odd = new ArrayList<>();
        List<Integer>even = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(i%2 == 0) even.add(arr[i]);
            else odd.add(arr[i]);
        }
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);
        int o=0, e=0;
        for(int i=0; i<arr.length; i++){
            if(i%2 == 0) arr[i] = even.get(e++);
            else arr[i] = odd.get(o++);
        }
        return arr;
    }
}