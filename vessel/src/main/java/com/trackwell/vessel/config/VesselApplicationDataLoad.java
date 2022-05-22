package com.trackwell.vessel.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trackwell.vessel.model.Position;
import com.trackwell.vessel.model.Vessel;
import com.trackwell.vessel.repository.VesselPositionRepository;

@Configuration
public class VesselApplicationDataLoad {
	private static final Logger logger = LoggerFactory.getLogger(VesselApplicationDataLoad.class);
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
	@Bean
	CommandLineRunner initDatabase(VesselPositionRepository vesselPositionRepository) {
		return args -> {
			logger.info("Start loading data...");
			
			Vessel v1 = new Vessel("Nabucodonosor", "IRQ");
			Position p1 = new Position(df.parse("10-01-2022"), 110.1, 210.1, 10);
			v1.setPosition(p1);
			logger.info(v1.toString());
			vesselPositionRepository.save(v1);
			p1.setVessel(v1);
			
			Vessel v2 = new Vessel("Amerigo Vespucci", "ITA");
			Position p2 = new Position(df.parse("10-03-2022"), 112.1, 212.1, 20);
			v2.setPosition(p2);
			logger.info(v2.toString());
			vesselPositionRepository.save(v2);
			p2.setVessel(v2);
					
			Vessel v3 = new Vessel("The Mayflower", "USA");
			Position p3 = new Position(df.parse("10-05-2022"), 113.1, 213.1, 30);
			v3.setPosition(p3);
			logger.info(v3.toString());
			vesselPositionRepository.save(v3);
			p3.setVessel(v3);
			
			logger.info("...end loading data.");
		};
	}
	
	
}
