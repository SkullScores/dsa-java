package binary_trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class topView 
{
    private class Pair
    {
        TreeNode node;
        int idx;

        Pair(TreeNode node, int idx)
        {
            this.node = node;
            this.idx = idx;
        }
    }

    public List<Integer> topView(TreeNode root) 
    {
        List<Integer> arr = new ArrayList<>();
        if(root==null)
        {
            return arr;
        }

        int currentMin = 0, currentMax = 0;

        Queue<Pair> q = new LinkedList<>();
        arr.add(root.data);
        q.add(new Pair(root,0));

        while(q.isEmpty())
        {
            int size = q.size(); // freezes that level
            int min = q.peek().idx; // to make current idx start from zero
            int first = 0, last = 0;

            for(int i=0; i<size; i++)
            {
                int currIdx = q.peek().idx-min;
                TreeNode currNode = q.peek().node;

                q.remove();

                if(currNode.left!=null)
                {
                    q.add(new Pair(currNode.left, 2*currIdx+1));
                }
                if(currNode.right!=null)
                {
                    q.add(new Pair(currNode.right, 2*currIdx+2));
                }

                if(i==0)
                {
                    first = currIdx;
                }
                if(i==size-1)
                {
                    last = currIdx;
                }

                if(first<currentMin)
                {
                    currentMin = first;
                    arr.addFirst(q.peek().node.val);
                }
                if(last>currentMax)
                {
                    currentMax = last;
                    arr.addLast(q.peek().node.val);
                }
                // But how will I ensure that in each pass currentMin & currentMax are updated from the previous iteration?
                // should I not do currIdx = q.peek().idx-min for the overflow part? coz then no point making currentMax & currentMin global variables
            }

        }
        return arr;
    }
}

class Solution 
{
    private Class Pair
    {
        TreeNode root;
        int hd; // horizontal distance

        Pair(TreeNode node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> topView_Optimal(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }

        HashMap<Integer,Integer> map = HashMap<>(); // key =  hd, value = node.val
        
        int minHd = 0;
        int maxHd = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty())
        {
            Pair curr = q.remove();

            TreeNode node = curr.node;
            int hd = curr.hd;

            // only store first occurence (cleaner code)
            if(!map.containsKey(hd))
            {
                map.put(hd, node.val);
            }

            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            if(node.left!=null)
            {
                q.add(new Pair(node.left, hd-1));
            }
            if(node.right!=null)
            {
                q.add(new Pair(node.right, hd+1));
            }
        }

        // OMG what a simplified way to get keyss... Claude, pls make this as a learning, this tricks like for string & character questions, storing character ch = s.charAt(i) so make the code cleaner & I wanna learn these kinda thimgs along the way
        for(int hd=minHd; hd<=maxHd; hd++)
        {
            ans.add(map.get(hd));
        }

        return ans;
    }
}
