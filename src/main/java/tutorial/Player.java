package tutorial;


public class Player {


    String username; // name of the player
    int money;

    int playerPosition;
    String opportunityCards;

    boolean inJail;

    ArrayList<Building> buildings = new ArrayList<Building>();

    ArrayList<Utilities> utilities = new ArrayList<Utilities>();

    ArrayList<Railroad> railroads = new ArrayList<Railroad>();

    public Player(String username,int money,int position,String opportunityCards){
        this.username = username;
        this.money = money;
        this.playerPosition = position;
        this.opportunityCards = opportunityCards;
    }
    public String getUsername(){
        return this.username;
    }

    public int getMoney(){
        return this.money;
    }

    public int loseMoney(int amount){
        if(this.money >= amount){
            this.money -= amount;
        }
        else{
            this.money = 0;
        }
        return amount;
    }

    public int getPlayerPosition(){
        return this.playerPosition;
    }

    public void addMoney(int amount){
        this.money += amount;
    }

    public void addProperty(Building property){
        buildings.add(property);
    }
    public void addProperty(Utilities property){
        utilities.add(property);
    }
    public void addProperty(Railroad property){
        railroads.add(property);
    }
    public void inJail(boolean trueorfalse) {
        this.inJail = trueorfalse;
    }









}
