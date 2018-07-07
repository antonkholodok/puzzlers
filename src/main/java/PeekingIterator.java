import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(),
 * design and implement a PeekingIterator that support the peek() operation --
 * it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Example:
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * <p>
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class PeekingIterator<E> implements Iterator<E> {

    private final Iterator<E> it;
    private E peeked;

    public PeekingIterator(Iterator<E> iterator) {
        this.it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public E peek() {
        if (peeked != null) {
            return peeked;
        }
        peeked = it.next();
        return peeked;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public E next() {
        if (peeked != null) {
            E res = peeked;
            peeked = null;
            return res;
        }
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return peeked != null || it.hasNext();
    }
}
