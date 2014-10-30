package com.mob.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mob.admin.model.LocationLogs;
import com.mob.admin.model.User;
import com.mob.admin.repository.LocationLogsRepository;
import com.mob.admin.service.LocationLogsService;

@Service
public class LocationLogsServiceImpl implements LocationLogsService {

	@Autowired
	private LocationLogsRepository locationLogsRepo;

	@Override
	public void saveUserLocation(LocationLogs locationLogs) {
		locationLogsRepo.save(locationLogs);
	}

	@Transactional
	public LocationLogs geLocationLogs(User userId) {
		
		LocationLogs locationLogs = locationLogsRepo.getLocationLogs(userId);
		
		return locationLogs;
	}
}
