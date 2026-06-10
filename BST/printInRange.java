package BST;

import java.security.cert.X509CRL;

public class printInRange 
{
    public static void printInRange(Node root, int X, int Y)
    {
        if(root==null)
        {
            return;
        }

        if(root.data > Y)
        {
            printInRange(root.left,X,Y);
        }
        else if(root.data < X)
        {
            printInRange(root.right,X,Y);
        }
        else // root.data>=X && root.data<=Y
        {
            printInRange(root.left,X,Y);
            System.out.print(root.data+" ");
            printInRange(root.right,X,Y);
        }
    }
}
