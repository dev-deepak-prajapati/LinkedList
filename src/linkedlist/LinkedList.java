/**
 * This program has been done by
 *
 * @author Deepak Prajapati
 * @see <a href="https://github.com/dev-deepak-prajapati">Deepak Prajapati
 * GitHub Profile</a>
 *
 */
package linkedlist;

public class LinkedList {

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
        newNode.next = head;
        head = newNode;

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
    }

    public void print() {
        if (head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }
        Node tempHead = head;
        while (tempHead != null) {
            System.out.print(tempHead.data + "->");
            tempHead = tempHead.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        length++;
        Node tempHead = head;

        int i = 0;

        while (i < index - 1) {
            tempHead = tempHead.next;
            i++;
        }
        newNode.next = tempHead.next;
        tempHead.next = newNode;
    }

    public int removeFirst() {
        if (length == 0) {
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        } else if (length == 1) {
            int val = head.data;
            head = tail = null;
            length = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        length--;
        return val;
    }

    public int removeLast() {
        if (length == 0) {
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        } else if (length == 1) {
            int val = tail.data;
            head = tail = null;
            length = 0;
            return val;
        }
        Node tempHead = head;

        for (int i = 0; i < length - 2; i++) {
            tempHead = tempHead.next;
        }

//      int val = tempHead.next.data;
        int val = tail.data;
        tempHead.next = null;
        tail = tempHead;
        length--;
        return val;
    }

    public int itrSearch(int key) {

        Node tempHead = head;
        int i = 0;
        while (tempHead != null) {
            if (tempHead.data == key) {
                return i;
            }
            tempHead = tempHead.next;
            i++;
        }

        return -1;
    }

    private int recursiveSearchHelperMethod(Node head, int key) {

        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }
        int index = recursiveSearchHelperMethod(head.next, key);

        if (index == -1) {
            return -1;
        }

        return index + 1;
    }

    public int recSearch(int key) {
        return recursiveSearchHelperMethod(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next; // curr ke next ko , next banata hai 
            curr.next = prev; // ye actualy reverse karta hai, mtlb perv ko curr ke next se point krta hai
            prev = curr;// curr ko prev banata hai
            curr = next;// next ko curr banata hai
        }
        head = prev;// because curr , null ko point kr rha hai prev last node ko
    }

    public int deleteNthFromEnd(int n) {
        length--;
        // calculate size of linkedlist
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (size == n) {
            int val = head.data;
            head = head.next;
            return val;
        }
        // end se Nth node mtlb start se (size - n + 1)th node hota hai.
        int i = 1;
        int toStartNode = size - n;
        Node prev = head;
        while (i < toStartNode) {
            prev = prev.next;
            i++;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        return val;

    }

    public Node findMid(Node head) {
        // slow-fast Approach
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// jump +1 node
            fast = fast.next.next;// jump +2 node
        }
        return slow;// this is my midNode
    }

    public boolean isPalindrome() {
        // for empty LL or single node
        if (head == null || head.next == null) {
            return true;
        }

        // find mid node
        Node midNode = findMid(head);

        // reverse 2nd half mtlb mid se null/last node tak
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next; // assign next node
            curr.next = prev;// reverse this node
            prev = curr;// assign prev node
            curr = next;//assign curr node
        }

        // check left half & right half
        Node right = prev; //right half ka head.||  point reversed nodes
        Node left = head;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean isCycleInSLL() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // cycle detect
            }
        }
        return false;// cycle not detect
    }

    public void removeCycleinSLL() {
        // detect cycle 
        Node slow = head;
        Node fast = head;

        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (isCycle == false) {
            return;
        }
//
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
// 
        prev.next = null;

    }

    public void zigZag() {
        //step 1 : find mid , it is left half last node  
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow;// this is left half last node

        // step 2 : reverse midNode to endNode/tailNode
        Node prev = null;
        Node curr = midNode.next;// right half first node
        midNode.next = null;//right half fist point to null beacuse after reversed node this last node of reversed nodes which is point to null
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //step 3 : merging node according zig zag
        Node right = prev;// this node point to right reverse nodes
        Node left = head;

        Node nextL;
        Node nextR;

        while (left != null && right != null) {
            //zig zag code
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            //jump to next node
            left = nextL;
            right = nextR;
        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        
//        ll.addLast(12);
//        ll.addLast(13);
//        ll.addLast(14);
//        ll.addLast(15);
//        ll.addLast(16);

        ll.add(0, 10);
        ll.add(1, 12);
        ll.print();
        
//        ll.zigZag();
//        ll.print();

    }
}
