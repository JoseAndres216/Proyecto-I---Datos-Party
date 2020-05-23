package Proyecto1.DatosParty.DoubleLinkedList;

public class DoubleNode<T>{
    private DoubleNode next;
    private DoubleNode prev;
    private T data;

    public DoubleNode(T data){
        this.data = data;
    }
    public T getData() {

        return data;
    }
    public void setData(T data) {

        this.data = data;
    }
    public DoubleNode getNext() {

        return next;
    }
    public void setNext(DoubleNode next) {

        this.next = next;
    }
    public DoubleNode getPrev() {

        return prev;
    }
    public void setPrev(DoubleNode prev) {

        this.prev = prev;

    }


}
