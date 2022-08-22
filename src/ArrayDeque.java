public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity, int startPosition) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, startPosition, size);
        items = a;
    }

    public void addFirst(T item) {
        if (items[nextFirst] == null) {
            items[nextFirst] = item;
            nextFirst = minusOne(nextFirst);
            size++;
        }
    }

    public void addLast(T item) {
        items[nextLast % (items.length)] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T toReturn = items[(nextFirst += 1) % (items.length)];
        items[nextFirst % (items.length)] = null;
        size -= 1;

        return toReturn;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T toReturn = items[nextLast -= 1];
        items[nextLast] = null;
        size -= 1;

        return toReturn;
    }

    public T get(int index) {
        if (index < 0 || index > items.length - 1 || items[index] == null) {
            return null;
        }
        return items[index];
    }

    private int minusOne(int index) {
        if ((index == 0)) {
            return items.length - 1;
        } else {
            return index - 1;
        }

    }

    private int plusOne(int index) {
        if ((index == size - 1) && (items[0] == null)) {
            return 0;
        }
        return index + 1;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> testArray = new ArrayDeque<Integer>();
        testArray.addFirst(3);
        testArray.addLast(5);
        testArray.printDeque();
        System.out.println(testArray.get(0));


    }

}
