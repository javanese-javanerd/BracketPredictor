# BracketPredictor
The original goal of this project is to randomly generate winner of 2017 NCAA men's basketball tournament. The intention is to prove that a randomly generated bracket performs no worse than that of professionally analyzed ones.

An input should be provided in /resources/input.txt. Each line represents a game in which team names should be separated by a pipe (|). For example: 
Villanova | Mt. St. Mary's 
Wisconsin | Va. Tech 
Virginia | UNC-Wilm 
Florida | ETSU

At the beginning of this program, the input file will be read and a list of games will be generated. Then, the program will randomly select a game and randomly choose the winner of such game until all games are processed. Afterwards, games for next round will be generated and the process of randomly selecting winner repeats until a final game is processed. Result of each round is printed in the console.

LIMITATION: No input validation is provided within this application. As such, user is responsible to provide the correct amount of games in the text file.
