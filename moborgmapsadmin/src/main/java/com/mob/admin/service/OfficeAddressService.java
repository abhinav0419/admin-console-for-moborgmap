package com.mob.admin.service;

import java.util.List;

import com.mob.admin.model.OfficeAddress;

public interface OfficeAddressService {

	public List<OfficeAddress> getofficeName();

	public OfficeAddress getofficeAddress(long userId);
	
	public List<OfficeAddress> getAllOfficeLocations();
	
	public void updateOfficeAddress(OfficeAddress officeAddress);
	
	public void deleteOfficeLocation(OfficeAddress officeAddress);

	public void addOfficeAddress(OfficeAddress officeAddress);
	
	public OfficeAddress getOfficeAddressById(Long officeAddressId);

}
