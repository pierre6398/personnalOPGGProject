package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.Game;
import com.lol.GameString;
import com.repositories.GameStringRepository;

 @Service
public class GameStringService {
	 
	 @Autowired
	 private GameStringRepository gameStringRepository;
	
	private List<GameString> gameStrings;
	
	public GameStringService() {
		gameStrings = new ArrayList<GameString>();
	}

	public List<GameString> getGameStrings() {
		return gameStrings;
	}

	public void setGameStrings(List<GameString> gameStrings) {
		this.gameStrings = gameStrings;
	}
	
	public void addGame(GameString gameString) {
		this.gameStrings.add(gameString);
	}

	public void createGameStrings() {
		for (GameString gameString : gameStrings) {
			Optional<GameString> existingGame = gameStringRepository.findById(gameString.getId());
	        if (!existingGame.isPresent()) {
	            gameStringRepository.save(gameString);
	        }
		}
	}
	
	public List<Game> getGames(){
		List<Game> games = new ArrayList<Game>();
		for (GameString gameString: gameStrings) {
			games.add(gameString.createGame());
		}
		return games;
	}
}
