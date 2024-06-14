package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.Pick;
import com.repositories.PickRepository;
import com.exceptions.NotFoundException;

import com.exceptions.ReferenceNullException;

@Service
public class PickService {

		@Autowired
		private PickRepository pickRepository;
		
		public Optional<Pick> getByName(String name){
			if (name == null) {
				throw new ReferenceNullException();
			}
			Optional<Pick> champion = pickRepository.findByName(name);
			if (champion.isEmpty()) {
				throw new NotFoundException("champion " + name + " non trouvé");
			}
			return champion;
		}
		
		public void createPick(Pick champion) {
			Optional<Pick> existingChampion = pickRepository.findByName(champion.getName());
	        if (!existingChampion.isPresent()) {
	            pickRepository.save(champion);
	        }
		}
}
