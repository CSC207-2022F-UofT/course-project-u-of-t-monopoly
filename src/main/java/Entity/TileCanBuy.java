package Entity;

public abstract class TileCanBuy {


    public abstract int getPrice();

    public abstract int getRent();

    public abstract int getMortgageValue();

    public abstract String getName();

    public abstract Player getOwner();

    public abstract void resetOwner(Player p);

    public abstract void resetOwner();
}
