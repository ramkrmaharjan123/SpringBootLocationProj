package com.kcing.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcing.location.entities.Location;
import com.kcing.location.repos.LocationRepository;
import com.kcing.location.service.interfaces.LocationService;
import com.kcing.location.util.EmailUtil;
import com.kcing.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	private LocationService service; 
	
	@Autowired
	private LocationRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext sc;
	@Autowired
	private EmailUtil emailUtil;
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		Location saveLocation = service.saveLocation(location);
		String msg = "successfully created:"+saveLocation.getId();
		modelMap.addAttribute("msg", msg);
		
		emailUtil.sendEmail("User Created", "rkman.maharjan@gmail.com", "Test123");
		
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
	@RequestMapping("/updateLocation")
	public String showUpdate(@RequestParam("id") long id,ModelMap modelMap) {
		Location l = service.findLocation(id);
		modelMap.addAttribute("location", l);
		return "updateLocation";
	}	
	
	@RequestMapping("/editLocation")
	public String editLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		 service.updateLocation(location);
		List<Location> allLocations = service.findAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
}
