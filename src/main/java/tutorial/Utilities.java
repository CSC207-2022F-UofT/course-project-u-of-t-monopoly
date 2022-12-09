package tutorial;

public class Utilities {
    String owned_player;

    int num_rolls;

    public Utilities(String owned_player, int num_rolls){
        this.owned_player = owned_player;
        this.num_rolls = num_rolls;
    }

    public int getMoneyChange1(){return 4 * this.num_rolls;}

    public int getMoneyChange2(){return 10 * this.num_rolls;}

}