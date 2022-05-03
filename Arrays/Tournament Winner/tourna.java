import java.util.*;

public class tourna {
    public static void main(String[] args) {
        
    }

    //TC - O(N)  SC - O(K)
    //Create a HashMap that will be the points table of the tournament. Go through the matches and update
    //the hashmap. Then find the team with the most points. 
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
            //Use a hashmap to keep track of points of all teams
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            //Maxpoints and res stores the points and name of the winner
            int maxPoints = -1;
            String res = "";
            //Fill up the HashMap by awarding 3 points to the winning team in HashMap
            for(int i = 0; i<competitions.size(); i++){
                ArrayList<String> match = competitions.get(i);
                int winner = results.get(i);
                String winTeam = winner==1?match.get(0):match.get(1);
                map.put(winTeam,map.getOrDefault(winTeam,0)+3);
            }
            
            //Traverse through the HashMap and find the team with the maximum points
            for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value =  (int)mapElement.getValue();
                 if(value>maxPoints){
                      res = key;
                      maxPoints = value;
                 }          
            }
            
            //Return the final result
            return res;
     }

}
