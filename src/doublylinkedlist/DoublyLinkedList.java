/**
 * This program has been done by
 *
 * @author Deepak Prajapati
 * @see <a href="https://github.com/dev-deepak-prajapati">Deepak Prajapati
 * GitHub Profile</a>
 *
 */
package doublylinkedlist;

public class DoublyLinkedList {

    public static Node head;
    public static Node tail;
    public static int length;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    private boolean isEmpty() {
        return head == null ? true : false;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        length++;
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        length++;
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data) {

        if (index < 0 || index > length) {
            System.out.println("Invalid index : " + index);
            return;
        }
        //for both first position aur empty list
        if (index == 0) {
            addFirst(data);
            return;
        }
        //for last position
        if (index == length) {
            addLast(data);
            return;
        }
        //for middle position
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;

        length++;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("DLL is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("DLL is empty.");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public int removeFirst() {
        if (isEmpty()) {
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }
        if (length == 1) {
            int val = head.data;
            head = null;
            tail = null;
            length = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;

        length--;
        return val;
    }

    public int removeLast() {
        if (isEmpty()) {
            System.out.println("DLL is empty. ");
            return Integer.MIN_VALUE;
        }

        if (length == 1) {
            int val = head.data;
            head = null;
            tail = null;
            length = 0;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;

        length--;
        return val;
    }

    public int remove(int index) {

        if (index < 0 || index > length - 1) {
            System.out.println("Invalid index : " + index);
            return Integer.MIN_VALUE;
        }
        if (isEmpty()) {
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }
        if (index == 0) {
            int val = removeFirst();
            return val;
        }
        if (index == length - 1) {
            int val = removeLast();
            return val;
        }
        int i = 0;
        Node temp = head;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
        length--;
        return val;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        tail = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public Node findMid() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        Node left = head;
        Node right = tail;

        while (left != right && left.prev != right) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }

    public boolean detectCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        // if LL not make cycle/loop ,return  
        if(!detectCycle()){
            return;
        }
        
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                break;
            }
        }

        Node fastPrev = null;
        Node slowPrev = null;

        while (fast != slow) {
            fastPrev = fast;
            slowPrev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        fastPrev.next = null;
        slow.prev = slowPrev;
    }

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(12);
        dll.addFirst(13);
        dll.addFirst(14);
        dll.addFirst(15);
        dll.addFirst(16);
        dll.addFirst(17);
        dll.addFirst(18);
        dll.addFirst(19);

        /**
         * this code make cycle/loop in Linked List
         */
//        tail.next = head.next.next;
//        head.next.next.prev = tail;

        System.out.println(dll.detectCycle());
        dll.removeCycle();
        dll.print();
        System.out.println(dll.detectCycle());
        dll.printReverse();

    }

}
