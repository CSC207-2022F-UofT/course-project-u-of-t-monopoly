package tutorial;

public class BuyPropertyProcessor {
    private Player player;
    private Properties properties;

    public BuyPropertyProcessor(Player player, Properties properties) {
        // assume controller passes an object of Player and an object of Properties
        this.player = player;
        this.properties = properties;
    }

    public boolean BuyProperty() {
        if (this.player.getMoney() >= this.properties.getPrice()) {
            if (!this.properties.OwnedByPlayer()){
                this.player.loseMoney(this.properties.getPrice());
                this.properties.resetOwner(this.player);
                return true;
            }
        }
        return false;
        // we also need to check whether this player's position on the board is the position of this property, so JUST
        // after the player moved, controller decide whether to call this method.
        // So in controller, the code looks like: if (processor.BuyProperty()) {do something such as call presentor. ...}
    }
}
