package com.trackwell.vessel.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trackwell.vessel.model.Vessel;

@Repository
public interface VesselPositionRepository extends CrudRepository<Vessel, Long> {
	
	@Query("SELECT v from Vessel v where v.name = ?1 and v.country = ?2")
	public Vessel findByNameAndCountry(String name, String country);
}
