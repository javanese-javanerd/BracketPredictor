package MarchMadness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Tournament {
	List<Game> gamesList;
	
	public List<Game> initializeTournament() throws IOException{
		gamesList = new ArrayList<Game>();
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(new File("resources//input.txt")));
			String inLine;
			while((inLine = br.readLine()) != null ){
				StringTokenizer tokenizer = new StringTokenizer(inLine, "|");
				while (tokenizer.hasMoreTokens()){
					Game game = new Game();
					game.setTeam1(tokenizer.nextToken().trim());
					game.setTeam2(tokenizer.nextToken().trim());
					gamesList.add(game);
				}
			}
		}
		catch (IOException e){
			// do nothing
		}
		finally{
			if (null != br)
				br.close();
		}
		
		return this.gamesList;
	}
	
	public void commenceTournament(List<Game> games, int round){
		while (games.size() > 0){
			int counter = 0;
			while(counter < games.size()){
				Random random = new Random();
				int gameNumber = random.nextInt(games.size());
				if (null == games.get(gameNumber).getWinner()){
//					System.out.println("Playing game #" + gameNumber + " from round " + round);
					Game game = games.get(gameNumber);
					game.play();
//					System.out.println(game.getTeam1() +  "\t VS \t" + game.getTeam2() + "\t --> " + game.getWinner());
					counter++;
				}
			}
			printResult(games, round);
			
			// generate next round only if there are more than 1 game in current game list
			if (games.size() > 1){
				List<Game> nextRound = generateNextRoundGames(games);
				commenceTournament(nextRound, ++round);
			}
		}
	}
	
	private void printResult(List<Game> games, Integer round){
		System.out.println("RESULT OF ROUND " + round);
		for (Game game : games){
			System.out.println(game.getTeam1() +  " VS " + game.getTeam2() + " --> " + game.getWinner());
		}
		System.out.println("\n***************************************\n");
	}
	
	private List<Game> generateNextRoundGames(List<Game> games) {
		List<Game> nextRound = new ArrayList<Game>();
		
		int index = 0;
		while(index < games.size()){
			Game game1 = games.get(index);
			Game game2 = games.get(++index);
			
			Game nextGame = new Game();
			nextGame.setTeam1(game1.getWinner());
			nextGame.setTeam2(game2.getWinner());
			nextRound.add(nextGame);
			
			index++;
		}
		
		return nextRound;
	}

	public List<Game> getGames(){
		return this.gamesList;
	}
	
	public static void main(String args[]) throws IOException{
		Tournament tourney = new Tournament();
		
		// read input file --> create a list of game
		List<Game> games = tourney.initializeTournament();
		
		// recursively generate results of each round
		tourney.commenceTournament(games, 1);
	}

}
