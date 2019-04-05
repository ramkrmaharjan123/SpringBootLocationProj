package com.kcing.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcing.location.entities.Location;
import com.kcing.location.service.interfaces.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationRestController {
	
	@Autowired
	private LocationService locationService;

	@GetMapping
	public List<Location> getAllLocation() {
		
		return locationService.findAllLocations();
	}
	
	@PostMapping
	public Location saveLocation(@RequestBody Location location) {
		return locationService.saveLocation(location);
		
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationService.saveLocation(location);
	}
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") long id) {
		
		Location loc =new Location();
		loc.setId(id);
		locationService.deleteLocation(loc);
	}
	
	@GetMapping("/{id}")
	public Location findLocationById(@PathVariable("id") long id) {
		System.out.println("ID is: "+id);
		Location loc = locationService.findLocation(id);
		return loc;
	}
	
	
}
