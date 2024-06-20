package com.restControllers;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
public class WinratesRestController {
	
	@Autowired
	private GameStringService gameStringService;
	
	@Autowired
	private DisplayService displayService;
	
	@GetMapping("/Katarina/winrate")
    public ResponseEntity<Double> getKatarinaTotalWinrate() {
		WinrateChampion winrateKatarina = getWinrateChampion("Katarina");
        double totalWinrateKata = winrateKatarina.winrateTotal();
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.TEXT_PLAIN);
        return ResponseEntity.ok(totalWinrateKata);
    }
	
	@GetMapping("/Katarina/winrates")
    public Map<String, Double> getKatarinaWinrates() {
		WinrateChampion winrateKatarina = getWinrateChampion("Katarina");
        Map<String, Double> katarinaWinrates = displayService.printWinrateAgainst(winrateKatarina.getWinrateAgainst());
        return new TreeMap<>(katarinaWinrates);
	}
	
	@GetMapping("/Zed/winrate")
    public ResponseEntity<Double> getZedTotalWinrate() {
		WinrateChampion winrateZed = getWinrateChampion("Zed");
		double totalWinrateZed = winrateZed.winrateTotal();
        return ResponseEntity.ok(totalWinrateZed);
	}
	
	@GetMapping("/Zed/winrates")
    public Map<String, Double> getZedWinrates() {
		WinrateChampion winrateZed = getWinrateChampion("Zed");
        Map<String, Double> zedWinrates = displayService.printWinrateAgainst(winrateZed.getWinrateAgainst());
        return new TreeMap<>(zedWinrates);
	}
	
	public WinrateChampion getWinrateChampion(String championName) {
		List<Game> games = gameStringService.getGames();
        Manager manager = new Manager(games);
        manager.createStats();
        WinrateChampion winrateChampion = manager.getWinrateChampionByName(championName);
        return winrateChampion;
	}
}