class MyCircularDeque {
    int i=0, j=0;
    int[]arr;
    public MyCircularDeque(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
    }
    
    public boolean insertFront(int value) {
        if(i == j && arr[i] != -1) return false;
        i = (i-1+arr.length)%arr.length;
        arr[i] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(i == j && arr[i] != -1) return false;
        arr[j] = value;
        j = (j+1)%arr.length;
        return true;
    }
    
    public boolean deleteFront() {
        if(i == j && arr[i] == -1) return false;
        arr[i] = -1;
        i = (i+1) % arr.length;
        return true;
    }
    
    public boolean deleteLast() {
        if(i == j && arr[i] == -1) return false;
        j = (j-1+arr.length) % arr.length;
        arr[j] = -1;
        return true;
    }
    
    public int getFront() {
        return arr[i];
    }
    
    public int getRear() {
        return arr[(j-1+arr.length) % arr.length];
    }
    
    public boolean isEmpty() {
        return i == j && arr[i] == -1;
    }
    
    public boolean isFull() {
        return i == j && arr[i] != -1;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */