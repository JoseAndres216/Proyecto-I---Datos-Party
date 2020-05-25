package Proyecto1.DatosParty.Observer;

import Proyecto1.DatosParty.Boxes.Box;
/*
Concrete observer for keeping in control the state of de box, to know when it's other player already or not.
 */
public class BoxObserver extends Observer {
    public BoxObserver(Box observable){
        this.subject = observable;
        this.subject.attach(this);
    }
    public void update() {
        System.out.println(this.subject.getState());

        // aca va el codigo para verificar si la casilla esta o no ocupada y actuar como corresponda


    }
}
