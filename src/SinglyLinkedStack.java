public class SinglyLinkedStack<T> implements CSE214Stack{

    private SinglyLinkedList<T> Stack;

    public SinglyLinkedStack(){
        this.Stack = new SinglyLinkedList<T>();
    }

    public SinglyLinkedStack(T... args){
        this.Stack = new SinglyLinkedList<T>();
        for(T arg: args){
            if(arg == null) throw new NullPointerException();
            this.Stack.add(arg);
        }
    }

    @Override
    public int size() {
        return Stack.size();
    }

    @Override
    public Object peek() {
        T temp = (T)Stack.remove(0);
        Stack.add(temp);
        return temp;
    }

    @Override
    public Object pop() {
        return Stack.remove(0);
    }

    @Override
    public void push(Object elem) {
        Stack.add(elem);
    }

    @Override
    public boolean isEmpty() {
        if(Stack.size() == 0) return true;
        return false;
    }
}
