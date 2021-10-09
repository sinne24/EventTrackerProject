package com.skilldistillery.fightsim.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fight_date")
	private LocalDateTime fightDate;
	
	@Column(name="image_url_one")
	private String imageOne;
	
	@Column(name="image_url_two")
	private String imageTwo;
	
	@Column(name="who_vs_who")
	private String whoVsWho;
	
	@ManyToOne
	@JoinColumn(name = "fighter_one_id")
	private Fighter fighterOne;
	
	@ManyToOne
	@JoinColumn(name = "fighter_two_id")
	private Fighter fighterTwo;
	
	@ManyToOne
	@JoinColumn(name = "who_won_id")
	private Fighter winner;
	
	public Fight() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fighter getFighterOne() {
		return fighterOne;
	}
	public void setFighterOne(Fighter fighterOne) {
		this.fighterOne = fighterOne;
	}
	public Fighter getFighterTwo() {
		return fighterTwo;
	}
	public void setFighterTwo(Fighter fighterTwo) {
		this.fighterTwo = fighterTwo;
	}
	public Fighter getWinner() {
		return winner;
	}
	public void setWinner(Fighter winner) {
		this.winner = winner;
	}
	public String getWhoVsWho() {
		return whoVsWho;
	}
	public void setWhoVsWho(String whoVsWho) {
		this.whoVsWho = whoVsWho;
	}
	public LocalDateTime getFightDate() {
		return fightDate;
	}
	public void setFightDate(LocalDateTime fightDate) {
		this.fightDate = fightDate;
	}
	public String getImageOne() {
		return imageOne;
	}
	public void setImageOne(String imageOne) {
		this.imageOne = imageOne;
	}
	public String getImageTwo() {
		return imageTwo;
	}
	public void setImageTwo(String imageTwo) {
		this.imageTwo = imageTwo;
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
		Fight other = (Fight) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Fight [id=" + id + ", fightDate=" + fightDate + ", imageOne=" + imageOne + ", imageTwo=" + imageTwo
				+ ", whoVsWho=" + whoVsWho + "]";
	}

}
