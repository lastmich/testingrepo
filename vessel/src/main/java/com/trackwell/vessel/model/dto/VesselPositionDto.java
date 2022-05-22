package com.trackwell.vessel.model.dto;

import com.trackwell.vessel.model.Vessel;

public class VesselPositionDto {
	private VesselDto vessel;
	private PositionDto position;
	public VesselPositionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VesselPositionDto(VesselDto vessel, PositionDto position) {
		super();
		this.vessel = vessel;
		this.position = position;
	}
	public VesselDto getVessel() {
		return vessel;
	}
	public void setVessel(VesselDto vessel) {
		this.vessel = vessel;
	}
	public PositionDto getPosition() {
		return position;
	}
	public void setPosition(PositionDto position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "VesselPositionDto [vessel=" + vessel + ", position=" + position + "]";
	}
	
	public static VesselPositionDto fromEntity(Vessel v) {
		VesselPositionDto dto = new VesselPositionDto();
		if(v != null) {
			dto.setVessel(VesselDto.fromEntity(v));
			dto.setPosition(PositionDto.fromEntity(v.getPosition()));
		}
		
		return dto;
	}
	
	public static VesselPositionDto fromEntityForOutput(Vessel v) {
		VesselPositionDto dto = new VesselPositionDto();
		if(v != null) {
			dto.setVessel(VesselDto.fromEntity(v));
			dto.setPosition(PositionDto.fromEntityForOutput(v.getPosition()));
		}
		return dto;
	}
}
