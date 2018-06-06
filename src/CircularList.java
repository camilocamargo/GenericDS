
/**
 *
 * @author Camilo Camargo
 */
public class CircularList {
    private Node beginning;
    private Node end;
    private int size;
    
    public CircularList(){
        beginning = null;
        end = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public Node getBeginning(){
        return beginning;
    }
    
    public Node getEnd(){
        return end;
    }
    
    public int getSize(){
        return size;
    }
    
    public void insertAtEnd(Node newNode){
        if(isEmpty()){
            beginning = newNode;
            end  = newNode;
            newNode.next = newNode;
        }else{
            end.next = newNode;
            newNode.next = beginning;
            end = newNode;
        }
        size++;
    }
    
    public void insertAtBeginning(Node newNode){
        if(isEmpty()){
            beginning = newNode;
            end  = newNode;
            newNode.next = newNode;
        }else{
            end.next = newNode;
            newNode.next = beginning;
            beginning = newNode;
        }
        size++;
    }
    
    public void insertAtIndex(int index, Node newNode){
        if(!isEmpty() && index < size && index > 0){
            Node temp = beginning;
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
    
    public void deleteAtBeginning(){
        if(!isEmpty()){
            Node temp = beginning;
            beginning = beginning.next;
            end.next = beginning;
            temp = null;
            size--;
        }
    }
    
    public void deleteAtEnd(){
        if(!isEmpty()){
            Node temp = beginning;
            while(temp.next != end){
                temp = temp.next;
            }
            temp.next = beginning;
            end = temp;
            size--;
        }
    }
    
    public void deleteAtIndex(int index){
        if(!isEmpty() && index < size && index > 0){
            Node temp = beginning;
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
        if(!isEmpty()){
            Node temp = beginning;
            do {
                System.out.println(temp.t);
                temp = temp.next;
            } while (temp != beginning);
        }
    }
    
    public static void main(String[] args) {
        CircularList cl = new CircularList();
        cl.insertAtEnd(new Node(0.5));
        cl.insertAtEnd(new Node(0.6));
        cl.insertAtEnd(new Node(0.7));
        cl.insertAtEnd(new Node(0.8));
        cl.insertAtEnd(new Node(0.9));
        cl.insertAtEnd(new Node(0.11));
        cl.insertAtEnd(new Node(0.12));
        cl.insertAtBeginning(new Node(0.001));
        cl.deleteAtBeginning();
        cl.deleteAtEnd();
        cl.deleteAtIndex(1);
        cl.printList();
        System.out.println("size: "+ cl.getSize());
    }
}
