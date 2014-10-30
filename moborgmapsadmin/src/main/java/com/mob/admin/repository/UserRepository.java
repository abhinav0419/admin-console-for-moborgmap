package com.mob.admin.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mob.admin.api.jpa.MobJpaRepository;
import com.mob.admin.model.OfficeAddress;
import com.mob.admin.model.Title;
import com.mob.admin.model.User;

@MappedSuperclass
public interface UserRepository extends MobJpaRepository<User, Long> {

	@Query("select us from User us where us.emailId = :emailId")
	User getUserByEmailId(@Param("emailId") String emailId);

	@Query("select officeadd from OfficeAddress officeadd where officeadd.addressLine1 = :addressLine1")
	OfficeAddress getOfficeAddressId(@Param("addressLine1") String addressLine1);

	@Query("select title from Title title where title.titleName = :titleName order by title.titleName")
	Title getTitleId(@Param("titleName") String titleName);

	@Query("select user from User user where user.fullName = :fullName order by user.fullName")
	User getResourceManager(@Param("fullName") String fullName);

	@Query("select mn from User mn where mn.isResourceManager=true")
	List<User> getAllResourceManager();

	@Query("select us.titleId from User us where us.userId = :userId ")
	Title getCurrentTitle(@Param("userId") long userId);

	@Modifying
	@Transactional
	@Query("update User us set us.latitude = :latitude, us.longitude = :longitude where us.userId = :userId ")
	void updatelocation(@Param("latitude") Double latitude,
			@Param("longitude") Double longitude, @Param("userId") Long userId);

	@Query("select user from User user where user.emailId = :userEmailId")
	User isUserAvail(@Param("userEmailId") String userEmailId);

	@Query("select user from User user" + " where user.emailId = :userEmailId")
	User loadOfficeLocation(@Param("userEmailId") String userEmailId);

	// @Query("select user from User user"
	// + "inner join OfficeAddress office\n"
	// + " where user.emailId = :userEmailId")
	// User loadOfficeLocation(@Param("userEmailId") String userEmailId);

	// @Query("select us from User")
	// List<User> getListOfUser();

	// mob organization chart queries
	@Query("SELECT us FROM User us WHERE us.resourceManagerId = :userId")
	List<User> getSubRelationship(@Param("userId") Long userId);

	// @Query("SELECT us FROM User us WHERE us.resourceManagerId = :resourceManagerId AND us.emailId = :emailId")
	@Query("SELECT us FROM User us WHERE us.userId = :resourceManagerId")
	User getResourceManagerByUserId(
			@Param("resourceManagerId") Long resourceManagerId);

	@Query("SELECT us FROM User us INNER JOIN us.titleId tl WHERE tl.titleName = 'CEO'")
	User getCEO();

	@Query("SELECT us FROM User us WHERE (us.latitude BETWEEN :swlat AND :nelat) AND (us.longitude BETWEEN :swlng AND :nelng) ")
	List<User> getUserInCurrentBounds(@Param("nelat") Double nelat,
			@Param("swlng") Double swlng, @Param("swlat") Double swlat,
			@Param("nelng") Double nelng);

	@Query("SELECT us FROM User us where us.userId =:resourceManagerId ")
	User getManager(@Param("resourceManagerId") Long resourceManagerId);

	@Query("select user from User user where user.fullName = :fullName")
	User getUserId(@Param("fullName") String fullName);

	@Query("SELECT us FROM User us WHERE (us.latitude BETWEEN 7.510134333942949 AND 18.203836354526242) AND (us.longitude BETWEEN 65.89111305000006  AND 83.82080055000006)")
	List<User> getHardCodedUsers();

	@Modifying
	@Query("update User user set user.isActive = :isActive where user.userId = :userId")
	void setUserActiveInactive(@Param("isActive") boolean isActive,
			@Param("userId") long userId);
	
//	@Query("select user from User user WITH user.fullName = :fullName LEFT JOIN user.titleId title WITH title.titleName = :titleName LEFT JOIN user.officeLocationId officeLocation WITH officeLocation.addressLine1 = :addressLine1")
//	List<User> getAllUserBasedOnCriteria(@Param("fullName") String fullName, @Param("titleName") String titleName, @Param("addressLine1") String addressLine1);

	@Query("select user from User user LEFT JOIN user.titleId title LEFT JOIN user.officeLocationId officeLocation WHERE user.fullName = :fullName OR title.titleName = :titleName AND officeLocation.addressLine1 = :addressLine1")
	List<User> getAllUserBasedOnCriteria(@Param("fullName") String fullName, @Param("titleName") String titleName, @Param("addressLine1") String addressLine1);
	
	@Query("select user from User user INNER JOIN user.titleId title INNER JOIN user.officeLocationId officeLocation WHERE title.titleName = :titleName AND officeLocation.addressLine1 = :addressLine1")
	List<User> getAllUserBasedOnCriteriaWithoutEmpName(@Param("titleName") String titleName, @Param("addressLine1") String addressLine1);
	
	@Query("select user from User user LEFT JOIN user.titleId title LEFT JOIN user.officeLocationId officeLocation WHERE user.fullName = :fullName AND officeLocation.addressLine1 = :addressLine1")
	List<User> getAllUserBasedOnCriteriaWithoutTitleName(@Param("fullName") String fullName,@Param("addressLine1") String addressLine1);
	
	@Query("select user from User user LEFT JOIN user.titleId title LEFT JOIN user.officeLocationId officeLocation WHERE user.fullName = :fullName AND title.titleName = :titleName")
	List<User> getAllUserBasedOnCriteriaWithoutOfficeName(@Param("fullName") String fullName, @Param("titleName") String titleName);

	@Query("select user from User user WHERE user.fullName = :fullName")
	List<User> getAllUserWithoutTitleOfficeName(@Param("fullName") String fullName);
	
	@Query("SELECT user FROM User user INNER JOIN user.titleId tl WHERE tl.titleName = :titleName")
	List<User> getAllUserWithoutEmpOfficeName(@Param("titleName") String titleName);
	
	@Query("SELECT user FROM User user INNER JOIN user.officeLocationId officeLocation WHERE officeLocation.addressLine1 = :addressLine1")
	List<User> getAllUserWithoutEmpTitleName(@Param("addressLine1") String addressLine1);
	
}
