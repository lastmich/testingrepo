package com.trackwell.vessel.model.dto;

import com.trackwell.vessel.model.Vessel;

public class VesselDto {
	private String name;
	private String country;
	public VesselDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VesselDto(String name, String country) {
		super();
		this.name = name;
		this.country = country;
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
	
	public static VesselDto fromEntity(Vessel v) {
		VesselDto dto = new VesselDto();
		if(v != null) {
			dto.setName(v.getName());
			dto.setCountry(v.getCountry());
		}
		return dto;
	}

}
