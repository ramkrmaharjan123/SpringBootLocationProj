package com.kcing.location.service.interfaces;

import java.util.List;

import com.kcing.location.entities.Location;

public interface LocationService {

	public Location saveLocation(Location location);
	public Location updateLocation(Location location);
	public void deleteLocation(Location location);
	public Location findLocation(Long id);
	public List<Location> findAllLocations();
}
