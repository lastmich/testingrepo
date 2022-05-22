package com.trackwell.vessel.model.dto;

import java.util.Date;

import com.trackwell.vessel.model.Position;

public class PositionDto {
	private Date date;
	private Date receivedDate;
	private double latitude;
	private double longitude;
	private double speed;
	public PositionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PositionDto(Date date, Date receivedDate, double latitude, double longitude, double speed) {
		super();
		this.date = date;
		this.receivedDate = receivedDate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public static PositionDto fromEntity(Position p) {
		PositionDto dto = new PositionDto();
		if(p != null) {
			dto.setDate(p.getDate());
			dto.setReceivedDate(p.getReceivedDate());
			dto.setLatitude(p.getLatitudeDegrees());
			dto.setLongitude(p.getLongitudeDegrees());
			dto.setSpeed(p.getSpeedKnots());
		}
		return dto;
	}
	
	public static PositionDto fromEntityForOutput(Position p) {
		PositionDto dto = new PositionDto();
		if (p != null) {
			dto.setDate(p.getDate());
			dto.setReceivedDate(p.getReceivedDate());
			dto.setLatitude(Math.toRadians(p.getLatitudeDegrees()));
			dto.setLongitude(Math.toRadians(p.getLongitudeDegrees()));
			dto.setSpeed(0.514444 * p.getSpeedKnots());
		}
		
		return dto;
	}
}
