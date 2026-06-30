import java.util.*;


class LCA
{
    // My thinking
    public void f(TreeNode root, ArrayList<Integer> ds, ArrayList<Integer> list1, ArrayList<Integer> list2, TreeNode p, TreeNode q)
    {
        if(root==null)
        {
            if(ds.get(ds.size()-1)==p)
            {
                //list1 = ds for p
            }
            
            if(ds.get(ds.size()-1)==q)
            {
                //list2 = ds for q
            }
            return;
        }

        ds.add[root.data];
        f(root.left,ds,p,q);
        ds.remove(ds.size()-1); // backtrack
        f(root.right,ds,p,q);
    }

    public TreeNode myThinking_main(TreeNode root, TreeNode p, TreeNode q)
    {
        ArrayList<Integer> ds = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        f(root,ds,list1,list2,p,q);

        // compare both lists to get last common element & return
    }

    // Correct code & way to approach for my thinking

    public boolean g(TreeNode root, int target, ArrayList<TreeNode> ds)
    {
        if(root==null)
        {
            return false;
        }

        ds.add(root);

        if(root==target) // found it, path is recorded
        {
            return true;
        }

        if(g(root.left,target,ds) || g(root.right,target,ds))
        {
            return true;
        }

        ds.remove(ds.size()-1); //backtrack
        return false;
    }

    public TreeNode betterCode_main(TreeNode root, TreeNode p, TreeNode q)
    {
        ArrayList<Integer> pathP = new ArrayList<>();
        ArrayList<Integer> pathQ = new ArrayList<>();
        
        g(root,p,pathP);
        g(root,q,pathQ);

        int i=0;
        while(i<pathP.size() && pathQ.size() && pathP.get(i)==pathQ.get(i))
        {
            i++;
        }

        return pathP.get(i-1);
    }

    // Optimal
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        // base case
        if(root==null || root==p || root==q)
        {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // result
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        else //if both left & right return non-null, we found our LCA
        {
            return root;
        }
    }
}