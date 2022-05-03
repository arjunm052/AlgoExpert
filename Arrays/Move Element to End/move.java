import java.util.*;

public class move {
    public static void main(String[] args) {
        
    }   

    //TC - O(N)  SC - O(1)
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i =0;
            int start = array.size();
            
            while(i<array.size() && i<start){
                if(array.get(i)==toMove){
                    start--;
                    int temp = array.get(i);
                    array.set(i,array.get(start));
                    array.set(start,temp);
                    continue;
                }
                i++;
            }
        return array;
      }
}
