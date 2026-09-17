/**
 * This program has been done by
 *
 * @author Deepak Prajapati
 * @see <a href="https://github.com/dev-deepak-prajapati">Deepak Prajapati
 * GitHub Profile</a>
 *
 */
package improvell;

public class ImproveLL {

    public static Node head;
    public static Node tail;
    public static int length;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        length++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;

    }

    public void print() {
        if (head == null) {
            System.out.println("SLL is Empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + "->");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        length++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
    }

    public void add(int index, int data) {
        Node newNode = new Node(data);
        length++;
        if (index == 0) {
            head = tail = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);

    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("SLL is Empty.");
            return Integer.MIN_VALUE;
        } else if (length == 1) {
            int val = head.getData();
            head = tail = null;
            length = 0;
            return val;
        }
        int val = head.getData();
        head = head.getNext();
        length--;
        return val;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("SLL is Empty.");
            return Integer.MIN_VALUE;
        } else if (length == 1) {
            int val = tail.getData();
            head = tail = null;
            length = 0;
            return val;
        }
        Node temp = head;
        for (int i = 0; i < length - 2; i++) {
            temp = temp.getNext();
        }
        int val = tail.getData();
        temp.setNext(null);
        tail = temp;
        length--;
        return val;
    }

    public int remove(int index) {
        if (head == null) {
            System.out.println("SLL is Empty.");
            return Integer.MIN_VALUE;
        } else if (length == 1) {
            int val = head.getData();
            head = tail = null;
            length = 0;
            return val;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        int val = temp.getNext().getData();
        temp.setNext(temp.getNext().getNext());
        length--;
        return val;
    }

    public static void main(String[] args) {

        ImproveLL ll = new ImproveLL();

        ll.addFirst(15);
        ll.addLast(33);
        ll.add(1, 22);
        ll.addLast(35);
        ll.print();
        System.out.println(ll.remove(2));
        ll.print();
       
    }

}
