package com.lol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Games")
public class GameString {
	@Id
	private Long id;
	private String issue;
    private String lane;
    private String championName;
    private String matchupName;
    
    public GameString() {
    	
    }
    
	public GameString(Long id, String issue, String lane, String champion, String matchup) {
		this.id = id;
		this.issue = issue;
		this.lane = lane;
		this.championName = champion;
		this.matchupName = matchup;
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
	public String getChampion() {
		return championName;
	}
	public void setChampion(String champion) {
		this.championName = champion;
	}
	public String getMatchup() {
		return matchupName;
	}
	public void setMatchup(String matchup) {
		this.matchupName = matchup;
	}
    
    public Game createGame() {
    	Pick champion = new Pick(championName);
    	Matchup matchup = new Matchup(matchupName);
    	return new Game(id, issue, lane, champion, matchup);
    }
}
