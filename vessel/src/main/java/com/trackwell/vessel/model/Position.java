package com.trackwell.vessel.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.trackwell.vessel.model.dto.PositionDto;
import com.trackwell.vessel.model.dto.VesselPositionDto;

@Entity
public class Position {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	private Date receivedDate;
	private double latitudeDegrees;
	private double longitudeDegrees;
	private double speedKnots;
	
	@OneToOne
	@JoinColumn(name = "vessel_id")
	private Vessel vessel;
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(Date date, double latitudeDegrees, double longitudeDegrees, double speedKnots) {
		super();
		this.date = date;
		this.receivedDate = new Date();
		this.latitudeDegrees = latitudeDegrees;
		this.longitudeDegrees = longitudeDegrees;
		this.speedKnots = speedKnots;
	}
	public Position(PositionDto dto) {
		super();
		this.date = dto.getDate();
		this.receivedDate = new Date();
		this.latitudeDegrees = dto.getLatitude();
		this.longitudeDegrees = dto.getLongitude();
		this.speedKnots = dto.getSpeed();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public double getLatitudeDegrees() {
		return latitudeDegrees;
	}
	public void setLatitudeDegrees(double latitudeDegrees) {
		this.latitudeDegrees = latitudeDegrees;
	}
	public double getLongitudeDegrees() {
		return longitudeDegrees;
	}
	public void setLongitudeDegrees(double longitudeDegrees) {
		this.longitudeDegrees = longitudeDegrees;
	}
	public double getSpeedKnots() {
		return speedKnots;
	}
	public void setSpeedKnots(double speedKnots) {
		this.speedKnots = speedKnots;
	}
	public Vessel getVessel() {
		return vessel;
	}
	public void setVessel(Vessel vessel) {
		this.vessel = vessel;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", date=" + date + ", receivedDate=" + receivedDate + ", latitudeDegrees="
				+ latitudeDegrees + ", longitudeDegrees=" + longitudeDegrees + ", speedKnots=" + speedKnots
				+ ", vessel=" + vessel + "]";
	}
	
	public static Position fromDTO(VesselPositionDto dto) {
		Position p = new Position(dto.getPosition());
		return p;
	}
}
