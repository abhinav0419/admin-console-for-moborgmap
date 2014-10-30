package com.mob.admin.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mob.admin.model.OfficeAddress;
import com.mob.admin.model.Title;
import com.mob.admin.model.User;

public interface UserService {

	public void saveUser(User user);

	public List<User> getAllResourceManager();

	public User getUserById(long userId);

	public User getUserByEmailId(String emailId);

	public OfficeAddress getOfficeAddressId(String officeAddressId);

	public Title getTitleId(String titleId);

	public User getResourceManager(String fullName);

	public boolean isUserAvailable(User user);
	public boolean updateLocation(Double latitude, Double longitude,User user);


	List<User> getSubRelationship(Long userId);

//	public List<User> getSubRelationship(Long userId);



	User getResourceManagerByUserId(Long resourceManagerId);

    User getCEO();

//	public User getResourceManagerByUserId(Long resourceManagerId,
//			String emailId);

//	public User getCEO();


	public User loadLocation(User user);
	
	public List<User> getListOfUser();
	

	List<User> getUserInCurrentBounds(Double nelat, Double swlng, Double swlat, Double nelng);
	
	List<User> getHardCodedUsers();

	public Title getCurrentTitle(long userId);

	public User getManager(Long resourceManagerId);

	public List<User> getAllUsers();


	public User getUserId(String fullName);
	
	public void setUserActiveInactive(boolean isActive, long userId);
	
	List<User> getAllUserBasedOnCriteria(String fullName,String titleName,String addressLine1);
	
	List<User> getAllUserBasedOnCriteriaWithoutEmpName(String titleName,String addressLine1);
	
	List<User> getAllUserBasedOnCriteriaWithoutTitleName(String fullName,String addressLine1);
	
	List<User> getAllUserBasedOnCriteriaWithoutOfficeName(String fullName,String titleName);
	
	List<User> getAllUserWithoutTitleOfficeName(String fullName);
	
	List<User> getAllUserWithoutEmpOfficeName(String titleName);
	
	List<User> getAllUserWithoutEmpTitleName(String addressLine1);
}

