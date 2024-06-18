package com.response;

public class GeneralStatsResponse {
	private int nbGames;
	private String totalWinrate;
	
	public GeneralStatsResponse(int nbGames, String totalWinrate) {
		this.nbGames = nbGames;
		this.totalWinrate = totalWinrate;
	}

	public int getNbGames() {
		return nbGames;
	}

	public void setNbGames(int nbGames) {
		this.nbGames = nbGames;
	}

	public String getTotalWinrate() {
		return totalWinrate;
	}

	public void setTotalWinrate(String totalWinrate) {
		this.totalWinrate = totalWinrate;
	}
}
