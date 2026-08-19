class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<Integer>((a,b) -> (a-b)); //larger half(smallest at front)
        maxHeap=new PriorityQueue<Integer>((a,b) -> (b-a)); //smaller half(larger at the front)
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size()-minHeap.size() > 1 || (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())){
            minHeap.add(maxHeap.remove());
        }
        if(minHeap.size()-maxHeap.size() > 1){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else if(minHeap.size()<maxHeap.size()){
            return maxHeap.peek();
        }else{
            return minHeap.peek();
        }

    }
}
