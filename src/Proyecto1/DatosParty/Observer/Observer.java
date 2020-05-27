package Proyecto1.DatosParty.Observer;


/**
 * Abstract class, base for the observer object.
 */
public abstract  class Observer {
    Observable subject;

    public void update(){
        this.subject.getState();
    }
}
