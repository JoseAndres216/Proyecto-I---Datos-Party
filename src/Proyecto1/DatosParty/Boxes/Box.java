package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.Observer.Observable;
import Proyecto1.DatosParty.Observer.Observer;

public abstract class Box extends Observable {
    private boolean busy;
    static int id;
    private Observer observer;

        @Override
    public boolean getState(){
        return this.busy;
    }

    public void setState(boolean newState){
        this.busy = newState;
    }
    @Override
    public void attach(Observer observer){
        this.observer = observer;
    }

    public void notifyObserver(){
        this.observer.update();
    }
}
