import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Find next greater element for every element in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {

            int num = nums2[i];

            // Remove elements that cannot be next greater
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // Find answer
            if (stack.isEmpty()) {
                map.put(num, -1);
            } else {
                map.put(num, stack.peek());
            }

            // Add current element
            stack.push(num);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}