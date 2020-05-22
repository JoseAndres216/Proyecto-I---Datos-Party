package Proyecto1.DatosParty.SimpleLinkedList;

public class Node<T> {
    private Node next = null;
    private T data = null;

    public Node(T data){
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
}
