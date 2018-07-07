/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the
 * nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class SortedListsMerge {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public static ListNode merge(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode current = null;

        while (l1 != null || l2 != null) {
            ListNode newNode;

            if (l1 == null) {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (current == null) {
                current = newNode;
                result = current;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }

        return result;
    }
}
