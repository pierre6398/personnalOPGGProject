package com.services;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lol.Matchup;

@Service
public class DisplayService {
	
	public DisplayService() {
		
	}
	
	public String printWinrate(double winrate) {
		DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String formattedWinrate = df.format(winrate);
        String printWinrate = formattedWinrate + " %";
        return printWinrate;
	}
	
	public Map<String, Double> printWinrateAgainst(Map<Matchup, Double> winrateAgainstChamps){
		Map<String, Double> winrateAgainst = new HashMap<String, Double>();
		for (Matchup matchup: winrateAgainstChamps.keySet()) {
			winrateAgainst.put(matchup.getName(),winrateAgainstChamps.get(matchup));
		}
		return winrateAgainst;
	}
}
