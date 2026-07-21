class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    boolean isEven;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        isEven = true;
    }
    
    public void addNum(int num) {
        if(isEven){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        if(isEven){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;        
        }
        return (double) minHeap.peek();
    }
}
