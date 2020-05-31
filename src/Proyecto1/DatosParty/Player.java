package Proyecto1.DatosParty;

public class Player {

    private int coins;
    private int stars;
    private int playernumber;
    private int minigamepoints;
    //Configurations for the movement of the player
    private Phase actualPhase;
    private int SpacesToMove;

    public Player(int playerNumber){
        this.coins = 0;
        this.stars = 0;
        this.playernumber = playerNumber;
        this.coins = 0;
        this.minigamepoints = 0;
    }
}
