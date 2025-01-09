import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorExample {

    static int[] elements;
    static int numElements;

    public static void main(String[] args) {
        Iterator<Integer> it = new Iterator<Integer>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < numElements;
            }

            @Override
            public Integer next() {
                if (hasNext()) return elements[i++];
                else throw new NoSuchElementException();
            }
        };

    }
}
