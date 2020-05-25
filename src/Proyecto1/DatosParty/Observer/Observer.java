package Proyecto1.DatosParty.Observer;




public abstract  class Observer {
    Observable subject;
    public void update(){
        this.subject.getState();
    }
}
