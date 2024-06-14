package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lol.Pick;

public interface PickRepository extends JpaRepository<Pick, Long>{
	Optional<Pick> findByName(String name);
}
