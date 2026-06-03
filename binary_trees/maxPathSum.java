package binary_trees;

import javax.swing.tree.TreeNode;

public class Brute_Force_Soln
{
    int ans = Integer.MIN_VALUE;

    public int maxPathSum_BruteForce(TreeNode root) 
    {
        traverse(root);
        return ans;
    }

    // "If I am FORCED to start at this node and move only downward, what is the maximum sum I can get?"
    private int maxDown(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        // Negative sum does NOT give me max!
        int left = maxDown(root.left);
        int right = maxDown(root.right);

        return Math.max(0, Math.max(left, right));
    }

    // For every node: Assume THIS node is the highest point of the path
    // then calc: node.val + best downward path on left + best downward path on right
    private int traverse(TreeNode node)
    {
        if(node==null)
        {
            return;
        }

        int left = Math.max(0, maxDown(node.left));
        int right = Math.max(0, maxDown(node.right));

        ans = Math.max(ans, node.val+left+right);

        traverse(node.left);
        traverse(node.right);
    }
}

public class maxPathSum
{
    // global variable to store max sum
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum_optimal(TreeNode root) 
    {
        maxDown(root);
        return maxSum;
    }

    //DFS recursive funcn
    private int maxDown(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        // calc left & right subtree maxPathSum
        int left = Math.max(0, maxDown(root.left));
        int right = Math.max(0, maxDown(root.right));

        // update max sum considering current node
        maxSum = Math.max(maxSum, root.val+left+right);

        // return ONE-SIDED PATH
        return root.val + Math.max(left,right);
    }
}
