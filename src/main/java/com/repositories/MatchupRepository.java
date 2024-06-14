package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lol.Matchup;

public interface MatchupRepository extends JpaRepository<Matchup, Long>{
	Optional<Matchup> findByName(String name);
}
