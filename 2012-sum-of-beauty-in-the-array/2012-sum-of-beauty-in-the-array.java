class Solution {
    public int sumOfBeauties(int[] arr) {
        int n = arr.length;
        int[]bfl = new int[n];
        int[]sfr = new int[n];
        bfl[0] = arr[0];
        sfr[n-1] = arr[n-1];
        
        for(int i=1; i<n; i++) {
            bfl[i] = Math.max(arr[i], bfl[i-1]);
            sfr[n-i-1] = Math.min(arr[n-i-1], sfr[n-i]);
        }
        
        // for(int i=0; i<n; i++) {
        //     System.out.println(sfr[i] +" "+ bfl[i]);
        // }
        
        int beauty = 0;
        for(int i=1; i<n-1; i++) {
            if(bfl[i-1] < arr[i] && sfr[i+1] > arr[i]) {
                beauty += 2;
            } else if(arr[i-1] < arr[i] && arr[i] < arr[i+1]) {
                beauty += 1;
            }
        }
        
        return beauty;
    }
}

// 1 2 3 4 5 7 8 9 10
// 1 2 3 4 5 7 8 9 10