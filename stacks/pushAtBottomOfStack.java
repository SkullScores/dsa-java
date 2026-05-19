package stacks;
import java.util.*;

public class pushAtBottomOfStack 
{
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
