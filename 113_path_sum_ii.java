/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    public void dfs(
        TreeNode root,
        int targetSum,
        List<Integer> path,
        List<List<Integer>> result
    ) {

        // Base case
        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.val);

        // Subtract current value
        targetSum = targetSum - root.val;

        // Check leaf
        if (root.left == null && root.right == null) {

            if (targetSum == 0) {
                result.add(new ArrayList<>(path));
            }
        }

        // Go left
        dfs(root.left, targetSum, path, result);

        // Go right
        dfs(root.right, targetSum, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}