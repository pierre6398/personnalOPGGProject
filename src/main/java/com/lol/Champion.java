package com.lol;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Champion {
	@Column(name="name", nullable=false)
	private String name;
	
	public Champion() {
		
	}
	
	 public Champion(String name){
	        this.name = name;
	    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Champion other = (Champion) obj;
		return Objects.equals(name, other.name);
	}    
}
