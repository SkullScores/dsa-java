package binary_trees;

import java.util.Queue;

import javax.swing.tree.TreeNode;

class Pair
{
    TreeNode node;
    int idx;

    Pair(TreeNode node, int idx)
    {
        this.node = node;
        this.idx = idx;
    }
}

public class maxWidthOfBT 
{
    public int widthOfBinaryTree(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }

        int maxWidth = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty())
        {
            int size = q.size(); //freezes that level
            int min = q.peek().idx; //to make the idx starting from zero
            int first = 0, last = 0;
            
            for(int i=0; i<size; i++)
            {
                int currIdx = q.peek().idx;
                TreeNode currNode = q.peek().node;

                q.remove();
                
                if(i==0)
                {
                    first = currIdx;
                }
                if(i==size-1)
                {
                    last = currIdx;
                }

                if(currNode.left!=null)
                {
                    q.add(new Pair(currNode.left, 2*currIdx+1));
                }
                if(currNode.right!=null)
                {
                    q.add(new Pair(currNode.right, 2*currIdx+2));
                }
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}
