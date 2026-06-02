import java.util.*;

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

    // BruteForce 1: TC=O(2n+nlogn), SC=O(2n)
    public ListNode bruteForce_1(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ArrayList<Integer> arrlist = new ArrayList<>(); // SC=O(n)
        ListNode currNode = head;

        while(currNode!=null) // TC=O(n)
        {
            arrlist.add(currNode.val);
            currNode=currNode.next;
        }

        arrlist.sort(Comparator.naturalOrder()); // TC=O(nlogn)

        ListNode newHead = new ListNode(arrlist.get(0));
        ListNode curr = newHead;
        for(int i=1; i<arrlist.size(); i++) //TC=O(n)
        {
            ListNode newNode = new ListNode(arrlist.get(i));
            curr.next=newNode;
            curr=newNode;
        }

        return newHead;
    }


    // Brute Force 2: TC=O(2n+nlogn), SC=O(n) {No need of another linked list. Just reuse the values}
    public ListNode bruteForce_2(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ArrayList<Integer> arr = new ArrayList<>();

        ListNode curr = head;

        while(curr!=null)
        {
            arr.add(curr.val);
            curr=curr.next;
        }

        Collections.sort(arr);
        curr = head;

        for(int x : arr)
        {
            curr.val = x;
            curr = curr.next;
        }

        return head;
    }

    //Optimal: using MergeSort

    public ListNode sortLL(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;

        middle.next = null;

        leftHead = sortLL(leftHead);
        rightHead = sortLL(rightHead);

        return merge2LL(leftHead, rightHead);
    }

    // MODIFIED HARE-TORTOISE ALGO (I want 1st middle... standard algo returns 2nd middle)
    private ListNode findMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next; // Edge case!

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private ListNode merge2LL(ListNode leftHead, ListNode rightHead)
    {
        ListNode dummy = new ListNode(-1, null);
        ListNode temp = dummy;

        while(leftHead!=null && rightHead!=null)
        {
            if(leftHead.val <= rightHead.val)
            {
                temp.next = leftHead;
                temp = temp.next;
                leftHead = leftHead.next;
            }
            else
            {
                temp.next = rightHead;
                temp = temp.next;
                rightHead = rightHead.next;
            }
        }

        if(leftHead!=null)
        {
            temp.next = leftHead;
        }
        else
        {
            temp.next = rightHead;
        }
        return dummy.next;
    }


}