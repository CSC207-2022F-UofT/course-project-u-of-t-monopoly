package tutorial;

public class Utilities {
    int player_id;
    //subject to change as we have not decided which to use to indicate the owner.

    String name;

    public Utilities(String name){
        this.name = name;
    }

    public String getName(){return this.name;}

    public void setOwner(int player_id){
        this.player_id = player_id;
    }

    public int getOwner(){return this.player_id;}

    public int getMoneyChange1(int num_rolls){return 4 * num_rolls;}

    public int getMoneyChange2(int num_rolls){return 10 * num_rolls;}

}
