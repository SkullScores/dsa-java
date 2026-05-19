package stacks;
import java.util.*;

public class reverseStack
{
    public void reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
        {
            return;
        }

        int top = s.pop();
        reverse(s);
        pushAtBottom(top, s);
    }

    public void pushAtBottom(int data, Stack<Integer> s)
    {
        //Base case
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }
}
