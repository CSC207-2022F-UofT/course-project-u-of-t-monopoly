# U of T Monopoly
Below are the general rules, functionality, and a brief description of the implementation of our Monopoly game. 
# Game Rules 
The monopoly game we have implemented is a 2-4 player interactive gameboard program. Upon initialization of the game, users are prompted to role the dice of the program. After a player rolls a dice the following mutually exclusive events may occur: 
-	Land on a tile that is not owned by another player. The user is asked if they want to buy it. 
-	Land on a tile that is owned by another player. The user pays rent based on the number of buildings owned for Properties tiles regular rent for Utilities and RailRoads
-	Land on a chance or communitycard tile. The user is prompted with action resulting from the associated drawn card 
-	Land on “Go to Jail” tile. The user is sent to jail, and is given three tries to get out by rolling doubles. If this is not achieved, pay the fine. 
-	Pass “Go” on a dice roll. The player collects $200 for passing “Go”
-	The player lands on “Free Parking”. Nothing changes to the Player’s state except for their position. 
-	The player lands on the “Jail” tile. The player is just visiting, and nothing changes to the player’s state except their position. 
-	The player lands on the “Income Tax” tile. They lose $200 
-	The player lands on the “Luxury Tax” tile. They lose $100
Our Monopoly game continue until there is only one player left who has money to play the game. The rest of the players have been deemed bankrupt at this point. The remaining player is the winner!
# Running the Program 
Our Monopoly game is run through a java file, Main.java. Once the file is run, the UI (through Swing) is built, and the user is prompted to enter the number of players. After which each player enters their username. After this initialization, the board game screen (UI) is formed, and the players are asked to start the game by the first player (with player id of 1) to have the first roll. The players are continuously asked to roll the dice, during which the game will follow the rules denoted above. The game continues until only one player is left with a balance in their bank. 
# Implementation
As part of our implementation plan, we started at the “high-levels” of the clean architecture framework by coding the entities representing the various noun components of the game. These can be found in the Entity package with the src file. Working from the inside out, we then implemented the Usecases for the program. These can be found in the UseCase package within the SRC file on our project repository. In following clean architecture, we developed various controller classes to send and receive, from the UseCase level the basic inputs needed to update the UI. 


