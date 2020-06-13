package Proyecto1.DatosParty.Observer;

/**
 * Abstract class of a Observable subject, for the observer pattern,
 */
public class Observable {
    private Observer observer;

    /**
     * Method for attaching a observer
     *
     * @param observer an observer to attach to the subject.
     */
    public void attach(Observer observer) {
        this.observer = observer;
    }

    void notifyObservers() {
    }


    /**
     * Method for sharing the actual status of the box
     *
     * @return true if its being used by other player, false if not.
     */
    public boolean getState() {
        return true;
    }

    void setState(boolean newState) {

    }

    void notifyObserver() {
        this.observer.update();
    }
}
