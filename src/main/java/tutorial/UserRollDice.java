package tutorial;

import java.util.ArrayList;

public class UserRollDice {


    Player player;
    Gameboard gameboard;

    /**
     * This class will be used when one player roll a die and make movement.
     *
     * @param player The player who rolls the die and reacts.
     * @param gameboard The game board.
     */

    public UserRollDice(Player player, Gameboard gameboard) {
        this.player = player;
        this.gameboard = gameboard;
    }

    /**
     * This method is used to roll a die and make corresponding changes.
     *
     * @return the corresponding message shown to player.
     */

    public String react() {
        Player player = this.player;
        Gameboard gameboard = this.gameboard;
        ArrayList<Integer> move = player.rollDice();
        int movement = move.get(0) + move.get(1);
        gameboard.movePlayer(player, movement);
        // move the player responding to the dice
        int position = player.getPlayerPosition();
        Properties properties = gameboard.getTile(position);
        if (properties.getOwner() == null) {
            // player lands on an unowned properties.
            return userPresenter.prepareView("Would you like to buy this " + properties.getName() + " ?");
        } else if (properties.getOwner() == player) {
            // the land is owned by the player.
            return userPresenter.prepareView("Would you like to build a house or a hotel to " +
                    "raise the value of the property?");
        } else (properties.OwnedByPlayer()) {
            // player lands on a properties owned by other player and the player should pay the rent.
            if (player.getMoney() >= properties.getRent()) {
                player.loseMoney(properties.getRent());
                properties.getOwner().addMoney(properties.getRent());
                return userPresenter.prepareView(player.getUsername() +
                        " lands on an owned property and losses " +
                        properties.getRent() + "\n " + properties.getOwner().getUsername()
                        + " gets " + properties.getRent());
            } else {
                return userPresenter.prepareView(player.getUsername() + " does not have enough money" + "\n" +
                        "Sell or mortgage your properties");
            }
        } //else {
            // player lands on a jail, use other use case interactor.
           //if (properties.isinstanceof(Jail)) {
           //    UserInteracttoJail userInteracttoJail = new UserInteracttoJail(player, preperties);
           //    return userInteracttoJail.react();
           //} else {return userPresenter.prepareView("Error");}
        //}
    }

// should add cases of landing on jails, community chest or chance tile.

}
