package Proyecto1.DatosParty.Observer;


/*
Abstract class for the observer
 */

public abstract  class Observer {
    Observable subject;
    public void update(){
        this.subject.getState();
    }
}
