package com.trackwell.vessel.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackwell.vessel.model.Vessel;
import com.trackwell.vessel.model.dto.VesselPositionDto;
import com.trackwell.vessel.service.VesselPositionService;

@RestController
@RequestMapping("/")
public class VesselPositionController {

	private final VesselPositionService vesselPositionService;
	
	@Autowired
	public VesselPositionController(VesselPositionService vesselPositionService) {
		this.vesselPositionService = vesselPositionService;
	}
	
	@PostMapping
	@RequestMapping("/insert_vessel_position")
	public ResponseEntity<VesselPositionDto> addVesselPosition(@RequestBody final VesselPositionDto vesselPositionDto) {
		Vessel v = this.vesselPositionService.addVesselPosition(Vessel.fromDTO(vesselPositionDto));
		return new ResponseEntity<VesselPositionDto>(VesselPositionDto.fromEntityForOutput(v), HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping("/get_vessels")
	public ResponseEntity<List<VesselPositionDto>> getAllVessels() {
		List<Vessel> vessels = this.vesselPositionService.getVessels();
		List<VesselPositionDto> vesselsDto = vessels.stream().map(VesselPositionDto::fromEntity).collect(Collectors.toList());
		return new ResponseEntity<List<VesselPositionDto>>(vesselsDto, HttpStatus.OK);
	}
}
