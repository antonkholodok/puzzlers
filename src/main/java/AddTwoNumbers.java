/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode add(ListNode l1, ListNode l2) {

        ListNode current = new ListNode(-1);
        ListNode result = current;

        int addition = 0;

        for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            int val = l1.val + l2.val + addition;
            addition = val / 10;
            current.next = new ListNode(val % 10);
            current = current.next;
        }

        for (ListNode rest = l1 != null ? l1 : l2; rest != null; rest = rest.next) {
            int val = rest.val + addition;
            addition = val / 10;
            current.next = new ListNode(val % 10);
            current = current.next;
        }

        if (addition > 0) {
            current.next = new ListNode(addition);
        }

        return result.next;
    }

}
