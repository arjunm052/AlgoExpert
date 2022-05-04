import java.util.*;

public class move {
    public static void main(String[] args) {
        
    }   

    //TC - O(N)  SC - O(1)
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        //Initialize a pointer to traverse the array
        int i =0;
        //start pointer points to the starting index of the toMove element window
        int start = array.size(); 
        //Traverse the whole array or until i passes the starting index of toMove window as now
        //there will be no more elements to swap
        while(i<array.size() && i<start){
            //Compare the current element. If it is toMove element then decrement the start pointer and swap
            //teh values. And continue the while loop
            if(array.get(i)==toMove){
                start--;
                int temp = array.get(i);
                array.set(i,array.get(start));
                array.set(start,temp);
                continue;
            }
            //Else just move on to the next element
            i++;
        }
        //return the final result
        return array;
      }
}
