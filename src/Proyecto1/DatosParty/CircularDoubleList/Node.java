package Proyecto1.DatosParty.CircularDoubleList;

public class Node<T> {
    private Node next = null;
    private Node prev = null;
    private T data;

    public Node(T data){
        this.data = data;
    }

    public void setData(T data){
        this.data = data;
    }
    public void setNext(Node next) {

        this.next = next;
    }
    public void setPrev(Node prev) {

        this.prev = prev;

    }

    public T getData() {
        return this.data;
    }
    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }
}
