import java.util.*;

public class tourna {
    public static void main(String[] args) {
        
    }

    //TC - O(N)  SC - O(K)
    //Create a HashMap that will be the points table of the tournament. Go through the matches and update
    //the hashmap. Then find the team with the most points. 
    public String tournamentWinner(
        ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
            int maxPoints = -1;
            String res = "";
            for(int i = 0; i<competitions.size(); i++){
                ArrayList<String> match = competitions.get(i);
                int winner = results.get(i);
                String winTeam = winner==1?match.get(0):match.get(1);
                map.put(winTeam,map.getOrDefault(winTeam,0)+3);
            }
            
            for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value =  (int)mapElement.getValue();
                            if(value>maxPoints){
                                res = key;
                                maxPoints = value;
                            }          
            }
            
            return res;
    }

}