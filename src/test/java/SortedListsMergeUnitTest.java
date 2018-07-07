import junit.framework.TestCase;
import org.junit.Test;

public class SortedListsMergeUnitTest {

    @Test
    public void testDuplicates() {
        SortedListsMerge.ListNode l1 = new SortedListsMerge.ListNode(1,
            new SortedListsMerge.ListNode(2,
                new SortedListsMerge.ListNode(4)));

        SortedListsMerge.ListNode l2 = new SortedListsMerge.ListNode(1,
            new SortedListsMerge.ListNode(3,
                new SortedListsMerge.ListNode(4)));

        SortedListsMerge.ListNode res = new SortedListsMerge.ListNode(1,
            new SortedListsMerge.ListNode(1,
                new SortedListsMerge.ListNode(2,
                    new SortedListsMerge.ListNode(3,
                        new SortedListsMerge.ListNode(4,
                            new SortedListsMerge.ListNode(4))))));

        assertEq(res, SortedListsMerge.merge(l1, l2));
    }

    @Test
    public void testDiffLength() {
        SortedListsMerge.ListNode l1 = new SortedListsMerge.ListNode(1);

        SortedListsMerge.ListNode l2 = new SortedListsMerge.ListNode(1,
            new SortedListsMerge.ListNode(3,
                new SortedListsMerge.ListNode(4)));

        SortedListsMerge.ListNode res = new SortedListsMerge.ListNode(1,
            new SortedListsMerge.ListNode(1,
                new SortedListsMerge.ListNode(3,
                    new SortedListsMerge.ListNode(4))));

        assertEq(res, SortedListsMerge.merge(l1, l2));
    }

    private static void assertEq(SortedListsMerge.ListNode expected,
                                 SortedListsMerge.ListNode actual) {
        while (expected != null || actual != null) {
            TestCase.assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        TestCase.assertNull(expected);
        TestCase.assertNull(actual);
    }
}
