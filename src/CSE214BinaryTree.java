public class CSE214BinaryTree<T> implements CSE214Tree {

    class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;
    private String result;

    public Node<T> add(T[] data, Node node, int i){
        if(i < data.length){
            Node<T> temp = new Node<T>(data[i]);
            node = temp;
            node.left = add(data, root.left, 2 * i + 1);
            node.right = add(data, root.right, 2 * i + 2);
        }
        return node;
    }

    public CSE214BinaryTree(T... data){
        this.root = new Node<T>(data[0]);
        this.root = add(data, this.root, 0);
    }

    public CSE214BinaryTree(){
        this.root = null;
    }

    @Override
    public String preorder() {
        if(root == null) return "";
        result = new String();
        preorder(root);
        return result.substring(0, result.length()-2);
    }

    public void preorder(Node<T> node) {
        if(node == null) return;
        result += node.data.toString() + ", ";

        preorder(node.left);

        preorder(node.right);
    }


    @Override
    public String postorder() {
        if(root == null) return "";
        result = new String();
        postorder(root);
        return result.substring(0, result.length()-2);
    }

    public void postorder(Node<T> node) {
        if(node == null) return;
        postorder(node.left);

        postorder(node.right);

        result += node.data.toString() + ", ";
    }


    @Override
    public String inorder(){
        if(root == null) return "";
        result = new String();
        inorder(root);
        return result.substring(0, result.length()-2);
    }

    public void inorder(Node<T> node) {
        if(node == null) return;
        inorder(node.left);

        result += node.data.toString() + ", ";

        inorder(node.right);
    }

    @Override
    public int numNodes(){
        return numNodes(root);
    }

    public int numNodes(Node node) {
        if(node == null) return 0;

        int count = 1;

        count += (numNodes(node.left));
        count += (numNodes(node.right));
        return count;
    }

    @Override
    public int depth(){
        return depth(root);
    }

    public int depth(Node node) {
        if(root == null) return -1;
        if(node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        return(Math.max(left,right) + 1);
    }
}
