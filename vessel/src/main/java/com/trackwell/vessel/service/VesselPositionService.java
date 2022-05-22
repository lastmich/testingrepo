package com.trackwell.vessel.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackwell.vessel.model.Vessel;
import com.trackwell.vessel.repository.VesselPositionRepository;

@Service
public class VesselPositionService {
	private final VesselPositionRepository vesselPositionRepository;
	
	@Autowired
	public VesselPositionService(VesselPositionRepository vesselPositionRepository) {
		this.vesselPositionRepository = vesselPositionRepository;
	}
	
	@Transactional
	public Vessel addVesselPosition(Vessel v) {
		Vessel searchedVessel = this.vesselPositionRepository.findByNameAndCountry(v.getName(), v.getCountry());
		if(searchedVessel == null)
			searchedVessel = v;
		searchedVessel.setPosition(v.getPosition());
		return this.vesselPositionRepository.save(searchedVessel);
	}
	
	public List<Vessel> getVessels() {
		return StreamSupport.stream(this.vesselPositionRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}
