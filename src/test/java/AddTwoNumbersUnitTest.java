import junit.framework.TestCase;
import org.junit.Test;

public class AddTwoNumbersUnitTest {

    @Test
    public void testAddFirstZero() {
        // 0 + 12 = 12
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(0);

        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(2);
        second.next = new AddTwoNumbers.ListNode(1);

        assertEq(AddTwoNumbers.add(first, second), 12);
    }

    @Test
    public void testAddSecondZero() {
        // 12 + 0 = 12
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(2);
        first.next = new AddTwoNumbers.ListNode(1);

        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(0);

        assertEq(AddTwoNumbers.add(first, second), 12);
    }

    @Test
    public void testSameLength() {
        // 342 + 465 = 807
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(2);
        first.next = new AddTwoNumbers.ListNode(4);
        first.next.next = new AddTwoNumbers.ListNode(3);

        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(5);
        second.next = new AddTwoNumbers.ListNode(6);
        second.next.next = new AddTwoNumbers.ListNode(4);

        assertEq(AddTwoNumbers.add(first, second), 807);
    }

    @Test
    public void testDiffLength() {
        // 342 + 65 = 807
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(2);
        first.next = new AddTwoNumbers.ListNode(4);
        first.next.next = new AddTwoNumbers.ListNode(3);

        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(5);
        second.next = new AddTwoNumbers.ListNode(6);

        assertEq(AddTwoNumbers.add(first, second), 407);
    }

    @Test
    public void testOverflow() {
        // 342 + 665 = 807
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(2);
        first.next = new AddTwoNumbers.ListNode(4);
        first.next.next = new AddTwoNumbers.ListNode(3);

        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(5);
        second.next = new AddTwoNumbers.ListNode(6);
        second.next.next = new AddTwoNumbers.ListNode(6);

        assertEq(AddTwoNumbers.add(first, second), 1007);
    }

    private static void assertEq(AddTwoNumbers.ListNode head, int expected) {
        AddTwoNumbers.ListNode current = head;
        while (current != null) {
            int number = expected % 10;
            expected /= 10;
            TestCase.assertEquals(number, current.val);
            current = current.next;
        }
    }
}
