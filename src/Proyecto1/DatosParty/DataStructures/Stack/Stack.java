package Proyecto1.DatosParty.DataStructures.Stack;

import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;

public class Stack<T extends Comparable<T>>{
    private SimpleLinkedList<T> List = new SimpleLinkedList<>();
    public boolean isEmpty(){
        return List.isEmpty();
    }
    public void push(T data){
            List.insertLast(data);
            }

    public void pop(){
            List.deleteLastnode();
            }

    public T peek(){
            SimpleNode temp = List.getHead();
            while(temp.getNext()!=null){
            temp=temp.getNext();
            }
            return (T) temp.getData();
            }

    public String toString(){
        if (this.List.getHead() == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[ ");
        SimpleNode<T> temp = this.List.getHead();
        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

}
