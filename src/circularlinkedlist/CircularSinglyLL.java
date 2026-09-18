/**
 * This program has been done by
 *
 * @date Sep 18, 2026 4:22:39 PM
 * @author Deepak Prajapati
 * @see <a href="https://github.com/dev-deepak-prajapati">Deepak Prajapati
 * GitHub Profile</a>
 *
 */
package circularlinkedlist;

public class CircularSinglyLL {

    public static Node head = null;
    public static Node tail = null;
    public static int length = 0;

    public CircularSinglyLL() {

    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        length++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        length++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    public int removeFirst() {

        if (head == null) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        }
        if (length == 1) {
            int val = head.data;
            head = tail = null;
            length = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        tail.next = head;
        length--;
        return val;
    }

    public void size() {
        System.out.println("Length = " + length);
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        }
        if (length == 1) {
            int val = head.data;
            head = tail = null;
            length = 0;
            return val;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.data;
        tail = temp;
        tail.next = head;
        length--;
        return val;
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty.");
            return;
        }
        Node temp = head;

        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("Head=" + head.data);

        /**
         * print using while loop
         */
//        while (temp != null) {
//            System.out.print(temp.data + "->");
//            temp = temp.next;
//            if (temp == head) {
//                System.out.println("Head=" + head.data);
//                return;
//            }
//        }
    }

    public void add(int index, int data) {
        if (index < 0 || index > length) {
            System.out.println("Invalid index " + index);
            System.out.println("index must be 0 to size-1.");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == length) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int remove(int index) {
        if (head == null) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        }
        if (index < 0 || index > length - 1) {
            System.out.println("Invalid index " + index);
            System.out.println("index must be 0 to size-1.");
            return Integer.MIN_VALUE;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    public static void main(String[] args) {
        CircularSinglyLL cll = new CircularSinglyLL();
        cll.addFirst(1);
        cll.addFirst(4);
        cll.addLast(5);
        cll.addLast(7);
        cll.addLast(8);
        cll.add(4, 5);
        cll.print();
        System.out.println(cll.remove(2));
        cll.print();

    }

}
