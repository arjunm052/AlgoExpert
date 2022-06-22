class Program {
    static class MinHeap {
        // Global Heap
        List<Integer> heap = new ArrayList<Integer>();

        // Function called to build the heap
        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // Build Heap Function ***** TC - O(N) SC - O(logN) ******
        public List<Integer> buildHeap(List<Integer> array) {
            // Get size of the array
            int size = array.size();
            // Traverse through all the internal nodes from left to right and call the
            // siftDown function on each node
            for (int i = size - 2 / 2; i >= 0; i--) {
                siftDown(i, size - 1, array);
            }
            // return the min heap generated
            return array;
        }

        // Function to bubble down an element until it becomes a leaf node or is smaller
        // than both its children nodes *****TC - O(logN) SC - O(logN) ******
        public void siftDown(int currentIdx, int size, List<Integer> heap) {
            // Smallest will hold index value of node aong currnode and its children
            int smallest = currentIdx;
            // Get left child of current index
            int left = 2 * currentIdx + 1;
            // Get right child of current index
            int right = 2 * currentIdx + 2;

            // If left child exists and is smaller than currNode update the smallest index
            if (left <= size && heap.get(left) < heap.get(currentIdx)) {
                smallest = left;
            } else {
                smallest = currentIdx;
            }

            // if right child exists and is smaller than the current node value at smallest
            // index then update the smallest index
            if (right <= size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            // If a smaller value is found in child then swap the currentnode with the child
            // and apply this siftdown algorithm on the smallest index recursively
            if (smallest != currentIdx) {
                swap(heap, currentIdx, smallest);
                siftDown(smallest, size, heap);
            }

        }

        // Function that bubbles up the newly added element until it becomes larger than
        // its parent or it becomes the root node
        public void siftUp(int currentIdx, List<Integer> heap) {
            // Swap node with its prent unless it becomes root node or is greater than its
            // parent
            while (currentIdx > 0 && heap.get((currentIdx - 1) / 2) > heap.get(currentIdx)) {
                swap(heap, (currentIdx - 1) / 2, currentIdx);
                currentIdx = (currentIdx - 1) / 2;
            }
        }

        // Function to peek at the root element of heap ***** TC - O(1) *****
        public int peek() {
            if (heap.size() == 0) {
                return -1;
            }
            return heap.get(0);
        }

        // Function to pop a value from heap ***** TC - O(logN) SC - O(logN) *****
        public int remove() {
            // Get heap size
            int size = heap.size();
            // If the heap has any elements
            if (size > 0) {
                // pop the root element
                int res = heap.get(0);
                // swap the root element with the last element of heap
                swap(heap, 0, size - 1);
                // remove the last element
                heap.remove(size - 1);
                // siftDown the newly replaced root element
                siftDown(0, size - 1, heap);
                // return the popped element
                return res;
            }
            // If heap has no elements return -1
            return -1;
        }

        // Function to insert a value in heap **** TC - O(logN) SC - O(1) ******
        public void insert(int value) {
            // Add the value in heap
            heap.add(value);
            // Call siftup function
            siftUp(heap.size() - 1, heap);
        }

        // Function used to sawp two integers in a list
        public static void swap(List<Integer> array, int i, int j) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }
}
