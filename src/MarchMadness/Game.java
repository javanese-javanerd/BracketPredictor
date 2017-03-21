package MarchMadness;

public class Game {
	private String team1;
	private String team2;
	private String winner;
	private String loser;
	
	public void play(){
		// randomize winner and loser
		if (Math.random() > 0.5){
			winner = team1;
			loser = team2;
		}
		else {
			winner = team2;
			loser = team1;
		}
	}
	
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getLoser() {
		return loser;
	}
	public void setLoser(String loser) {
		this.loser = loser;
	}
}
