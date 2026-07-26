import java.util.*;

import javax.swing.tree.TreeNode;

public class serializeANDdeserialize 
{
    public String serialize(TreeNode root)
    {
        if(root==null)
        {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node==null)
            {
                res.append("# ");
                continue;
            }
            res.append(node.data+" ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    public TreeNode deserialize(String data)
    {
        if(data.equals(""))
        {
            return null;
        }

        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        int i=1;

        while(!q.isEmpty())
        {
            TreeNode parent = q.poll();

            if(!values[i].equals("#"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.add(left);
            }
            i++;

            if(!value[i].equals("#"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }
}
