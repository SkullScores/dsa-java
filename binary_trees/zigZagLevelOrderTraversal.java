package binary_trees;
import java.util.*;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class zigZagLevelOrderTraversal 
{
    public List<List<Integer>> zigzagLevelOrder(Node head) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if(head==null)
        {
            return result;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(head);
        boolean leftToRight = true;

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<size; i++)
            {
                Node curr = q.remove();

                if(leftToRight)
                {
                    level.addLast(curr.data);
                }
                else
                {
                    level.addFirst(curr.data);
                }

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            result.add(level);
            leftToRight = !(leftToRight);
        }
        return result;
    }
}
