package UseCase;

import Entity.GameBoard;

public class UserCheckGameEnd {

    /**
     * Instantiate a new UserCheckGameEnd object with no parameters
     */
    public UserCheckGameEnd(){
    }

    /**
     * Check whether the game associated with the GameBoard parameter is done
     * @param gameboard the GameBoard object representing the monopoly game
     * @return a boolean true if the game has ended, and false if it hasn't based on the GameBoard entity
     */
    public boolean CheckGameEnd(GameBoard gameboard){
        return gameboard.checkGameEnd();
    }
}
