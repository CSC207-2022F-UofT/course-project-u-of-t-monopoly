package ControllerPresenter;

import Entity.GameBoard;
import Entity.Jail;
import Entity.Player;
import Entity.TileCanBuy;
import UseCase.*;

import java.util.ArrayList;
import java.util.Objects;

public class Controller {

    private final Player player;
    private GameBoard gameBoard;

    private Jail jail;

    public Controller(Player player, GameBoard gameBoard) {
        this.player = player;
        // Notice the jail comes from GameBoard Factory
        this.gameBoard = gameBoard;
        this.jail = (Jail) gameBoard.getTile(9);
    }

    public void PlayerTakesTurn() {
        // first, check whether the player is in Jail.
        PlayerInJailProcessor playerInJailProcessor = new PlayerInJailProcessor(this.player, this.jail);
        if (playerInJailProcessor.playerInJail()) {

            PlayerInJailPresenter presenter = new PlayerInJailPresenter();
            if (!playerInJailProcessor.playerHasFreeCard()) {
                if (this.helperRollDiceInJail(presenter, playerInJailProcessor, this.player)) {
                    playerInJailProcessor.setPlayerFree();
                    presenter.youAreFree();
                } else {
                    presenter.youAreNotFree();
                    playerInJailProcessor.spentOneTurn();
                }
            } else {
                ArrayList<Object> bool = new ArrayList<>(1);
                bool.add(null);
                presenter.askRollDice(bool);
                // stuck the code until UI passes information to controller
                while (bool.get(0) == null) {
                    System.out.println("");
                }
                if (Objects.equals(bool.get(0), true)) {
                    if (this.helperRollDiceInJail(presenter, playerInJailProcessor, this.player)) {
                        playerInJailProcessor.setPlayerFree();
                        presenter.youAreFree();
                    }
                 else {
                    ArrayList<Object> bool2 = new ArrayList<>(1);
                    bool2.add(null);
                    presenter.askUsingFreeCard(bool2);
                    // stuck the code until UI passes information to controller
                    while (bool2.get(0) == null) {
                        System.out.println("");
                    }
                    if (Objects.equals(bool2.get(0), true)) {
                        playerInJailProcessor.playerUseFreeCard();
                        playerInJailProcessor.setPlayerFree();
                        presenter.youAreFree();
                    } else {
                        presenter.youAreNotFree();
                        playerInJailProcessor.spentOneTurn();
                    }
                }
                }
            }
        }

        // second, if player is not in Jail
        else {



            MovePlayer mp = new MovePlayer(this.player, this.gameBoard);
            PlayGamePresenter pgp = new PlayGamePresenter();

            ArrayList<Integer> rolls = new ArrayList<>();
            rolls.add(0);
            rolls.add(0);
            UserRollDice urd = new UserRollDice(this.player);
            PlayerNameGetter nameGetter = new PlayerNameGetter();
            pgp.RollDice(urd, rolls, nameGetter.getName(this.player));
            while (rolls.get(0) == 0 && rolls.get(1) == 0){
                System.out.println("");
            }

            Integer previousPosition = mp.getPosition();
            Integer currPosition = mp.move(rolls);
            // check whether player passes Go tile.
            if (currPosition < previousPosition) {
                mp.passGo();
            }

            // Formally start the core of this method
            Object tile = mp.getTileLanded(currPosition);

            PlayerGoToJailProcessor pgtjp = new PlayerGoToJailProcessor(this.player, this.gameBoard);
            DeckDealToPlayer ddtp = new DeckDealToPlayer(this.player,this.gameBoard);

            UserTileInteractor uti = new UserTileInteractor(null, this.player, this.gameBoard);

            if (tile instanceof TileCanBuy) {
                uti = new UserTileInteractor((TileCanBuy) tile, this.player, this.gameBoard);
            }



            TileHandler tileHandler = new TileHandler(mp,pgp,pgtjp, rolls, ddtp, uti );

            Object message = tileHandler.HandleTile(tile);
            if (Objects.equals(message, "Bankrupt")) {
                mp.PlayerOut();
            }
        }
        


    }

    public boolean helperRollDiceInJail(PlayerInJailPresenter presenter, PlayerInJailProcessor processor, Player player) {
        ArrayList<Integer> rolls = new ArrayList<>(2);
        rolls.add(0);
        rolls.add(0);
        presenter.RollDice(rolls, player);
        // stuck the code until UI passes information to controller
        while (rolls.get(0) == 0 & rolls.get(1) == 0){
            System.out.println("");
        }
        if (Objects.equals(rolls.get(0), rolls.get(1))) {
//            processor.setPlayerFree();
//            presenter.youAreFree();
            return true;
        }
        return false;
    }



}
