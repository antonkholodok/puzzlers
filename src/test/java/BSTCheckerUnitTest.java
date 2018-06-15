import junit.framework.TestCase;
import org.junit.Test;

public class BSTCheckerUnitTest {

    @Test
    public void testIsBSTTrue() {
        BSTChecker.BTNode root = new BSTChecker.BTNode(10);
        BSTChecker.BTNode r1 = root.insertRight(15);
        BSTChecker.BTNode l1 = root.insertLeft(5);
        r1.insertRight(16);
        r1.insertLeft(13);
        l1.insertRight(7);
        l1.insertLeft(1);

        TestCase.assertTrue(BSTChecker.isBST(root));
    }

    @Test
    public void testIsBSTFalse() {
        BSTChecker.BTNode root = new BSTChecker.BTNode(10);
        BSTChecker.BTNode r1 = root.insertRight(15);
        BSTChecker.BTNode l1 = root.insertLeft(13);
        r1.insertRight(16);
        r1.insertLeft(13);
        l1.insertRight(7);
        l1.insertLeft(1);

        TestCase.assertFalse(BSTChecker.isBST(root));
    }

    @Test
    public void testIsBSTRootOnly() {
        BSTChecker.BTNode root = new BSTChecker.BTNode(10);
        TestCase.assertTrue(BSTChecker.isBST(root));
    }

    @Test
    public void testIsBSTLeftSideTrue() {
        BSTChecker.BTNode root = new BSTChecker.BTNode(10)
            .insertLeft(9)
            .insertLeft(8)
            .insertLeft(7);
        TestCase.assertTrue(BSTChecker.isBST(root));
    }

    @Test
    public void testIsBSTLeftSideFalse() {
        BSTChecker.BTNode root = new BSTChecker.BTNode(10);
        root.insertLeft(9)
            .insertLeft(8)
            .insertLeft(12);
        TestCase.assertFalse(BSTChecker.isBST(root));
    }

    @Test
    public void testIsBSTRightSideTrue() {
        BSTChecker.BTNode root = new BSTChecker.BTNode(10)
            .insertRight(11)
            .insertRight(12)
            .insertRight(13);
        TestCase.assertTrue(BSTChecker.isBST(root));
    }

    @Test
    public void testIsBSTRightSideFalse() {
        BSTChecker.BTNode root = new BSTChecker.BTNode(10);
        root.insertRight(11)
            .insertRight(12)
            .insertRight(9);
        TestCase.assertFalse(BSTChecker.isBST(root));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsBSTNullRoot() {
        BSTChecker.isBST(null);
    }
}
