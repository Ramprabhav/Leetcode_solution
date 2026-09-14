class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {

            int frequency = map.get(num);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(num);
        }

        // Step 3: Get top k frequent elements
        int[] ans = new int[k];
        int index = 0;

        for (int frequency = bucket.length - 1;
             frequency >= 0;
             frequency--) {

            if (bucket[frequency] != null) {

                for (int num : bucket[frequency]) {

                    ans[index] = num;
                    index++;

                    if (index == k) {
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
}