package com.skilldistillery.fightsim.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fighter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Name;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "universe_id")
	private Universe universe;
	
	@ManyToOne
	@JoinColumn(name = "power_bracket_id")
	private PowerBracket powerBracket;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private List<Fight> fights;
	


	public Fighter() {
		super();
	}
	
	public void setFights(List<Fight> fights) {
		this.fights = fights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Fight> getFights() {
		return fights;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public PowerBracket getPowerBracket() {
		return powerBracket;
	}

	public void setPowerBracket(PowerBracket powerBracket) {
		this.powerBracket = powerBracket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fighter other = (Fighter) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Fighter [id=" + id + ", Name=" + Name + "]";
	}
}
