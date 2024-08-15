package io.nnc.bookinfoservice.algorithm.leetcode;

public class SortedArrayToBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    return build(0, nums.length-1, nums);
  }

  public TreeNode build(int l, int h, int[] nums) {
    if (l > h) return null;
    int mid = l + (h - l) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(l, mid-1, nums);
    root.right = build(mid+1, h, nums);
    return root;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
