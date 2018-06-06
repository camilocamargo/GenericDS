/**
 *
 * @author Camilo Camargo
 */
public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public DoubleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public Node getHead(){
        return head;
    }
    
    public Node getTail(){
        return tail;
    }
    
    public int getSize(){
        return size;
    }
    
    public void insertAtEnd(Node newNode){
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void insertAtBeginning(Node newNode){
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void insertAtIndex(int index, Node newNode){
        if(!isEmpty() && index <= size){
            Node temp = head;
            Node pre = temp;
            for (int i = 0; i < index; i++) {
                pre = temp;
                temp = temp.next;
            }
            pre.next = newNode;
            newNode.previous = pre;
            newNode.next = temp;
            temp.previous = newNode;
            size++;
        }
    }
    
    public void deleteAtBeginning(){
        if(!isEmpty()){
            Node temp = head;
            head = head.next;
            temp = null;
            size--;
        }
    }
    
    public void deleteAtEnd(){
        if(!isEmpty()){
            Node temp = tail.previous;
            temp.next = null;
            tail = temp;
            size--;
        }
    }
    
    public void deleteAtIndex(int index){
        if(!isEmpty() && index <= size ) {
            Node temp = head;
            Node pre = temp;
            for (int i = 0; i < index; i++) {
                pre = temp;
                temp = temp.next;
            }
            pre.next = temp.next;
            temp.next.previous = pre;
            temp = null;
            size--;
        }
    }
    
    public void printList(){
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.t);
                temp = temp.next;
            }
        }
    }
    
    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.insertAtEnd(new Node(1));
        dl.insertAtEnd(new Node(2));
        dl.insertAtEnd(new Node(3));
        dl.insertAtEnd(new Node(4));
        dl.insertAtEnd(new Node(5));
        dl.insertAtEnd(new Node(6));
        dl.insertAtEnd(new Node(7));
        dl.insertAtEnd(new Node(8));
        dl.insertAtEnd(new Node(10));
        dl.insertAtBeginning(new Node(0));
        dl.insertAtIndex(1, new Node(10));
        dl.deleteAtBeginning();
        dl.deleteAtEnd();
        dl.deleteAtIndex(1);
        dl.printList();
        System.out.println("size " + dl.getSize());
    }
    
}
