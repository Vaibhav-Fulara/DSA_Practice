class MyCircularQueue {
    int[]arr;
    int i=0, j=0;
    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
    }
    
    public boolean enQueue(int value) {
        if(j == i && arr[i] != -1) return false;
        arr[j] = value;
        j = (j+1) % arr.length;
        return true;
    }
    
    public boolean deQueue() {
        if(i == j && arr[i] == -1) return false;
        arr[i] = -1;
        i = (i+1) % arr.length;
        return true;
    }
    
    public int Front() {
        return arr[i];
    }
    
    public int Rear() {
        return arr[(j-1+arr.length)%arr.length];
    }
    
    public boolean isEmpty() {
        return j==i && arr[i] == -1;
    }
    
    public boolean isFull() {
        return j == i && arr[i] != -1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */