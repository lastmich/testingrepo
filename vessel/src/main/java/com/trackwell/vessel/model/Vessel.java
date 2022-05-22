package com.trackwell.vessel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.trackwell.vessel.model.dto.VesselDto;
import com.trackwell.vessel.model.dto.VesselPositionDto;

import net.bytebuddy.description.type.TypeDefinition.SuperClassIterator;

@Entity
public class Vessel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String country;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vessel")
	private Position position;

	public Vessel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vessel(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	
	public Vessel(VesselDto dto) {
		super();
		this.name = dto.getName();
		this.country = dto.getCountry();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Vessel [id=" + id + ", name=" + name + ", country=" + country + ", position=" + position + "]";
	}
	
	public static Vessel fromDTO(VesselPositionDto dto) {
		Vessel v = new Vessel(dto.getVessel());
		Position p = new Position(dto.getPosition());
		v.setPosition(p);
		return v;
	}
}
