package com.restControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lol.Game;
import com.lol.GameString;
import com.lol.Matchup;
import com.lol.Pick;
import com.request.GameStringRequest;
import com.response.GeneralStatsResponse;
import com.services.DisplayService;
import com.services.GameStringService;
import com.services.MatchupService;
import com.services.PickService;
import com.statistiques.Manager;
import com.statistiques.WinrateChampion;

@RestController
public class GeneralStatsRestController {
	
	@Autowired
	private GameStringService gameStringService;
	
	@Autowired
	private PickService pickService;
	
	@Autowired
	private MatchupService matchupService;
	
	@Autowired
	private DisplayService displayService;
	
	@PostMapping("/main_data")
	public void getMainData(@RequestBody List<GameStringRequest> gameStringRequests) {
		List<GameString> gameStrings = new ArrayList<GameString>();
		for (int i=0; i<gameStringRequests.size(); i++) {
			GameStringRequest gameStringRequest = gameStringRequests.get(i);
			GameString gameString = new GameString((long) i, gameStringRequest);
			gameStrings.add(gameString);
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
	
	@GetMapping("/winrate")
	public ResponseEntity<GeneralStatsResponse> getTotalWinrate() {
		List<Game> games = gameStringService.getGames();
        Manager manager = new Manager(games);
        int nbGames = manager.getNbGames();
        String totalWinrate = displayService.printWinrate(manager.getTotalWinrate());
        GeneralStatsResponse generalStatsResponse = new GeneralStatsResponse(nbGames, totalWinrate);
		return ResponseEntity.ok(generalStatsResponse);
	}
}
