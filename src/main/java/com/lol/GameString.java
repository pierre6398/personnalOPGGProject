package com.lol;

import com.request.GameStringRequest;

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
	
	public GameString(Long id, GameStringRequest gameStringRequest) {
		this.id = id;
		this.issue = gameStringRequest.getIssue();
		this.lane = gameStringRequest.getLane();
		this.championName = gameStringRequest.getChampion();
		this.matchupName = gameStringRequest.getMatchup();
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
	public String getChampionName() {
		return championName;
	}
	public void setChampionName(String champion) {
		this.championName = champion;
	}
	public String getMatchupName() {
		return matchupName;
	}
	public void setMatchupName(String matchup) {
		this.matchupName = matchup;
	}
    
    public Game createGame() {
    	Pick champion = new Pick(championName);
    	Matchup matchup = new Matchup(matchupName);
    	return new Game(id, issue, lane, champion, matchup);
    }
    
    public void printGameString() {
    	 System.out.println("id: " + id + ", issue: " + issue + ", lane: " + lane + ", champion: " + championName + ", match up: " + matchupName);
    }
}
