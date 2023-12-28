public class Node {
    public TreeNode tree;
    public Node next;

    public Node(TreeNode tree){
        this.tree = tree;
        this.next=null;
    }
    public String toString(){
        return String.valueOf(this.tree.charachter);
    }
}