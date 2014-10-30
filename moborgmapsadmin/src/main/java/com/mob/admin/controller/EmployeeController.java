package com.mob.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mob.admin.model.OfficeAddress;
import com.mob.admin.model.Title;
import com.mob.admin.model.User;
import com.mob.admin.service.OfficeAddressService;
import com.mob.admin.service.TitleService;
import com.mob.admin.service.UserService;

@Controller
public class EmployeeController {

	@Autowired
	private UserService userService;
	@Autowired
	private TitleService titleService;
	@Autowired
	private OfficeAddressService officeAddressService;

	
	List<Long> searchquerydetails=null;
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String loadIndex(Map<String, Object> model) {
		
		Long hiddenUserId=searchquerydetails.get(0);
		Long hiddenTitleId=searchquerydetails.get(1);
		Long hiddenOfficeId=searchquerydetails.get(2);
		
		
		List<User> tryList = null;
		User username = null;
		Title titlename = null;
		OfficeAddress officeName = null;
		
		List<String> titleNames= new ArrayList<String>();
		List<String> officeLocationNames= new ArrayList<String>();
		List<String> resourceManagerNames= new ArrayList<String>();
		
		List<Title> titleList= titleService.getAllTitle();
		List<OfficeAddress> officeLocationList = officeAddressService.getofficeName();
		List<User> managerList = userService.getAllResourceManager();
		
		if(hiddenUserId != null)
		{
			username=userService.getUserById(hiddenUserId);
		}
		if (hiddenTitleId != null) {
			titlename=titleService.getTitleById(hiddenTitleId);
		}
		if (hiddenOfficeId != null) {
			officeName=officeAddressService.getOfficeAddressById(hiddenOfficeId);
		}
		
		//User username=userService.getUserById(hiddenUserId);
		//Title titlename=titleService.getTitleById(hiddenTitleId);
        //OfficeAddress officeName=officeAddressService.getofficeAddress(hiddenOfficeId);
        
		if (titlename == null && officeName == null) {
        	tryList = userService.getAllUserWithoutTitleOfficeName(username.getFullName());
		}
        else if (username == null && officeName == null) {
        	tryList = userService.getAllUserWithoutEmpOfficeName( titlename.getTitleName());
		}
        else if (username == null && titlename == null) {
        	tryList = userService.getAllUserWithoutEmpTitleName(officeName.getAddressLine1());
		}
        else if(username == null){
        	tryList = userService.getAllUserBasedOnCriteriaWithoutEmpName(titlename.getTitleName(), officeName.getAddressLine1());
        }
        else if (titlename == null) {
        	tryList = userService.getAllUserBasedOnCriteriaWithoutTitleName(username.getFullName(),officeName.getAddressLine1());
		}
        else if (officeName == null) {
        	tryList = userService.getAllUserBasedOnCriteriaWithoutOfficeName(username.getFullName(), titlename.getTitleName());
		}
		else if (username != null && titlename != null && officeName != null) {
			tryList = userService.getAllUserBasedOnCriteria(username.getFullName(), titlename.getTitleName(), officeName.getAddressLine1());
		}
        else {
        	tryList = userService.getAllUserBasedOnCriteria(username.getFullName(), titlename.getTitleName(), officeName.getAddressLine1());
		}
        
		//System.out.println(username.getFullName()+titlename.getTitleName()+ officeName.getAddressLine1()+"mnjkdbvjhbdvhbad");
       // List<User> tryList = userService.getAllUserBasedOnCriteria(username.getFullName(), titlename.getTitleName(), officeName.getAddressLine1());
		//List<User> tryList = userService.getAllUserBasedOnCriteria("Nehal Khandelwal","Java Developer","Ahmedabad, India");
		User user = new User();
		//int i=0;
		model.put("userEntity", user);

		/*List<User> employeeList = userService.getListOfUser();
		model.put("employeeNameList", employeeList);
		for (User user2 : employeeList) {
		   titleNames.add(user2.getTitleId().getTitleName());
		   officeLocationNames.add(user2.getOfficeLocationId().getAddressLine1());
		   resourceManagerNames.add((userService.getManager(user2.getResourceManagerId())).getFullName());
		   i++;
		}*/
		
		//List<User> employeeList = userService.getListOfUser();
		model.put("employeeNameList", tryList);
		for (User user2 : tryList) {
		   titleNames.add(user2.getTitleId().getTitleName());
		   officeLocationNames.add(user2.getOfficeLocationId().getAddressLine1());
		   resourceManagerNames.add((userService.getManager(user2.getResourceManagerId())).getFullName());
		   //i++;
		}
		
		model.put("titleNameList", titleNames);
		model.put("officeLocationNamesList", officeLocationNames);
		model.put("resourceManagerNamesList", resourceManagerNames);
		
		model.put("titleList", titleList);
		model.put("officeLocationList", officeLocationList);
		model.put("managerList", managerList);
		
		return "employeelist";
	}

	@RequestMapping(value = "/activetoggle", method = RequestMethod.GET)
	public String SurveyAjaxToggle(HttpServletResponse response,
			@RequestParam String userId, @RequestParam String status,
			HttpServletRequest request, HttpSession session) throws IOException {

		System.out.println("called" + userId + status);
		long userID = Long.valueOf(userId);
		boolean setStatus;
		if (status.equals("active")) {
			setStatus = true;
		} else {
			setStatus = false;
		}
		userService.setUserActiveInactive(setStatus, userID);
		User user = userService.getUserById(userID);

		System.out.println(user.isResourceManager());
		System.out.println(user.getFullName());
		if (user.isActive()) {
			userService.setUserActiveInactive(setStatus, userID);
			request.setAttribute("IsResourceManager", user.isResourceManager());
			System.out.println(user.isResourceManager());
			session.setAttribute("IsResourceManager", user.isResourceManager());
		} else {
			userService.setUserActiveInactive(setStatus, userID);
		}

		return "employeelist";
	}
	
	@RequestMapping(value = "/editEmployeeDetails", method = RequestMethod.POST)
	public String editOfficeLocations(Map<String, Object> model,
			@RequestParam("userID") String userId,
			@RequestParam("emailId") String emailId,
			@RequestParam("fullName") String fullName,
			@RequestParam("titleName") String title,
			@RequestParam("officeLocation") String officeLocation,
			@RequestParam("resourceManager") String resourceManager,
			@RequestParam("contactNumber") String contactNumber,
			@RequestParam("officeContactNumber") String officeContactNumber){

		User userVerified = userService.getUserByEmailId(emailId);
		Title title2 = titleService.getTitleByName(title);
		OfficeAddress address = userService.getOfficeAddressId(officeLocation);
		User manager = userService.getUserId(resourceManager);

		userVerified.setEmailId(emailId);
		userVerified.setFullName(fullName);
		userVerified.setTitleId(title2);
		userVerified.setResourceManagerId(manager.getUserId());
		userVerified.setOfficeLocationId(address);
		userVerified.setContactNo(contactNumber);
		userVerified.setOfficeContactNo(officeContactNumber);

		officeAddressService.updateOfficeAddress(address);
		userService.saveUser(userVerified);
		try {
			model.put("userList", userService.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error", "Something went wrong please try after sometime");
			return "error";
		}
		return "redirect:/employee";
	}
	
	@RequestMapping(value = "/searchemployee", method = RequestMethod.GET)
	public String search(Map<String, Object> model){
		return "search";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchControllerDesignation", method = RequestMethod.GET)
	public void jsonresponsedesignation(HttpServletResponse response,
			Map<String, Object> model, Map<Integer, String> mapId,
			HttpServletRequest request, @RequestParam("term") String term,
			HttpSession session) {
		System.out.println("Inside the title bar");
		List<Title> names = titleService.getAllTitle();
		List<String> full = new ArrayList<String>();
		JSONObject jObject = new JSONObject();
		try {
			JSONArray jArray = new JSONArray();
			for (Title title : names) {
				full.add(title.getTitleName());
				JSONObject nameJson = new JSONObject();
				
				if (title.getTitleName().toLowerCase()
						.contains(term.toLowerCase())) {
					System.out.println("inside condition for term");
					nameJson.put("label", title.getTitleName());
					nameJson.put("value", title.getTitleId());
					jArray.add(nameJson);
				}
			}

			jObject.put("nameListTitle", jArray);
			response.setContentType("text/json");
			response.getWriter().write(jObject.toString());
			System.out.println(jObject + " for search ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchControllerEmployee", method = RequestMethod.GET)
	public void jsonresponseemployee(HttpServletResponse response,
			Map<String, Object> model, Map<Integer, String> mapId,
			HttpServletRequest request, @RequestParam("term") String term,
			HttpSession session) {
		System.out.println("Inside the orgsearch bar");
		List<User> names = userService.getAllUsers();
		List<String> full = new ArrayList<String>();
		JSONObject jObject = new JSONObject();
		try {
			JSONArray jArray = new JSONArray();
			for (User user : names) {
				full.add(user.getFullName());
				JSONObject nameJson = new JSONObject();
				System.out.println(term + " user name" + user.getFullName());
				if (user.getFullName().toLowerCase()
						.contains(term.toLowerCase())) {
					System.out.println("inside condition for term");
					nameJson.put("label", user.getFullName());
					nameJson.put("value", user.getUserId());
					jArray.add(nameJson);
				}
			}

			jObject.put("nameList", jArray);
			response.setContentType("text/json");
			response.getWriter().write(jObject.toString());
			System.out.println(jObject + " for search ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchControllerOfficeLocation", method = RequestMethod.GET)
	public void jsonresponseoffice(HttpServletResponse response,
			Map<String, Object> model, Map<Integer, String> mapId,
			HttpServletRequest request, @RequestParam("term") String term,
			HttpSession session) {
		System.out.println("Inside the title bar");
		List<OfficeAddress> names = officeAddressService.getAllOfficeLocations();
		List<String> full = new ArrayList<String>();
		JSONObject jObject = new JSONObject();
		try {
			JSONArray jArray = new JSONArray();
			for (OfficeAddress office : names) {
				full.add(office.getAddressLine1());
				JSONObject nameJson = new JSONObject();
				
				if (office.getAddressLine1().toLowerCase()
						.contains(term.toLowerCase())) {
					System.out.println("inside condition for term");
					nameJson.put("label", office.getAddressLine1());
					nameJson.put("value", office.getOfficeAddressId());
					jArray.add(nameJson);
				}
			}

			jObject.put("nameListOffice", jArray);
			response.setContentType("text/json");
			response.getWriter().write(jObject.toString());
			System.out.println(jObject + " for search ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping(value="/search")
	String display(){
		return "search";
	}
	
	@RequestMapping(value="/searchcontroller",method=RequestMethod.GET)
	public String getHiddenFeilds(@RequestParam("hiddenemployeeid") Long hiddenemployeename,@RequestParam("hiddentitleid") Long hiddentitlename,
			@RequestParam("hiddenofficeid") Long hiddenofficename, Map<String, Object> model){
		
		searchquerydetails = new ArrayList<Long>();
		searchquerydetails.add(hiddenemployeename);
		searchquerydetails.add(hiddentitlename);
		searchquerydetails.add(hiddenofficename);
		
		System.out.println("<><><><><><><><><><><><><><>"+hiddenofficename);
		
		return "redirect:/employee";
		
	}
}
