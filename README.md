# U of T Monopoly
Below are the general rules, functionality, and a brief description of the implementation of our Monopoly game. 
# Game Rules 
The monopoly game we have implemented is a 2-4 player interactive gameboard program. Upon initialization of the game, users are prompted to role the dice of the program. Each player starts the game with $1500.00. After a player rolls a dice the following mutually exclusive events may occur: 
-	Player loses the game when balance < $0
-	Player can trade with other players between dice rolls
-	Player rolls 2 dice
- If a player lands on or passes Go they collect $200
- If a player lands on Free Parking or Just Visiting In Jail, nothing happens
- If a player lands on Go To Jail, they Go TO Jail without collecting $200 if they pass Go
- If a player lands on Income Tax, they lose $200
- If a player lands on Luxury Tax they lose $100
o	If a player rolls double thrice in a row, they go to jail
-	Jail
o	Player can still interact with other players (I.e trade, collect rent, etc)
o	3 turns to roll a double to get out
o	After three turns, must pay a $50 bail
-	Buying a Property
o	Each property has a buy price, mortgage value, and rent value
-	Mortgage a Property
o	Player receives the mortgage value
o	To unmortgage, pay 1.1x mortgage value.
o	Player cannot collect rent on a mortgaged property
-	Build House/Hotel
o	House and hotel have a build cost.
o	To build a house player must own the full (colour) set
o	Houses must be built evenly. (I.e. Every property in the set must have 1 house built before player can build a second house)
o	Player can build a hotel after building 4 houses
-	Land on Utility
o	Pay 4x / 10x the number rolled by dice if owner owns 1 / 2 utilities
-	Land on Railroad
o	Pay $25 / $50 / $100 / $200 if owner owns 1 / 2 / 3 / 4 railroads
-	

Our Monopoly game continue until there is only one player left who has money to play the game. The rest of the players have been deemed bankrupt at this point. The remaining player is the winner!

# Running the Program 
Our Monopoly game is run through a java file, Main.java. Once the file is run, the UI (through Swing) is built, and the user is prompted to enter the number of players. After which each player enters their username. After this initialization, the board game screen (UI) is formed, and the players are asked to start the game by the first player (with player id of 1) to have the first roll. The players are continuously asked to roll the dice, during which the game will follow the rules denoted above. The game continues until only one player is left with a balance in their bank. 
# Implementation
As part of our implementation plan, we started at the “high-levels” of the clean architecture framework by coding the entities representing the various noun components of the game. These can be found in the Entity package with the src file. Working from the inside out, we then implemented the Usecases for the program. These can be found in the UseCase package within the SRC file on our project repository. In following clean architecture, we developed various controller classes to send and receive, from the UseCase level the basic inputs needed to update the UI. 


