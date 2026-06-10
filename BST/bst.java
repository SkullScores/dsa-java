package BST;
import java.util.*;

public class BST
{
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=right;
        }
    }

    public static Node insert(Node root, int target)
    {
        if(root==null)
        {
            root = new Node(target);
            return root;
        }

        if(root.data > target)
        {
            //LS
            root.left = insert(root.left, target);
        }
        else
        {
            root.right = insert(root.right, target);
        }

        return root;
    }

    public static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // Recursive Search
    public static boolean search(Node root, int key)
    {
        if(root==null)
        {
            return false;
        }

        if(root.data > key)
        {
            //LS
            return search(root.left, key);
        }
        else if(root.data==key)
        {
            return true;
        }
        else
        {
            return search (root.right, key);
        }
    }

    // Iterative Search (No recursion stack)
    public static Node searchBST(Node root, int target)
    {
        while(root!=null && root.data!=target)
        {
            root = root.data<target ? root.left : root.right;
        }

        // while(root!=null && root.data!=target)
        // {
        //     if(target<root.data)
        //     {
        //         root=root.left;
        //     } 
        //     else
        //     {
        //         root=root.right;
        //     }
        // }

        //return the node if found, otherwise null
        return root;
    }

    public static Node delete(Node root, int val)
    {
        if(root.data > val)
        {
            root.left = delete(root.left, val);
        }
        else if(root.data < val)
        {
            root.right = delete(root.right, val);
        }
        else // root.data == val (till now we were just searching exactly like BST search)
        {
            //case 1: No children
            if(root.left==null && root.right==null)
            {
                // Ab root ko delete karna hai & uska left & right both are null
                // Simplest method: root ke parent ko null hi return kardo taaki jab woh apna child banayega woh apne aap usme null hi atach kardega
                // root ki value hamesha ke liye lost ho jayegi
                return null;
            }

            //case 2: 1 child
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }

            //case 3: 2 children
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node inorderSuccessor(Node root)
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
}

public static void main(String[] args)
    {
        int[] values = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0; i<values.length; i++)
        {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
    }
