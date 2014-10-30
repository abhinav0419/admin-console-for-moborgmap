package com.mob.admin.service;

import com.mob.admin.model.LocationLogs;
import com.mob.admin.model.User;

public interface LocationLogsService {

	public void saveUserLocation(LocationLogs locationLogs);
	
	public LocationLogs geLocationLogs(User userId);
}
