package com.lol;

import com.statistiques.WinrateChampion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Picks")
public class Pick extends Champion{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Transient
	private WinrateChampion winrateChampion;
	
	public Pick() {
		super();
	}
	
	public Pick(String name) {
		super(name);
        this.winrateChampion = new WinrateChampion(name);
	}
	
	public WinrateChampion getWinrateChampion() {
		return winrateChampion;
	}

	public void setWinrateChampion(WinrateChampion winrateChampion) {
		this.winrateChampion = winrateChampion;
	}
}
