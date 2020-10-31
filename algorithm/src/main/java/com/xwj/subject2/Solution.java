package com.xwj.subject2;


/**
 * @author xuwenjie
 * @create 2020-06-29 0:01
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 虚节点
        ListNode dummyHead = new ListNode(0);

        // 当前节点
        ListNode currNode = dummyHead;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        // 进位
        int count = 0;
        while (pointer1 != null || pointer2 != null) {
            int num1 = pointer1 !=null ? pointer1.val : 0;
            int num2 = pointer2 !=null ? pointer2.val : 0;
            int sum = num1 + num2 + count;
            count = sum / 10;

            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;

            if (pointer1 != null) {
                pointer1 = pointer1.next;
            }
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            }

        }
        if (count != 0) {
            currNode.next = new ListNode(count);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode next1 = new ListNode(4);
        ListNode next2 = new ListNode(3);
        l1.next = next1;
        next1.next = next2;

        ListNode l2 = new ListNode(5);
        next1 = new ListNode(6);
        next2 = new ListNode(4);
        l2.next = next1;
        next1.next = next2;

        ListNode resList = solution.addTwoNumbers(l1, l2);
        solution.printList(resList);
    }

    private void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
            if (listNode != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

}
