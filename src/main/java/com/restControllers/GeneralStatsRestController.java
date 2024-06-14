package com.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lol.Game;
import com.lol.GameString;
import com.lol.Matchup;
import com.lol.Pick;
import com.services.GameStringService;
import com.services.MatchupService;
import com.services.PickService;

@RestController
public class GeneralStatsRestController {
	
	@Autowired
	private GameStringService gameStringService;
	
	@Autowired
	private PickService pickService;
	
	@Autowired
	private MatchupService matchupService;
	
	@PostMapping("/main_data")
	public void getMainData(@RequestBody List<GameString> gameStrings) {
		for (GameString gameString: gameStrings) {
			Game game = gameString.createGame();
			Pick champion = game.getChampion();
			Matchup matchup = game.getMatchup();
			//création des tables de champions Pick et Matchup
			pickService.createPick(champion);
			matchupService.createMatchup(matchup);
		}
		//stockage des games sous format String et création de la table des GameStrings
		gameStringService.setGameStrings(gameStrings);
		gameStringService.createGameStrings();
		/*
		for (Game game : games) {
            System.out.println("id: " + game.getId() + ", issue: " + game.getIssue() + ", lane: " + game.getLane() + ", champion: " + game.getChampion().getName() + ", match up: " + game.getMatchup().getName());
		}
		*/
	}
}
