package com.mob.admin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mob.admin.model.OfficeAddress;
import com.mob.admin.service.OfficeAddressService;

@Controller
public class OfficeController {

	@Autowired
	private OfficeAddressService officeAddressService;

	@RequestMapping(value = "/officelocations", method = RequestMethod.GET)
	public String loadOfficeLocations(Map<String, Object> model) {
		try {
			model.put("officeList",
					officeAddressService.getAllOfficeLocations());
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error", "Something went wrong please try after sometime");
			return "error";
		}
		return "viewofficelocations";
	}

	@RequestMapping(value = "/editOfficeLocations", method = RequestMethod.POST)
	public String editOfficeLocations(Map<String, Object> model,
			@RequestParam("officeID") String officeAddressId,
			@RequestParam("officeName") String officeName,
			@RequestParam("addressLine1") String addressLine1,
			@RequestParam("addressLine2") String addressLine2,
			@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("country") String country,
			@RequestParam("zipcode") String zipCode,
			@RequestParam("officeContactNo") String officeContactNo) {

		OfficeAddress address = new OfficeAddress();
		address.setOfficeAddressId(Long.parseLong(officeAddressId));
		address.setOfficeName(officeName);
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setLatitude(Double.parseDouble(latitude));
		address.setLongitude(Double.parseDouble(longitude));
		address.setCity(city);
		address.setState(state);
		address.setCountry(country);
		address.setZipCode(zipCode);
		address.setOfficeContactNo(officeContactNo);

		officeAddressService.updateOfficeAddress(address);
		try {
			model.put("officeList",
					officeAddressService.getAllOfficeLocations());
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error", "Something went wrong please try after sometime");
			return "error";
		}
		return "viewofficelocations";
	}

	@RequestMapping(value = "/addOfficeLocation", method = RequestMethod.POST)
	public String addOfficeLocation(Map<String, Object> model,
			@RequestParam("officeName") String officeName,
			@RequestParam("addressLine1") String addressLine1,
			@RequestParam("addressLine2") String addressLine2,
			@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("country") String country,
			@RequestParam("zipcode") String zipCode,
			@RequestParam("officeContactNo") String officeContactNo) {

		OfficeAddress address = new OfficeAddress();
		address.setOfficeName(officeName);
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setLatitude(Double.parseDouble(latitude));
		address.setLongitude(Double.parseDouble(longitude));
		address.setCity(city);
		address.setState(state);
		address.setCountry(country);
		address.setZipCode(zipCode);
		address.setOfficeContactNo(officeContactNo);
		officeAddressService.addOfficeAddress(address);
		try {
			model.put("officeList",
					officeAddressService.getAllOfficeLocations());
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error", "Something went wrong please try after sometime");
			return "error";
		}
		return "viewofficelocations";
	}

	@RequestMapping(value = "/deleteOfficeLocation", method = RequestMethod.POST)
	public void deleteAjaxOfficeLocation(
			@RequestParam("officeId") String officeAddressId,
			HttpServletResponse response) throws IOException {
		try {

			OfficeAddress address = new OfficeAddress();
			address.setOfficeAddressId(Long.parseLong(officeAddressId));
			officeAddressService.deleteOfficeLocation(address);

			String success = "Deleted";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(success);
		} catch (Exception e) {
			String success = "Error";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(success);
		}
	}
}
