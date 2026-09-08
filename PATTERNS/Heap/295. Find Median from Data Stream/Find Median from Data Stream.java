// TC : Overall TC is O(log N) for the addNum method and O(1) for the findMedian method.
// SC : O(N).
class MedianFinder {

    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        //keep smaller into the left and >than left on right 
        // Make sure every left element <= every right element  while inserting into the heap
        if(leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()){
            leftMaxHeap.add(num);
        }
        else{
            rightMinHeap.add(num);
        }

        // Balance both the heap sizes
        if(leftMaxHeap.size() > rightMinHeap.size() + 1){
            rightMinHeap.add(leftMaxHeap.poll());
        }
        else if(leftMaxHeap.size() < rightMinHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {

        // for ODD no of elements
        if(leftMaxHeap.size() > rightMinHeap.size()){
            return leftMaxHeap.peek();
        }
        return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0; //EVEN no of elements
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */