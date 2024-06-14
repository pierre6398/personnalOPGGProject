package com.restControllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lol.Game;
import com.services.DisplayService;
import com.services.GameStringService;
import com.statistiques.Manager;
import com.statistiques.WinrateChampion;

@RestController
public class KatarinaWinrateRestController {
	
	@Autowired
	private GameStringService gameStringService;
	
	@Autowired
	private DisplayService displayService;
	
	@GetMapping("/Katarina/winrate")
    public ResponseEntity<Double> getKatarinaTotalWinrate() {
        List<Game> games = gameStringService.getGames();
        Manager manager = new Manager(games);
        manager.createStats();
        WinrateChampion winrateChampion = manager.getWinrateChampions().get(0);
        double totalWinrate = winrateChampion.winrateTotal();
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.TEXT_PLAIN);
        return ResponseEntity.ok(totalWinrate);
    }
	
	@GetMapping("/Katarina/winrates")
    public Map<String, Double> getKatarinaWinrates() {
		List<Game> games = gameStringService.getGames();
        Manager manager = new Manager(games);
        manager.createStats();
        WinrateChampion winrateKatarina = manager.getWinrateChampions().get(0);
        Map<String, Double> katarinaWinrates = displayService.printWinrateAgainst(winrateKatarina.getWinrateAgainst());
        return katarinaWinrates;
	}
}
