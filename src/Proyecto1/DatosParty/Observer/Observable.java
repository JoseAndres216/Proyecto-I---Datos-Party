package Proyecto1.DatosParty.Observer;
/*
Abstract class for the observable

 */
public class Observable {
    private Observer observer;
    /*
    Observer: a observer to attach
     */
    public void attach(Observer observer){
        this.observer = observer;
    }
    void notifyObservers(){
    }
    public boolean getState(){
       return true;
    }
    void setState(boolean newState){

    }
    void notifyObserver(){
        this.observer.update();
    }
}
