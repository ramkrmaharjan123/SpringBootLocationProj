package com.kcing.location.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcing.location.entities.Location;
import com.kcing.location.repos.LocationRepository;
import com.kcing.location.service.interfaces.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepository.delete(location);
	}

	@Override
	public Location findLocation(Long id) {
		Optional<Location> l = locationRepository.findById(id);
		if(l.isPresent()) {
			return l.get();
		}
		
//		 return locationRepository.getOne(id);
		return null;
	}

	@Override
	public List<Location> findAllLocations() {
		return locationRepository.findAll();
	}

	public LocationRepository getLocationRepository() {
		return locationRepository;
	}

	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

}
