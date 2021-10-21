package com.google.leetcode;

import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = root;
        while (root != null && !stack.isEmpty()) {
            while (root != null) {
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                ans.add(root.val);
                pre = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}

// 1. left -> push, to bottom
// 3. print
// 4. pop
// 5. right
// 6. print
// 7. pop -> print