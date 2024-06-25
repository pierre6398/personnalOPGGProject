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
		WinrateChampion winrateZed = new WinrateChampion("Zed");
		WinrateChampion winrateVelKoz = new WinrateChampion("Vel'Koz");
		WinrateChampion winrateEzreal= new WinrateChampion("Ezreal");
		winrateChampions.add(winrateKatarina);
		winrateChampions.add(winrateZed);
		winrateChampions.add(winrateVelKoz);
		winrateChampions.add(winrateEzreal);
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
		String championName = newGame.getChampion().getName();
		WinrateChampion winrateChampion = getWinrateChampionByName(championName);
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
	
	public WinrateChampion getWinrateChampionByName(String name) {
		for (WinrateChampion winrateChampion : winrateChampions) {
			if(winrateChampion.getNameChampion().equals(name)) {
				return winrateChampion;
			}
		}
		return null;
	}
	
	public int getNbGames() {
		return games.size();
	}
	
	public double getTotalWinrate() {
		int S = 0;
		for (Game game : games) {
			if (game.getIssue().equals("Victoire")) {
				S++;
			}
		}
		return S*100.0/getNbGames();
	}
}
