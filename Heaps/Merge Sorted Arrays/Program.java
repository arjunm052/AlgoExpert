import java.util.*;

class Program {

    // Declare a pair class that will hold the value of an element, the index of
    // array it belongs to, and its index in it's array
    static class Pair {
        int value;
        int arrayIndex;
        int elementIndex;

        Pair(int val, int elementIdx, int arrayIdx) {
            this.value = val;
            this.elementIndex = elementIdx;
            this.arrayIndex = arrayIdx;
        }
    }

    // *** TC - O(NlogK) + O(N+k) *** where N is the no. of elements and k is the
    // total no.
    // of arrays to merge
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Initialize the resultant array
        List<Integer> res = new ArrayList<Integer>();

        // Base Case
        if (arrays.size() == 0) {
            return res;
        }

        // Initialize the Min Heap
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(10, (a, b) -> Integer.compare(a.value, b.value));

        // Push all the first elements of each array in the min heap
        for (int i = 0; i < arrays.size(); i++) {
            heap.add(new Pair(arrays.get(i).get(0), 0, i));
        }

        // While the heap is not empty
        while (heap.size() != 0) {
            // We take out the minimum element from the heap
            Pair minElement = heap.poll();
            // add it to the final result
            res.add(minElement.value);

            // If we have finished traversing all the elements in this particular array,
            // then continue to next iteration
            if (minElement.elementIndex == arrays.get(minElement.arrayIndex).size() - 1) {
                continue;
            }

            // Otherwise add the next element to the heap
            heap.add(new Pair(arrays.get(minElement.arrayIndex).get(minElement.elementIndex + 1),
                    minElement.elementIndex + 1, minElement.arrayIndex));
        }

        // Return the final resultant sorted array
        return res;
    }
}
