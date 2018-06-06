/**
 *
 * @author Camilo Camargo
 */
public abstract class List {
    private Node head;
    private Node tail;
    private int size;
    
    public List(){
        head = null;
        tail = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public int getSize(){
        return size;
    }
    
    public Node getHead(){
        return head;
    }
    
    public Node getTail(){
        return tail;
    }
    
    public void insertAtEnd(Node newNode){
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
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
            newNode.next = temp;
            size++;
        }
    }
    
    public void deleteAtEnd(){
        Node pre = head;
        Node temp = pre;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        temp = null;
        pre.next = null;
        tail = pre;
        size--;
    }
    
    public void deleteAtBeginning(){
        Node temp = head;
        head = head.next;
        temp = null;
        size--;
    }
    
    public void deleteAtIndex(int index){
        if(!isEmpty() && index < size){
            Node temp = head;
            Node pre = temp;
            for (int i = 0; i < index; i++) {
                pre = temp;
                temp = temp.next;
            }
            pre.next = temp.next;
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
    
    public Node getNode(int index){
        if(index > size){
            System.out.println("Node not found.");
            return null;
        }else{
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }
    
    public abstract void quicksort();
    
    public abstract Node binarySearch();
    
    public static class tList extends List{

        @Override
        public void quicksort() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Node binarySearch() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public static void main(String[] args) {
        tList t = new tList();
        t.insertAtEnd(new Node(4.4));
        t.insertAtEnd(new Node(5.5));
        t.insertAtEnd(new Node(6.908));
        t.insertAtEnd(new Node(3.45));
        t.insertAtEnd(new Node(1.456));
        t.insertAtEnd(new Node(1.5999));
        //t.insertAtIndex(2, new Node(2.22222));
        t.deleteAtIndex(3);
        //t.deleteAtBeginning();
        //t.deleteAtEnd();
        System.out.println("Print List: ");
        t.printList();
        System.out.println("----------------");
        System.out.println("get head: " + t.getHead().t);
        System.out.println("get tail: " + t.getTail().t);
        System.out.println("Size: " + t.getSize());
    }
    
}
