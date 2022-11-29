package tutorial;

import java.util.ArrayList;

public class UserRollDice {

    Player player;
    Gameboard gameboard;

    public UserRollDice(Player player, Gameboard gameboard) {
        this.player = player;
        this.gameboard = gameboard;
    }

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
        } else if (gameboard.players.contains(properties.getOwner())) {
            // player lands on a properties owned by other player and the player should pay the rent.
            if (player.getMoney() >= properties.getRent()) {
                player.loseMoney(properties.getRent());
                properties.getOwner().addMoney(properties.getRent());
                return userPresenter.prepareView(player.getUsername() +
                        " lands on an owned property and losses " +
                        properties.getRent() + "\n " + properties.getOwner().getUsername()
                        + " gets " + properties.getRent());
            } else {
                player.money = 0;
                return userPresenter.prepareView(player.getUsername() + " losses all money.");
            }
        } else {
            // player lands on utilities or a jail, use other use case interactor.
           if (properties.isinstanceof(Utilities)) {
               UserInteracttoUtilities userInteracttoUtilities = new UserInteracttoUtilities(player, properties);
               return userInteracttoUtilities.react();
           } else if (properties.isinstanceof(Jail)) {
               UserInteracttoJail userInteracttoJail = new UserInteracttoJail(player, preperties);
               return userInteracttoJail.react();
           } else {return userPresenter.prepareView("Error");}
        }
    }



}
