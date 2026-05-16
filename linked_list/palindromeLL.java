package linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode findMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseRecursive(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverseRecursive(middle.next);
        ListNode firstHalfStart = head;

        while(secondHalfStart!=null)
        {
            if(secondHalfStart.val!=firstHalfStart.val)
            {
                return false;
            }
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;
        }
        return true;
    }
}