package com.mob.admin.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mob.admin.api.jpa.MobJpaRepository;
import com.mob.admin.model.OfficeAddress;

@MappedSuperclass
public interface OfficeAddressRepository extends MobJpaRepository<OfficeAddress, Long>{
    
	@Query("select na from OfficeAddress na")
	List<OfficeAddress> getOfficeName();
    
	@Query("select us.officeLocationId from User us where us.userId=:userId")
	OfficeAddress getofficeAddress(@Param("userId") long userId);
	
	@Query("select ofc from OfficeAddress ofc where ofc.officeAddressId = :officeAddressId")
	OfficeAddress getOfficeAddressById(@Param("officeAddressId") Long officeAddressId);
	
	
/*	@Modifying
	@Query("update OfficeAddress address set address.officeName = :officeName where address.officeAddressId = :officeAddressId")
	void updateOfficeAddress(@Param("officeName") String  officeName,
			@Param("officeAddressId") long  officeAddressId);*/

}
