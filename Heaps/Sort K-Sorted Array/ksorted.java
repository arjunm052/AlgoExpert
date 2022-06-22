public class ksorted {
    public static void main(String[] args) {

    }

    // TC - O(NlogK) SC - O(N)
    // Function to sort a k sorted array
    public int[] sortKSortedArray(int[] array, int k) {
        // Initialize the resultant array
        int[] res = new int[array.length];
        // Initialize a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // Initialize the index variable to store values in resultant array
        int idx = 0;

        // Start traversing through the array and push the elements in the minHeap
        for (int val : array) {
            // If the size of minheap ever becomes k+1 we pop the element and store it in
            // resultant array
            if (minHeap.size() > k) {
                res[idx++] = minHeap.poll();
            }
            // add the element to the heap
            minHeap.add(val);
        }

        // Add the remaining element to the resultant array
        while (minHeap.size() != 0) {
            res[idx++] = minHeap.poll();
        }

        //Return the final sorted array
        return res;
    }
}
