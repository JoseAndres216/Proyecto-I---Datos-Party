package Proyecto1.DatosParty.SimpleCircularList;

import Proyecto1.DatosParty.MotherList.MotherList;

public class SimpleCircularList<T> extends MotherList {
    private Node<T> head = null;
    private int extension;

    private int getExtension(){
        return this.extension;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void insertFirst(T data){
        Node<T> node = new Node(data);
        if(isEmpty()){
            this.head = node;
            node.setNext(this.head);
            this.extension++;
        } else{
            Node<T> temp = this.head;
            this.head = node;
            node.setNext(temp);
            this.extension++;
        }
    }

    public void insertLast(T data){
        Node<T> node = new Node(data);
        if(isEmpty()){
            this.head = node;
            node.setNext(this.head);
            this.extension++;
        } else{
            Node<T> temp = this.head;
            while(temp.getNext()!=this.head){
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setNext(this.head);
            this.extension++;
        }
    }

    /*public void insertPosition(int position, T data) {
        if(position > this.extension){
            System.out.println("Invalid position");
        } else if(position==1){
            insertFirst(data);
        } else{
            Proyecto1.DatosParty.SimpleLinkedList.Node temp = this.head;
            while((position-2)!=0){
                temp = temp.getNext();
                position--;
            }
            Proyecto1.DatosParty.SimpleLinkedList.Node node = new Proyecto1.DatosParty.SimpleLinkedList.Node(data);
            node.setNext(temp.getNext());
            temp.setNext(node);
            this.extension++;
        }
    }*/

    public boolean isNode(T data){
        Node<T> temp = this.head;
        int nodesLeft = this.extension;
        while(nodesLeft!=0){
            if(temp.getData()==data){
                return true;
            }
            else{
                temp = temp.getNext();
                nodesLeft--;
            }
        }
        System.out.println("Couldn't find the node");
        return false;
    }

    public int searchPosition(T data){
        Node<T> temp = this.head;
        int position=1;
        if(temp.getData().equals(data)) {
            return position;
        }else {
            temp = temp.getNext();
            position++;
        }
        while(temp!=this.head){
            if(temp.getData().equals(data)){
                return position;
            }
            else{
                temp=temp.getNext();
                position++;
            }
        }
        return -1;
    }
    public void editNode(int position, T newData){
        if(position<=0 || position>this.extension){
            System.out.println("The node doesn't exists");
        }else{
            Node<T> temp = this.head;
            int counter = 1;
            while(counter!=position){
                temp = temp.getNext();
                counter++;
            }
            temp.setData(newData);
        }
    }
    public void editNodebyData(T previousData, T newData){
        editNode(searchPosition(previousData), newData);
    }
    public void deleteFirstnode(){
        Node<T> temp = this.head;
        while(temp.getNext()!=this.head){
            temp=temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        this.head = temp.getNext();

    }
    public void deleteLastnode(){
        Node<T> temp = this.head;
        while(temp.getNext().getNext()!=this.head){
            temp=temp.getNext();
        }
        temp.setNext(this.head);
    }
    public void deleteNodebyData(T data){
        int position = searchPosition(data);
        if(position==-1) {
            System.out.println("Couldn't find the node");
        }else if(position==1) {
            deleteFirstnode();
        }else if(position==this.extension){
            deleteLastnode();
        } else{
            Node<T> temp = this.head;
            int counter = 1;
            while((counter+1)!=position){
                temp = temp.getNext();
                counter++;
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public T retrnNodedata(int index){
        if(index<0 || index>=this.extension){
            System.out.println("Node out of range.");
            return null;
        } else{
            Node<T> temp = this.head;
            while(index!=0){
                temp=temp.getNext();
                index--;
            }
            return temp.getData();
        }
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[ ");
        stringBuilder.append(this.head.getData().toString());
        stringBuilder.append(", ");
        Node<T> temp = this.head.getNext();
        while (temp != this.head) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

