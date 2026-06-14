package BST;

import javax.swing.tree.TreeNode;

public class ValidBST 
{
    class Initial_Thinking // Not a complete soln
    {
        public boolean isValidBST(TreeNode root) 
        {
            if(root==null)
            {
                return true;
            }

            //leaf-nodes
            if(root.left==null && root.right==null)
            {
                return true;
            }

            //1 child
            if(root.left==null)
            {
                if(root.right.val > root.val && isValidBST(root.right))
                {
                    return true;
                }
                return false;
            }

            if(root.right==null)
            {
                if(root.val > root.left.val && isValidBST(root.left))
                {
                    return true;
                }
                return false;
            }

            //non-leaf nodes
            if(root.val > root.left.val && root.val < root.right.val && isValidBST(root.left) && isValidBST(root.right))
            {
                return true;
            }

            return false;
        }
    }

    class Solution 
    {

        // Correct thinking:
        // BST validity is not just a parent-child property (its a subtree wide constraint)
        // Its a range constraint inherited from ancestors
        // For every node:
        // lower_bound < node.val < upper_bound


        public boolean helper(TreeNode root, long min, long max)
        {
            if(root==null)
            {
                return true;
            }

            if(root.val <= min || root.val >= max)
            {
                return false;
            }

            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }

        public boolean isValidBST(TreeNode root) 
        {
            // initial range = (-infinity, +infinity)
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }
}
