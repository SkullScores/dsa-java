import java.util.*;

import javax.swing.tree.TreeNode;

public class floorCeil
{
    public List<Integer> floorCeilOfBST(TreeNode root, int key) 
    {
        int floor = -1;
        int ceil = -1;
        
        while(root!=null)
        {
            if(key==root.val)
            {
                floor = key;
                ceil = key;
                break;
            }
            
            if(key < root.val)
            {
                ceil = root.val;
                root = root.left;
            }
            else
            {
                floor = root.val;
                root = root.right;
            }
        }
        
        return Arrays.asList(floor,ceil);
    }
}