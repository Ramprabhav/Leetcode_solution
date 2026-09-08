class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxsum = 0;
        double windsum = 0;
        for(int i = 0; i < k; i++){
            windsum += nums[i];
        }
        maxsum = windsum;
        for(int i = k; i < nums.length; i++){
            windsum = windsum - nums[i - k];
            windsum = windsum + nums[i];
            maxsum = Math.max(maxsum,windsum);
        }
        return (double) maxsum / k;
    }
}