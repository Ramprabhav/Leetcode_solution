class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
      Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1],a[1]));
      int max_unit = 0;

      for(int i = 0; i < boxTypes.length; i++) {

        int pick_box = boxTypes[i][0];
        int pick_perunit = boxTypes[i][1];
        
        int pick_small_size = Math.min(pick_box, truckSize);

        max_unit += pick_small_size * pick_perunit;

        truckSize -= pick_small_size;

        if(truckSize == 0){
            break;
        } 
    }    
     
      return max_unit;
    }
   
}