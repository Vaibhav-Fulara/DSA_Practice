class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int iter = Integer.MIN_VALUE;
        List<List<Integer>>al=new ArrayList<List<Integer>>();
        int height = 0;
        for(int i=0; i<arr.length-2; i++){
            if(arr[i]==iter) continue;
            iter = arr[i];
            List<Integer>bruh = new ArrayList<>();
            bruh.add(arr[i]);
            int sec = i+1;
            int third = arr.length-1;
            while(sec<third){
                int y = arr[sec];
                int z = arr[third];
                if(iter+y+z<0) sec++;
                else if(iter+y+z>0) third--;
                else{
                    al.add (new ArrayList<Integer>());
                    al.get(height).add(iter);
                    al.get(height).add(y);
                    al.get(height).add(z);
                    while (sec<third && arr[sec] == arr[sec+1]) sec++;
                    while (sec<third && arr[third] == arr[third-1]) third--;
                    sec++;
                    third--;
                    height++;
                }
            }
        }
        return al;
    }
}