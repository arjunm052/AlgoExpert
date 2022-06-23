class Program {
    static class ContinuousMedianHandler {

        // ******TC - O(NlogN) SC - O(N) *****

        // median will hold the value of median at any given instant
        double median = 0;
        // Initialize a min heap
        PriorityQueue<Integer> greaterHalf = new PriorityQueue<Integer>();
        // intialize a max heap
        PriorityQueue<Integer> smallerHalf = new PriorityQueue<Integer>(Comparator.reverseOrder());

        // Function to insert a number
        public void insert(int number) {
            // If maxHeap is empty or the current number is smaller than root of max heap,
            // insert the new number in max heap
            if (smallerHalf.isEmpty() || number < smallerHalf.peek()) {
                smallerHalf.add(number);
            }
            // else insert the number in the min heap
            else {
                greaterHalf.add(number);
            }

            // if the different of size of both the heaps becomes 2 then we need to
            // rebalance the heap
            if (Math.abs(greaterHalf.size() - smallerHalf.size()) == 2) {
                rebalanceHeaps();
            }

            // Update the median after every insertion
            updateMedian();
        }

        // If difference of size of heaps is greater than 1 then we take an element from
        // bigger heap and insert it in the smaller heap
        public void rebalanceHeaps() {
            if (smallerHalf.size() > greaterHalf.size()) {
                greaterHalf.add(smallerHalf.poll());
            } else {
                smallerHalf.add(greaterHalf.poll());
            }
        }

        // Function that is used to update the value of median
        public void updateMedian() {
            // If size of both heaps is equal then take their average and update median
            if (smallerHalf.size() == greaterHalf.size()) {
                median = (smallerHalf.peek() + greaterHalf.peek()) / 2.0;
            }
            // Else take the element from the heap with greater ssize and update median
            else if (smallerHalf.size() > greaterHalf.size()) {
                median = smallerHalf.peek();
            } else {
                median = greaterHalf.peek();
            }
        }

        // Function to return the value of median at any given instant
        public double getMedian() {
            return median;
        }
    }
}
