package Proyecto1.DatosParty.DoubleLinkedList;
import Proyecto1.DatosParty.MotherList.MotherList;
import Proyecto1.DatosParty.SimpleLinkedList.Node;


public class DoubleLinkedList<T> extends MotherList{

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
        }
        else{
            this.tail.setNext(newElement);
            newElement.setPrev(this.tail);
            this.tail = tail;
            this.len++;
        }


    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "Double list: []";
        }
        StringBuilder stringBuilder = new StringBuilder("Double list: [ ");
        DoubleNode<T> temp = this.head;
        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
