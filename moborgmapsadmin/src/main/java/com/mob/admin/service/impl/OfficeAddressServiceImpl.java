package com.mob.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mob.admin.model.OfficeAddress;
import com.mob.admin.repository.OfficeAddressRepository;
import com.mob.admin.service.OfficeAddressService;

@Service
public class OfficeAddressServiceImpl implements OfficeAddressService {

	@Autowired
	private OfficeAddressRepository officeAddressRepo;

	@Transactional
	@Override
	public List<OfficeAddress> getofficeName() {
		List<OfficeAddress> officeList = officeAddressRepo.getOfficeName();
		return officeList;
	}

	@Transactional
	@Override
	public OfficeAddress getofficeAddress(long userId) {
		OfficeAddress officeName = officeAddressRepo.getofficeAddress(userId);
		return officeName;
	}

	@Override
	@Transactional
	public List<OfficeAddress> getAllOfficeLocations() {
		return officeAddressRepo.findAll();
	}

	@Override
	@Transactional
	public void updateOfficeAddress(OfficeAddress officeAddress) {
		officeAddressRepo.save(officeAddress);
	}
	
	@Override
	@Transactional
	public void deleteOfficeLocation(OfficeAddress officeAddress) {
		officeAddressRepo.delete(officeAddress);
	}

	@Transactional
	@Override
	public void addOfficeAddress(OfficeAddress officeAddress) {
		officeAddressRepo.save(officeAddress);
		
	}
	
	@Transactional
	@Override
	public OfficeAddress getOfficeAddressById(Long officeAddressId) {
		OfficeAddress officeAddress = officeAddressRepo.getOfficeAddressById(officeAddressId);
		return officeAddress;
				
	}

}
