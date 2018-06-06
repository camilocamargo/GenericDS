/**
 *
 * @author Camilo Camargo
 */
public class Node<type>{
    type t;
    public Node<type> next = null;
    public Node<type> previous = null;
    
    public Node(){}
    
    public Node(type t){
        this.t = t;
    }
}
