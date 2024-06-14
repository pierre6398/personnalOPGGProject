package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.Matchup;
import com.repositories.MatchupRepository;
import com.exceptions.NotFoundException;

import com.exceptions.ReferenceNullException;

@Service
public class MatchupService {

		@Autowired
		private MatchupRepository matchupRepository;
		
		public Optional<Matchup> getByName(String name){
			if (name == null) {
				throw new ReferenceNullException();
			}
			Optional<Matchup> matchup = matchupRepository.findByName(name);
			if (matchup.isEmpty()) {
				throw new NotFoundException("champion " + name + " non trouvé");
			}
			return matchup;
		}
		
		public void createMatchup(Matchup matchup) {
			Optional<Matchup> existingMatchup= matchupRepository.findByName(matchup.getName());
	        if (!existingMatchup.isPresent()) {
	            matchupRepository.save(matchup);
	        }
		}
}
