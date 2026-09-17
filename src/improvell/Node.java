/**
 * This program has been done by
 *
 * @author Deepak Prajapati
 * @see <a href="https://github.com/dev-deepak-prajapati">Deepak Prajapati
 * GitHub Profile</a>
 *
 */
package improvell;

public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /**
     *
     * @return node data, not reference
     */
//    @Override
//    public String toString() {
//        return String.valueOf(data);
//    }
}
