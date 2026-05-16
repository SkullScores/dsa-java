package linked_list;

// Pattern: Fast & Slow pointer with GAP
// Key insight: Create a gap of n+1 between fast & slow.
//              When fast = null, slow = predecessor of target node.

// Dummy node rule: Use dummy whenever deletion might affect head.
//                  dummy.next = head. Return dummy.next, not head.

// Common mistakes:
// - Declaring prev without initializing (NPE)
// - Forgetting head deletion edge case (dummy solves this)
// - Gap should be n+1, not n (you want predecessor, not the node itself)

// Time: O(n) one pass | Space: O(1)

class Solution 
{
    public Node removeNthFromEnd(Node head, int n) 
    {
        //dummy takes care of head deletion in case list size = n
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        //Move fast n+1 steps ahead
        for(int i=0; i<n+1; i++)
        {
            fast = fast.next;
        }
        //Now we have already covered n steps that we needed

        //both move simultaneously until fast hits null
        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        //slow is now at the node BEFORE the one to delete
        slow = slow.next.next;
        return dummy.next;
    }
}


