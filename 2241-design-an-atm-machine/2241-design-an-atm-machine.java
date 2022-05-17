class ATM {
    int[]notes = {20, 50, 100, 200, 500};
    long[]arr;
    
    public ATM() {
        arr = new long[5];
    }
    
    public void deposit(int[] bknotes) {
        for(int i=0; i<bknotes.length; i++) arr[i] += bknotes[i];
    }
    
    public int[] withdraw(int amount) {
        int[]ans = new int[5];
        for(int i=4; i>=0; i--){
            ans[i] = (int) Math.min(arr[i], (long)amount/notes[i]);
            amount -= ans[i]*notes[i];
        }
        
        if(amount != 0) return new int[] {-1};
        for(int j=0; j<5; j++) arr[j] -= ans[j];
        return ans;
    }
}
