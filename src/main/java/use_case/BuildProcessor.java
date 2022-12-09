package UseCase;

import Entity.*;

import java.util.Dictionary;

/**
 * BuildProcessor class to check if a House or Hotel can be built given a Player object and a Properties
 * object. 
 */
public class BuildProcessor {
    private Player player;
    private Properties properties;

    private GameBoard gameBoard;

    /**
     * Instantiate a new BuildProcessor class
     * @param player the Player object associated with the build move (a player looking to build)
     * @param properties the Properties object the player wishes to build on
     * @param gameBoard the overall GameBoard object representing the state of the game
     */
    public BuildProcessor(Player player, Properties properties, GameBoard gameBoard) {
        // controller pass an object of Player and an object of Properties
        this.player = player;
        this.properties = properties;
        this.gameBoard = gameBoard;
    }

    /**
     * Check to see if building a house is possible based on the players owned Properties
     * @param house the House object to be built (if possible)
     * @return return true, if the house was built, false otherwise
     */
    public boolean Build(House house) {
        // controller calls HouseHotelGenerator to generate a house
        if (this.BuildChecker(house)){
            this.player.loseMoney(house.getPrice());
            this.properties.buildBuilding(house);
            return true;
        }
        return false;
    }

    /**
     * Check to see if building a Hotel is possible based on the players owned properties
     * @param hotel the Hotel objec to be built (if possible)
     * @return true if the hotel was built, false otherwise
     */
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

    /**
     * Check to see if a House or Hotel can be built on a Properties object
     * @param building the Building object (hotel or house) that is to be built
     * @return true if the Building can be built, false otherwise
     */
    public boolean BuildChecker(Building building) {
        // helper function to avoid duplicated code
        if (this.player.getMoney() >= building.getPrice()){
            return this.properties.getOwner() == this.player;
        }
        return false;
    }

}
