package BST;

import java.util.ArrayList;

public class Root2Leaf 
{
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path)
    {
        if(root==null)
        {
            return;
        }

        path.add(root.data);

        //Condition 2: whenever we realise we are at leaf node
        if(root.left==null && root.right==null)
        { // leaf
            printPath(path);
        }
        else // non-leaf
        {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        // remove kardenge node ko path se kyunki ab ham backtrack karne waale hai
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path)
    {
        for(int i=0; i<path.size(); i++)
        {
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
}
