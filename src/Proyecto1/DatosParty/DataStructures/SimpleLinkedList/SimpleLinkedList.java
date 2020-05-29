package Proyecto1.DatosParty.DataStructures.SimpleLinkedList;

import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;

public class SimpleLinkedList <T> implements MotherList<T> {
    private SimpleNode<T> head = null;
    private int extension = 0;

    public int len() {
        return extension;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void insertFirst(T data){
        SimpleNode simpleNode = new SimpleNode(data);
        if(isEmpty()){
            this.head = simpleNode;
            this.extension++;
        } else {
            SimpleNode temp = this.head;
            this.head = simpleNode;
            simpleNode.setNext(temp);
            this.extension++;
        }
    }
    public void insertLast(T data){
        SimpleNode simpleNode = new SimpleNode(data);
        if(isEmpty()){
            this.head = simpleNode;
            this.extension++;
        } else{
            SimpleNode temp = this.head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(simpleNode);
            this.extension++;
        }
    }

    @Override
    public T accessNode(int i) {
        return null;
    }


    public void insertPosition(int position, T data) {
        if(position > this.extension){
            System.out.println("Invalid position");
        } else if(position==1){
            insertFirst(data);
        } else {
            SimpleNode temp = this.head;
            while ((position - 2) != 0) {
                temp = temp.getNext();
                position--;
            }
            SimpleNode simpleNode = new SimpleNode(data);
            simpleNode.setNext(temp.getNext());
            temp.setNext(simpleNode);
            this.extension++;
        }
    }
    public boolean isNode(T data){
        SimpleNode temp = this.head;
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
        return false;
    }
    public int searchPosition(T data){
        SimpleNode temp = this.head;
        int position = 1;
        while(temp!=null){
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
            SimpleNode temp = this.head;
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
        SimpleNode temp = this.head;
        this.head = temp.getNext();
    }
    public void deleteLastnode(){
        SimpleNode temp = this.head;
        while(temp.getNext().getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(null);
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
            SimpleNode temp = this.head;
            int counter = 1;
            while((counter+1)!=position){
                temp = temp.getNext();
                counter++;
            }
            temp.setNext(temp.getNext().getNext());
        }
    }


    @Override
    public String toString() {
        if (this.head == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[ ");
        SimpleNode<T> temp = this.head;
        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
