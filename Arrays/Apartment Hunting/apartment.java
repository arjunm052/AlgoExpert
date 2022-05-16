public class apartment {
    public static void main(String[] args) {
        
    }

    //TC - O(B^2R)    SC - O(B)
    //For each block, we find the maximum of the minimum distance we have to travel to reach each
    //requirement. Basically we calculate the farthest distance we'd have to travel from any block.
    //After computing this we can traverse this array and return the index in which we have to travel the
    //minimum distance from the block that covers all the requirements.
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        //Initialize the array that holds max distance to travel from each block that covers all requirements
        int[] maxFromEachBlock = new int[blocks.size()];
        //Initialize the array with MIN_vALUE
        Arrays.fill(maxFromEachBlock,Integer.MIN_VALUE);
        
        //We calculate the farthest distance for every block
        for(int i = 0; i < blocks.size(); i++){
            //For every block we look at all the requirements
            for(String req: reqs){
                //Calculate the minimum distance of requirement from current block
                int closestReqDistance = Integer.MAX_VALUE;
                for(int j = 0; j < blocks.size(); j++){
                    //If the block has the requirement then we update the closest distance
                    if(blocks.get(j).get(req)){
                        closestReqDistance = Math.min(closestReqDistance, Math.abs(i-j));
                    }
                }
                //Find the maximum of all the minimum distances of requirements
                maxFromEachBlock[i] = Math.max(maxFromEachBlock[i],closestReqDistance);
            }
        }
        //This function returns the index of minimum number in the array
        return minFromArray(maxFromEachBlock);
      }
    
    //Function that returns the index of minimum number in array
    public static int minFromArray(int[] array){
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i<array.length; i++){
            int value = array[i];
            if(value<minValue){
                minValue = value;
                minIndex = i;
            }
        }
        
        return minIndex;
    }
}
