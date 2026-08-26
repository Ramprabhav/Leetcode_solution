class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Long> sums = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                sum += curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            sums.add(sum);
        }

        if (sums.size() < k) {
            return -1;
        }

        Collections.sort(sums, Collections.reverseOrder());

        return sums.get(k - 1);
    }
}