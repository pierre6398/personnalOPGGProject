package com.statistiques;

import java.util.ArrayList;
import java.util.List;

import com.lol.Game;
import com.lol.Matchup;

public class Manager {
	
	private List<Game> games;
	private List<WinrateChampion> winrateChampions;
	
	public Manager(List<Game> games) {
		this.games = games;
		this.winrateChampions = new ArrayList<WinrateChampion>();
		WinrateChampion winrateKatarina = new WinrateChampion("Katarina");
		winrateChampions.add(winrateKatarina);
	}
	
	public Manager() {
		
	}

	public void createStats() {
		for (Game game : games) {
			updateWithNewGame(game);
		}
	}	
	
	public void updateWithNewGame(Game newGame){
        updateWinrateChampions(newGame);
    }
	
	public void updateWinrateChampions(Game newGame) {
		WinrateChampion winrateChampion = winrateChampions.get(0);
		String issue = newGame.getIssue();
        Matchup matchup = newGame.getMatchup();
        boolean newChamp = true;
        //actualisation du nombre de games
        int nbGames = 0;
        double actualWinrateAgainst = 0;
        if (winrateChampion.getWinrateAgainst().containsKey(matchup)){
        	actualWinrateAgainst = winrateChampion.getWinrateAgainst().get(matchup);
            nbGames = winrateChampion.getNbGamesAgainst().get(matchup);
            newChamp = false;
        }
        double newWinrate;
        if (issue.equals("Victoire")){
        	if(!newChamp) {
        		newWinrate = winrateChampion.updateWinrate(actualWinrateAgainst, nbGames, 1);
        	}
        	else {
        		newWinrate = 100.0;
        	}	
        }
        else{
        	if(!newChamp) {
        		newWinrate = winrateChampion.updateWinrate(actualWinrateAgainst, nbGames, 0);
        	}
        	else {
        		newWinrate = 0.0;
        	}
        }
        winrateChampion.putNbGamesAgainst(matchup,nbGames+1);
        winrateChampion.putWinrateAgainst(matchup, newWinrate);
	}

	public List<WinrateChampion> getWinrateChampions() {
		return winrateChampions;
	}

	public void setWinrateChampions(List<WinrateChampion> winrateChampions) {
		this.winrateChampions = winrateChampions;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}
