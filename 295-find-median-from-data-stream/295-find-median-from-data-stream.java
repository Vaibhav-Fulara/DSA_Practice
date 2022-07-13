class MedianFinder {
    PriorityQueue<Integer>p1;
    PriorityQueue<Integer>p2;
    public MedianFinder() {
        p1 = new PriorityQueue<>((a,b) -> b-a);
        p2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(p1.isEmpty() || p1.peek() > num) p1.add(num);
        else p2.add(num);
        if(p1.size() > p2.size()+1) p2.add(p1.remove());
        if(p2.size() > p1.size()) p1.add(p2.remove());
        // System.out.println(p1.size() + " " + p2.size());
    }
    
    public double findMedian() {
        if(p1.size() == p2.size()) return (double)(p1.peek() + p2.peek())/2;
        else return p1.peek();
    }
}

/*
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */