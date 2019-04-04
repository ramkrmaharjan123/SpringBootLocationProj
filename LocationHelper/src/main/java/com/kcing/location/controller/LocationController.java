package com.kcing.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcing.location.entities.Location;
import com.kcing.location.service.interfaces.LocationService;

@Controller
public class LocationController {

	@Autowired
	private LocationService service;
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		Location saveLocation = service.saveLocation(location);
		String msg = "successfully created:"+saveLocation.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> allLocations = service.findAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") long id,ModelMap modelMap) {
		Location l = service.findLocation(id);
		service.deleteLocation(l);
		List<Location> allLocations = service.findAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}	
	
}
