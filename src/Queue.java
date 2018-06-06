/**
 *
 * @author Camilo Camargo
 */
public class Queue {
    public Node front, rear;
    private int size;
    
    public Queue(){
        front = null;
        rear = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return (front == null);
    }
    
    public void enqueue(Node newNode){
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public Node dequeue(){
        if(!isEmpty()){
            Node temp = front;
            front = front.next;
            temp.next = null;
            size--;
            return temp;
        }
        return null;
    }
    
    public Node getFront(){
        if(!isEmpty()){
            return front;
        }
        return null;
    }
    
    public Node getRear(){
        if(!isEmpty()){
            return rear;
        }
        return null;
    }
    
    public int getSize(){
        return size;
    }
    
    public void printQueue(){
        while(!isEmpty()){
            System.out.println(dequeue().t);
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(new Node('U'));
        q.enqueue(new Node('n'));
        q.enqueue(new Node('i'));
        q.enqueue(new Node('m'));
        q.enqueue(new Node('i'));
        q.enqueue(new Node('n'));
        q.enqueue(new Node('u'));
        q.enqueue(new Node('t'));
        q.enqueue(new Node('o'));
        System.out.println("size: " + q.getSize());
        q.printQueue();
        System.out.println("size after print the queue: " + q.getSize());
    }
    
}
