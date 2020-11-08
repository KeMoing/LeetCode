package com.xwj.subject445;


/**
 * @author xuwenjie
 * @create 2020-11-01 19:26
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    public ListNode reverseList(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode result = list;
        ListNode curr = list.next;
        result.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = result;
            result = curr;
            curr = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        list.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        solution.printList(list);
        ListNode result = solution.reverseList(list);
        System.out.println();
        solution.printList(result);
    }

    private void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "-->");
            listNode = listNode.next;
        }

    }
}
