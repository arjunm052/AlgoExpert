import java.util.*;

class program {

    // TC - O(NlogN) SC - O(N)
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        // Base Case
        if (times.size() == 0) {
            return 0;
        }
        // Sorting the time intervals according to their starting time
        Collections.sort(times, (o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));
        // Initialize a min heap that stores the end time of intervals, the size of heap
        // will denote the no. of laptops in use at the moment
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // We traverse over all the intervals
        for (ArrayList<Integer> interval : times) {
            // Condition to push first interval in the heap
            if (pq.size() == 0) {
                pq.add(interval.get(1));
                continue;
            }

            // If the end time of the laptop in heap is less than or equal to the start time
            // of current interval
            // we can use this laptop and don't need a new one
            if (pq.peek() <= interval.get(0)) {
                pq.remove();
            }

            // Since the laptop is now in use again, push this laptop back in heap
            pq.add(interval.get(1));
        }

        // return the final size of heap which will be the minimum no. of laptops used
        return pq.size();
    }
}