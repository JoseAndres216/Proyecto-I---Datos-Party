package com.cr.ac.tec.CE1103.Proyecto1.SimpleLinkedList;

public class Node<T extends Comparable<T>> {
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
