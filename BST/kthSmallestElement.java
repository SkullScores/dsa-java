package BST;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class kthSmallestElement 
{
    // For kth Largest just do reverse inorder

    class BruteForce
    {
        public void inorder(TreeNode root, ArrayList<Integer> arr)
        {
            if(root==null)
            {
                return;
            }

            inorder(root.left, arr);
            arr.add(root.data);
            inorder(root.right, arr);
        }

        public int kthSmallest(TreeNode root, int k)
        {
            ArrayList<Integer> arr = new ArrayList<>();
            inorder(root,arr);

            return arr.get(k-1);
        }
    }

    class Optimal 
    {
        int cnt=0;
        int ans=0;

        public void inorder(TreeNode root, int k)
        {
            if(root==null)
            {
                return;
            }

            inorder(root.left,k);
            cnt++;
            if(cnt==k)
            {
                ans = root.value;
                return;
            }
            inorder(root.right,k);
        }

        public int kthSmallest(TreeNode root, int k) 
        {
            inorder(root,k);
            return ans;
        }
    }
}
