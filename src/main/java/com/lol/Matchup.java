package com.lol;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Matchups")
public class Matchup extends Champion{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 public Matchup() {
	        super();
	    }
	
	public Matchup(String name) {
		super(name);
	}
}
