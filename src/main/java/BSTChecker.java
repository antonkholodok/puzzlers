import com.google.common.base.Preconditions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewcake.com/question/java/bst-checker
 * <p>
 * Write a method to check that a binary tree ↴ is a valid binary search tree.
 */
public class BSTChecker {

    static class BTNode {

        private BTNode left;
        private BTNode right;
        private int value;

        public BTNode(int value) {
            this.value = value;
        }

        public BTNode insertLeft(int value) {
            this.left = new BTNode(value);
            return this.left;
        }

        public BTNode insertRight(int value) {
            this.right = new BTNode(value);
            return this.right;
        }
    }

    static class BTNodeConstraint {

        // node value should be ge
        // than lo and le than hi
        private final BTNode node;

        // boundaries
        private final int lo;
        private final int hi;

        BTNodeConstraint(BTNode node, int lo, int hi) {
            this.node = Preconditions.checkNotNull(node, "Node should not be null");
            this.lo = lo;
            this.hi = hi;
        }

        boolean isValid() {
            return node.value >= lo && node.value <= hi;
        }
    }

    public static boolean isBST(BTNode root) {
        Preconditions.checkArgument(root != null, "Root node can not be null");

        Deque<BTNodeConstraint> stack = new LinkedList<>();
        stack.push(new BTNodeConstraint(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        // doing DFS traversal
        // we'll have n elements in stack in worst case
        // complexity is O(n), additional space is O(n) worst case and O(lgn) if tree is balanced
        while (!stack.isEmpty()) {
            BTNodeConstraint constraint = stack.pop();
            if (!constraint.isValid()) {
                return false;
            }

            if (constraint.node.left != null) {
                stack.push(new BTNodeConstraint(constraint.node.left, Integer.MIN_VALUE, constraint.node.value));
            }
            if (constraint.node.right != null) {
                stack.push(new BTNodeConstraint(constraint.node.right, constraint.node.value, Integer.MAX_VALUE));
            }
        }
        return true;
    }
}
