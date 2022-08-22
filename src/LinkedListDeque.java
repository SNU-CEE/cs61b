public class LinkedListDeque<PlaceholderType>{

    private class ListNode {
        private PlaceholderType item;
        private ListNode prev;
        private ListNode next;

        private ListNode(ListNode p, PlaceholderType i, ListNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private ListNode sentinel;
    private int size;

    /**  Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(PlaceholderType item) {
        ListNode newNode = new ListNode(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
//        sentinel.next = new ListNode(sentinel, item, sentinel.next);
//        sentinel.next.next.prev = sentinel.next;
//        size += 1;
    }

    public void addLast(PlaceholderType item) {
        ListNode newNode = new ListNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
//        sentinel.prev.next = new ListNode(sentinel.prev, item, sentinel);
//        sentinel.prev = sentinel.prev.next;
//        size += 1;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode node = sentinel;
        while (node.next != sentinel) {
            System.out.print(node.next.item + " ");
            node = node.next;
        }
    }

    public PlaceholderType removeFirst() {
        if (size == 0) {
            // no such item exists, return null
            return null;
        } else {
            // remove first item and return that item
            PlaceholderType firstItem = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;

            return firstItem;
        }
    }

    public PlaceholderType removeLast() {
        if (size == 0) {
            // no such item exists, return null
            return null;
        } else {
            // remove last item and return that item
            PlaceholderType lastItem = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;

            return lastItem;
        }
    }

    public PlaceholderType getIterative(int index) {
        int length = size;
        ListNode target = sentinel.next;

        // no such item exists, returns null.
        if (index > length - 1) {
            return null;
        } else {
            for (int i = 0; i < index; i++) {
                target = target.next;
            }
            return target.item;
        }
    }

    public PlaceholderType getRecursive(int index) {
        int length = size;
        // no such item exists, returns null.
        if (index > length - 1) {
            return null;
        } else {
            return traverse(sentinel.next, index);
        }
    }

    public PlaceholderType get(int index) {
        int count = 0;
        ListNode ptr = sentinel;
        while (ptr.next != sentinel) {
            ptr = ptr.next;
            if (count == index) {
                return ptr.item;
            }
            count++;
        }
        return null;
    }

    public PlaceholderType traverse(ListNode n, int i) {
        if (i == 0) {
            return n.item;
        } else {
            return traverse(n.next, i - 1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> Dllist = new LinkedListDeque<>();
        Dllist.addFirst(666);
        Dllist.addLast(6666);
        Dllist.addLast(66666);
        Dllist.printDeque();                        // expected (666 6666 66666)

        Dllist.addFirst(66);
        Dllist.printDeque();

//        System.out.println("Test getIterative #1");
//        System.out.println(Dllist.getIterative(0)); // expected 666
//        System.out.println(Dllist.getIterative(1)); // expected 6666
//        System.out.println(Dllist.getIterative(5)); // expected null
//        System.out.println("Test getIterative #1");
//        System.out.println(Dllist.getRecursive(0)); // expected 666
//        System.out.println(Dllist.getRecursive(1)); // expected 6666
//        System.out.println("Test done!");
//
//        Dllist.removeFirst();
//        Dllist.printDeque();                        // expected (6666 66666)
//        System.out.println("Test getIterative #2 removeFirst");
//        System.out.println(Dllist.getIterative(0)); // expected 6666
//        System.out.println(Dllist.getIterative(1)); // expected 66666
//        System.out.println("Test getRecursive #2 removeFirst");
//        System.out.println(Dllist.getRecursive(0)); // expected 6666
//        System.out.println(Dllist.getRecursive(1)); // expected 66666
//
//        Dllist.removeLast();
//        Dllist.printDeque();                        // expected 6666
//        System.out.println("Test getIterative #3 removeLast");
//        System.out.println(Dllist.getIterative(0)); // expected 6666
//        System.out.println(Dllist.getIterative(1)); // expected null
//        System.out.println("Test getRecursive #3 removeFirst");
//        System.out.println(Dllist.getRecursive(0)); // expected 6666
//        System.out.println(Dllist.getRecursive(1)); // expected null
    }

}
