

public class LinkedList {
    private Node head;
    private int length = 0 ;

    public Node createNode(TreeNode tree) {
        return new Node(tree);
    }

    public void sortedInsert(TreeNode tree) {
        Node newNode = createNode(tree);
        if (head == null)
            head = newNode;
        else if (tree.frequence <= head.tree.frequence) {
            newNode.next = head;
            head = newNode;
        } else {
            Node iterator = head;
            while (iterator.next != null && iterator.next.tree.frequence < tree.frequence) {
                iterator = iterator.next;
            }
            newNode.next = iterator.next;
            iterator.next = newNode;
        }
        length++;
    }

    public void display() {
        Node iterator = head;
        while (iterator != null) {
            System.out.println(iterator.tree.charachter + ":" + iterator.tree.frequence + " ");
            iterator = iterator.next;
        }
    }
    public int length(){
        return this.length;
    }

    public Node removeFirst(){
        if(head == null){
            return null;
        }
        Node iterator = head;
        head = head.next;
        iterator.next = null;
        length--;
        return iterator;
    }
    public Node getFirst(){
        return head;
    }
}