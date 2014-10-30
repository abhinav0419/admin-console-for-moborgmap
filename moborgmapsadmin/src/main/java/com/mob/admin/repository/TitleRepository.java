package com.mob.admin.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mob.admin.api.jpa.MobJpaRepository;
import com.mob.admin.model.Title;

@MappedSuperclass
public interface TitleRepository extends MobJpaRepository<Title, Long>{

	@Query("select tn from Title tn")
	List<Title> getTitleName();
	
	@Query("select title from Title title where title.titleName = :titleName")
	Title getTitleByName(@Param("titleName") String titleName);
	
	@Query("select title from Title title where title.titleId = :titleId")
	Title getTitleById(@Param("titleId") Long titleId);

}
