import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

public class PeekingIteratorUnitTest {

    @Test
    public void test() {
        Iterator<Integer> it = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator<Integer> pit = new PeekingIterator<>(it);

        TestCase.assertTrue(pit.hasNext());
        TestCase.assertEquals(1, pit.next().intValue());
        TestCase.assertEquals(2, pit.peek().intValue());
        TestCase.assertEquals(2, pit.next().intValue());
        TestCase.assertEquals(3, pit.peek().intValue());
        TestCase.assertEquals(3, pit.next().intValue());
        TestCase.assertFalse(pit.hasNext());
    }
}
