import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements CSE214List{
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private int size;
    private Node<T> head;
    private Node<T> cursor;

    SinglyLinkedList(){
        this.head = null;
        this.size = 0;
        this.cursor = null;
    }

    SinglyLinkedList(T... args) throws NullPointerException{
        if(args.length == 0) {
            this.head = null;
            this.size = 0;
            return;
        }

        if(args[0] == null) throw new NullPointerException("Argument at index: 0 is null.");
        head = new Node<T>(args[0]);
        size = 1;
        cursor = head;
        if(args.length == 1) return;

        for(int i = 1; i< args.length; i++){
            if(args[i] == null) throw new NullPointerException("Argument at index: " + i + " is null.");
            cursor.next = new Node<T>(args[i]);
            cursor = cursor.next;
            size++;
        }
        cursor = head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object elem, int index) {
        if(elem == null) throw new NullPointerException();
        if(index+1 > size) throw new IndexOutOfBoundsException();
        if(index < 0) throw new IndexOutOfBoundsException();

        if(index == 0){
            add((T) elem);
            return;
        }else{
            size++;
        }

        int counter = 0;
        cursor = head;
        while(counter < index-1){
            cursor = cursor.next;
            counter++;
        }
        if(counter == size) {
            cursor.next = new Node<T>((T) elem);
            return;
        }

        Node<T> newNode = new Node<T>((T) elem);
        newNode.next = cursor.next;
        cursor.next = newNode;
        cursor = head;
    }
    @Override
    public void add(Object elem) {
        if(elem == null) throw new NullPointerException();

        size++;

        Node<T> node = new Node<T>((T) elem);
        node.next = head;
        head = node;
        return;
    }
    @Override
    public Object remove(int index) {
        if(index+1 > size) throw new IndexOutOfBoundsException();
        if(index < 0) throw new IndexOutOfBoundsException();

        cursor = head;

        size--;

        if(index == 0){
            Node<T> node = head;
            head = head.next;
            return node.data;
        }

        int counter = 0;
        while(counter < index-1){
            cursor = cursor.next;
            counter++;
        }

        Node<T> node = cursor.next;
        cursor.next = cursor.next.next;
        cursor = head;
        return node.data;
    }
    @Override
    public void remove(Object elem) {
        cursor = head;
        if(cursor == null) throw new NoSuchElementException();

        if(head.data.equals((T) elem)) {
            head = head.next;
            size--;
            return;
        }
        while(!cursor.next.data.equals((T) elem)){
            if(cursor.next.next == null) throw new NoSuchElementException();
            cursor = cursor.next;
        }

        cursor.next = cursor.next.next;
        size--;
        cursor = head;
    }
    @Override
    public boolean find(Object elem) {
        if(head == null) return false;
        if(head.data.equals((T) elem)) return true;

        while(cursor.next != null){
            cursor = cursor.next;
            if(cursor.data.equals((T) elem)){
                return true;
            }
        }
        return false;
    }

    public void print(){
        cursor = head;
        while(cursor.next != null){
            System.out.print(cursor.data + " ");
            cursor = cursor.next;
        }
        System.out.println(cursor.data + " ");
    }
}
