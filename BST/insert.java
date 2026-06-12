package BST;

class insert 
{
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        if(root==null)
        {
            return new TreeNode(val);
        }

        TreeNode head = root;

        while(true)
        {
            if(val < root.val)
            {
                if(root.left==null)
                {
                    root.left = new TreeNode(val);
                    break;
                }
                root = root.left;
            }
            else
            {
                if(root.right==null)
                {
                    root.right = new TreeNode(val);
                    break;
                }
                root = root.right;
            }
        }

        return head;
    }
}
