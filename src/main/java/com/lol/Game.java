package com.lol;

public class Game {
	private Long id;
	private String issue;
    private String lane;
    
    private Pick champion;
    private Matchup matchup;
    
    public Game(Long id ,String issue, String lane, Pick champion, Matchup matchup) {
    	this.id = id;
        this.issue = issue;
        this.lane = lane;
        this.champion = champion;
        this.matchup = matchup;
    }

    public Game() {
		
	}
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
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

    public Pick getChampion() {
        return champion;
    }

    public void setChampion(Pick champion) {
        this.champion = champion;
    }

    public Matchup getMatchup() {
        return matchup;
    }

    public void setMatchup(Matchup matchup) {
        this.matchup = matchup;
    }
}
