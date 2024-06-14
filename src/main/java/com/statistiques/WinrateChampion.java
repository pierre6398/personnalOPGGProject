package com.statistiques;

import java.util.HashMap;
import java.util.Map;

import com.lol.Matchup;

public class WinrateChampion {
	private String nameChampion;
	private Map<Matchup,Integer> nbGamesAgainst;
    private Map<Matchup,Double> winrateAgainst;

    public WinrateChampion(String name){
    	this.nameChampion = name;
    	this.nbGamesAgainst = new HashMap<>();
        this.winrateAgainst = new HashMap<>();
    }

    public Map<Matchup, Integer> getNbGamesAgainst() {
        return nbGamesAgainst;
    }

    public void setNbGamesAgainst(Map<Matchup, Integer> nbGamesAgainst) {
        this.nbGamesAgainst = nbGamesAgainst;
    }
    
    public void putNbGamesAgainst(Matchup matchup, Integer nbGames) {
    	this.nbGamesAgainst.put(matchup, nbGames);
    }

    public Map<Matchup,Double> getWinrateAgainst() {
        return winrateAgainst;
    }

    public void setWinrateAgainst(Map<Matchup,Double> winrateAgainst) {
        this.winrateAgainst = winrateAgainst;
    }
    
    public void putWinrateAgainst(Matchup matchup, Double winrateAgainst) {
    	this.winrateAgainst.put(matchup, winrateAgainst);
    }

    public double updateWinrate(double actualWinrate, int nbGames, int intIssue){
        return ((actualWinrate*nbGames)/100+intIssue)/(nbGames+1)*100;
    }

    public int nbGamesTotal(){
        int nbTotal = 0;
        for (int nbGames : nbGamesAgainst.values()){
            nbTotal += nbGames;
        }
        return nbTotal;
    }

    public double winrateTotal(){
        int nbTotal = nbGamesTotal();
        double nbWins = 0;
        for (Matchup matchup: nbGamesAgainst.keySet()){
            nbWins += winrateAgainst.get(matchup)*nbGamesAgainst.get(matchup)/100;
        }
        return nbWins / nbTotal * 100;
    }

	public String getNameChampion() {
		return nameChampion;
	}

	public void setNameChampion(String nameChampion) {
		this.nameChampion = nameChampion;
	}
}
