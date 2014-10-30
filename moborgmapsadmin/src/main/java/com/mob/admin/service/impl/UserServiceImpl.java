package com.mob.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mob.admin.model.OfficeAddress;
import com.mob.admin.model.Title;
import com.mob.admin.model.User;
import com.mob.admin.repository.UserRepository;
import com.mob.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public void saveUser(User user) {
		userRepository.save((User) user);
	}

	@Transactional
	@Override
	public User getUserByEmailId(String emailId) {
		User user = userRepository.getUserByEmailId(emailId);
		return user;
	}

	@Transactional
	@Override
	public OfficeAddress getOfficeAddressId(String addressLine1) {
		OfficeAddress officeAddress = userRepository.getOfficeAddressId(addressLine1);
		return officeAddress;
	}

	@Transactional
	@Override
	public Title getTitleId(String titleId) {
		Title title = userRepository.getTitleId(titleId);
		return title;
	}

	@Transactional
	@Override
	public User getResourceManager(String fullName) {
		User user = userRepository.getResourceManager(fullName);
		return user;
	}

	@Transactional
	@Override
	public boolean isUserAvailable(User user) {
		User userData = userRepository.isUserAvail(user.getEmailId());
		boolean flag = false;
		if (userData != null) {
			return true;
		} else {
			return flag;
		}
	}

	@Transactional
	@Override
	public List<User> getAllResourceManager() {
		List<User> managerList = userRepository.getAllResourceManager();
		return managerList;
	}
	
	@Transactional
	@Override
	public User getUserById(long userId) {
		User user = userRepository.findOne(userId);
		return user;
	}

	@Transactional
	@Override
	public User loadLocation(User user) {
		User userObj = userRepository.loadOfficeLocation(user.getEmailId());
		return userObj;
	}

	@Transactional
	@Override
	public List<User> getSubRelationship(Long userId) {
		List<User> users = userRepository.getSubRelationship(userId);
		return users;
	}

	@Transactional
	@Override
	public User getResourceManagerByUserId(Long resourceManagerId) {
		User resourceManager = userRepository.getResourceManagerByUserId(resourceManagerId);
		return resourceManager;
	}

	@Transactional
	@Override
	public User getCEO() {
		User user = userRepository.getCEO();
		return user;
	}

	@Transactional
	@Override
	public List<User> getListOfUser() {
		List<User> listOfUsers = userRepository.findAll();
		return listOfUsers;
	}

	@Transactional
	@Override
	public List<User> getUserInCurrentBounds(Double nelat, Double swlng,
			Double swlat, Double nelng) {
		System.out.println("$$$$$$$$$$$$$$$$$ "+ nelat + swlng + swlat + nelng);
		List<User> usersInRange = userRepository.getUserInCurrentBounds(nelat, swlng, swlat, nelng);
		return usersInRange;
	}

	@Transactional
	@Override
	public List<User> getHardCodedUsers() {
		List<User> usersInRange = userRepository.getHardCodedUsers();
		return usersInRange;
	}
	@Transactional
	@Override
	public Title getCurrentTitle(long userId) {
		Title currenTitle=userRepository.getCurrentTitle(userId);
		return currenTitle;
	}


	@Transactional
	@Override
	public User getManager(Long resourceManagerId) {
		User manager=userRepository.getManager(resourceManagerId);
		return manager;
	}

	@Transactional
	@Override
	public List<User> getAllUsers() {
		List<User> names=
		userRepository.findAll();
		return names;
	}
	@Transactional
	@Override
	public User getUserId(String fullName) {

		User user = userRepository.getUserId(fullName);
		return user;
	}

	@Transactional
	@Override
	public boolean updateLocation(Double latitude, Double longitude,User user) {
		userRepository.updatelocation(latitude,longitude,user.getUserId());
		return false;
	}

	@Transactional
	public void setUserActiveInactive(boolean isActive, long userId) {
		
		userRepository.setUserActiveInactive(isActive, userId);
		
	}

	@Transactional
	@Override
	public List<User> getAllUserBasedOnCriteria(String fullName,
			String titleName, String addressLine1) {
		
		List<User> listOfUsers = userRepository.getAllUserBasedOnCriteria(fullName, titleName, addressLine1);
		return listOfUsers;
	}

	@Transactional
	@Override
	public List<User> getAllUserBasedOnCriteriaWithoutEmpName(String titleName,
			String addressLine1) {
		System.out.println("LEL");
		List<User> listOfUsers = userRepository.getAllUserBasedOnCriteriaWithoutEmpName(titleName, addressLine1);
		for (User user : listOfUsers) {
		System.out.println(user.getFullName()+user.getOfficeLocationId().getAddressLine1());
		}
		return listOfUsers;
	}

	@Transactional
	@Override
	public List<User> getAllUserBasedOnCriteriaWithoutTitleName(
			String fullName, String addressLine1) {
		List<User> listOfUsers = userRepository.getAllUserBasedOnCriteriaWithoutTitleName(fullName, addressLine1);
		return listOfUsers;
	}

	@Transactional
	@Override
	public List<User> getAllUserBasedOnCriteriaWithoutOfficeName(
			String fullName, String titleName) {
		List<User> listOfUsers = userRepository.getAllUserBasedOnCriteriaWithoutOfficeName(fullName, titleName);
		return listOfUsers;
	}

	@Transactional
	@Override
	public List<User> getAllUserWithoutTitleOfficeName(String fullName) {
		List<User> listOfUsers = userRepository.getAllUserWithoutTitleOfficeName(fullName);
		return listOfUsers;
	}

	@Transactional
	@Override
	public List<User> getAllUserWithoutEmpOfficeName(String titleName) {
		List<User> listOfUsers = userRepository.getAllUserWithoutEmpOfficeName(titleName);
		return listOfUsers;
	}

	@Transactional
	@Override
	public List<User> getAllUserWithoutEmpTitleName(String addressLine1) {
		System.out.println("++++++++++++++"+addressLine1);
		List<User> listOfUsers = userRepository.getAllUserWithoutEmpTitleName(addressLine1);
		
		for (User user : listOfUsers) {
			System.out.println("-----------------"+user.getOfficeLocationId().getAddressLine1());
		}
		return listOfUsers;
	}
}
