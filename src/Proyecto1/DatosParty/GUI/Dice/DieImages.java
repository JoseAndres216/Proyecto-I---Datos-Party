package Proyecto1.DatosParty.GUI.Dice;
import javafx.scene.image.Image;

public class DieImages {
    Image pic1 = new Image("@/Proyecto1/DatosParty/GUI/Resources/images/Die1.png");
    Image pic2 = new Image("@/Proyecto1/DatosParty/GUI/Resources/images/Die2.png");
    Image pic3 = new Image("@/Proyecto1/DatosParty/GUI/Resources/images/Die3.png");
    Image pic4 = new Image("@/Proyecto1/DatosParty/GUI/Resources/images/Die4.png");
    Image pic5 = new Image("@/Proyecto1/DatosParty/GUI/Resources/images/Die5.png");
    Image pic6 = new Image("@/Proyecto1/DatosParty/GUI/Resources/images/Die6.png");

    private int value;
    private Image dieImage = pic1;

    public void setImage(int sides){
        int value = sides;
        if (value == 1)
            dieImage = pic1;
        if (value == 2)
            dieImage = pic2;
        if (value == 3)
            dieImage = pic3;
        if (value == 4)
            dieImage = pic4;
        if (value == 5)
            dieImage = pic5;
        if (value == 6)
            dieImage = pic6;
    }
    public Image getImage(){
        return dieImage;
    }
}
