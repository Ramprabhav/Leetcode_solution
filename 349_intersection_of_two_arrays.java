class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    if (list.isEmpty()) {
                        list.add(nums1[i]);
                    } else {

                        boolean isPresent = false;
                        int k = list.size() - 1;

                        while (k >= 0) {

                            if (list.get(k) == nums1[i]) {
                                isPresent = true;
                                break;
                            }

                            k--;
                        }

                        if (isPresent == false) {
                            list.add(nums1[i]);
                        }
                    }
                }
            }
        }

        // Convert ArrayList<Integer> → int[]
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}