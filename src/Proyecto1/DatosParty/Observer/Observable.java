package Proyecto1.DatosParty.Observer;

public class Observable {
    private Observer observer;

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
