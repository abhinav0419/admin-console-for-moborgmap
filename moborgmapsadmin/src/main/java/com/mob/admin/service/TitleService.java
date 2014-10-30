package com.mob.admin.service;

import java.util.List;

import com.mob.admin.model.Title;

public interface TitleService {

	public List<Title> getTitleName();

	public List<Title> getAllTitle();
	
	public Title getTitleByName(String titleName);
	
	public void updateTitle(Title title);

	public void deleteTitle(Title title);

	public void addTitle(Title title) throws Exception;
	
	public Title getTitleById(Long titleId);
	

}
