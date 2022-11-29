package tutorial;

public class BuildProcessor {
    private Player player;
    private Properties properties;

    public BuildProcessor(Player player, Properties properties) {
        // controller pass an object of Player and an object of Properties
        this.player = player;
        this.properties = properties;
    }

    public boolean Build(House house) {
        // controller calls HouseHotelGenerator to generate a house
        if (this.BuildChecker(house)){
            this.player.loseMoney(house.getPrice());
            this.properties.buildBuilding(house);
            return true;
        }
        return false;
    }

    public boolean Build(Hotel hotel) {
        // controller calls HouseHotelGenerator to generate a house
        if (this.BuildChecker(hotel)){
            this.player.loseMoney(hotel.getPrice());
            // since when hotel is built, all houses are removed.
            this.properties.removeBuilding();
            this.properties.buildBuilding(hotel);
            return true;
        }
        return false;
    }

    public boolean BuildChecker(Building building) {
        // helper function to avoid duplicated code
        if (this.player.getMoney() >= building.getPrice()){
            return this.properties.getOwner() == this.player;
        }
        return false;
    }

}
