class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int winsum = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            winsum += arr[i];
        }
        if(winsum >= threshold * k){
            count++;
        }

        for(int i = k; i< arr.length; i++){
            winsum -= arr[i - k];
            winsum += arr[i];
            if(winsum >= threshold * k){
            count++;
           }
        }
        return count;
    }
}