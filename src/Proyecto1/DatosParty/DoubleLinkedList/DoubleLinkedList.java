package Proyecto1.DatosParty.DoubleLinkedList;

import Proyecto1.DatosParty.MotherList.MotherList;

public class DoubleLinkedList<T> implements MotherList<T>{

    private DoubleNode<T> head, tail;
    private int len;

    public int getExtension() {
        return this.len;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public void insertFirst(T data){
        DoubleNode newElement = new DoubleNode<T>(data);
         if(this.head == null){
             this.head = this.tail = newElement;
             this.len++;
         }
         else{
             newElement.setNext(this.head);
             this.head.setPrev(newElement);
             this.head = newElement;
             this.len++;
         }
    }
    public void insertLast(T data){
        DoubleNode newElement = new DoubleNode<T>(data);
        if(this.head == null){
            this.head = this.tail = newElement;
            this.len++;
        } else {
            this.tail.setNext(newElement);
            newElement.setPrev(this.tail);
            this.tail = tail;
            this.len++;
        }
    }

    public T accessNode(int i) {
        if (((i) > (this.len - 1)) | i < 0) {
            return null;
        } else {
            if (i == 0) {
                return this.head.getData();
            } else if (i == (this.len - 1)) {
                return this.tail.getData();
            }
            DoubleNode temp = this.head;
            int var = 0;
            while (var != i) {
                var++;
                temp = temp.getNext();
            }
            return (T) temp.getData();
        }
    }

    @Override
    public int len() {
        return 0;
    }

    public String print() {
        if (this.head == null) {
            return "Double list of: ";
        }
        StringBuilder stringBuilder = new StringBuilder("Double list of: ");
        DoubleNode<T> temp = this.head;
        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
    public String printReverse() {
        if (this.head == null) {
            return "Double list (reversed) of:  ";
        }
        StringBuilder stringBuilder = new StringBuilder("Double list:  ");
        DoubleNode<T> temp = this.tail;


        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getPrev();
        }

        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

}
