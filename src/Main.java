public class Main {
    public static void main(String... args){
        SinglyLinkedList<String> List = new SinglyLinkedList<String>();
        System.out.println(List.size());
        List.add("Joe");
        List.print();
        System.out.println(List.size());
        List.add("Mom", 0);
        List.print();
        List.add("ma", 1);
        List.add("JoeJoe");
        System.out.println(List.size());
        List.print();
        List.remove("Mom");
        List.add("CARRY");
        System.out.println(List.size());
        List.print();
        List.remove(4);
        List.print();


        System.out.println();
        System.out.println();
        System.out.println();

        SinglyLinkedStack<String> stack = new SinglyLinkedStack<String>();
        System.out.println(stack.isEmpty());
        stack.push("joe");
        stack.push("joe2");

        stack.push("joe3");
        stack.push("joe4");
        stack = new SinglyLinkedStack<String>("joe","joe2","joe3","joe4");
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        System.out.println();
        System.out.println();
        System.out.println();

        CSE214BinaryTree<String> bt = new CSE214BinaryTree<String>("Joe","Joe","Joe","Joe","Joe","Mama","Is","Cool");
        //bt = new CSE214BinaryTree<String>();
        System.out.println(bt.numNodes());
        //bt.preorder();
        System.out.println(bt.inorder());
        System.out.println(bt.postorder());
        System.out.println(bt.preorder());
        System.out.println(bt.depth());
        System.out.println(bt.numNodes());
        //bt.postorder();
        //bt.inorder();
    }
}
