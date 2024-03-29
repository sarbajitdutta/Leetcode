package com.leetcode.medium;

public class LowestCommonAncestorBT {
	
	public class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
		  
	}
	
	public static void main(String[] args) {
		
		LowestCommonAncestorBT tree = new LowestCommonAncestorBT();
		
		tree.ans = tree.new TreeNode(1);
        tree.ans.left = tree.new TreeNode(2); 
        tree.ans.right = tree.new TreeNode(3); 
        tree.ans.left.left = tree.new TreeNode(4); 
        tree.ans.left.right =tree.new TreeNode(5); 
        tree.ans.right.left = tree.new TreeNode(6); 
        tree.ans.right.right = tree.new TreeNode(7); 
        
        tree.lowestCommonAncestor(tree.ans, tree.new TreeNode(2), tree.new TreeNode(4));
		
	}
	
	private TreeNode ans;
	
	public LowestCommonAncestorBT() {
        // Variable to store LCA node.
        this.ans = null;
    }
	
	private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
