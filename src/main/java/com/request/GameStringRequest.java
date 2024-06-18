package com.request;

public class GameStringRequest {
	private String issue;
    private String lane;
    private String champion;
    private String matchup;
    
    public GameStringRequest() {
    	
    }
    
	public GameStringRequest(String issue, String lane, String champion, String matchup) {
		this.issue = issue;
		this.lane = lane;
		this.champion = champion;
		this.matchup = matchup;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public String getMatchup() {
		return matchup;
	}

	public void setMatchup(String matchup) {
		this.matchup = matchup;
	}
}
