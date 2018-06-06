/**
 *
 * @author Camilo Camargo
 */
public class Stack {
    private Node top;
    private int size;
    
    public Stack(){
        top = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return (top == null);
    }
    
    public void push(Node newNode){
        if(isEmpty()){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
    
    public Node pop(){
        if(!isEmpty()){
            Node temp = top;
            top = top.next;
            temp.next = null;
            size--;
            return temp;
        }
        return null;
    }
    
    public Node getTop(){
        return top;
    }
    
    public int getSize(){
        return size;
    }
    
    public void printStack(){
        Node temp = top;
        while(!isEmpty()){
            System.out.println(pop().t);
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(new Node("Universidad"));
        s.push(new Node("Minuto"));
        s.push(new Node("De"));
        s.push(new Node("Dios."));
        System.out.println("size: "+s.getSize());
        s.printStack();
    }
}
