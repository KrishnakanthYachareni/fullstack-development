/*
 * Copyright (c) 2020. Krishnakanth Yachareni
 */

package com.kk.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.location.entities.Location;
import com.kk.location.repository.LocationRepository;
import com.kk.location.service.LocationService;
import com.kk.location.utility.EmailUtility;
import com.kk.location.utility.ReportUtility;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private EmailUtility emailUtil;

	@Autowired
	private LocationRepository repository;

	@Autowired
	private ReportUtility reportUtil;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location saveLocation = locationService.saveLocation(location);
		String msg = "Location saved with id: " + saveLocation.getId();
		modelMap.addAttribute("msg", msg);

		/*
		 * emailUtil.sendEmail("yacharenikrishnakanth@gmail.com", "Location is Saved",
		 * "Location saved successfully and about return a response.");
		 */
		// Since the mail passwords are not configured inside application.properties so
		// commenting this snippet. Whoever want to use mail service uncomment here and
		// update the mail credentials in application properties for the same
		// Note: Make sure to enable less secure option at
		// https://myaccount.google.com/lesssecureapps?gar=1s
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
//		Location loc = locationService.getLocationById(id); or
		Location loc = new Location();
		loc.setId(id);
		locationService.deleteLocation(loc);

		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location loc = locationService.getLocationById(id);
		modelMap.addAttribute("location", loc);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.saveLocation(location);

		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {
		List<Object[]> data = repository.findTypeAndTypeCount();
		String path = servletContext.getRealPath("/");
		reportUtil.generatePieChart(path, data);
		return "report";
	}

}
