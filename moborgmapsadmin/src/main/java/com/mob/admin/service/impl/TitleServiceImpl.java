package com.mob.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mob.admin.model.Title;
import com.mob.admin.repository.TitleRepository;
import com.mob.admin.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleRepository titleRepo;

	@Transactional
	public List<Title> getTitleName() {
		List<Title> titleName = titleRepo.getTitleName();
		return titleName;
	}

	@Transactional
	@Override
	public List<Title> getAllTitle() {
		return titleRepo.findAll();
	}

	@Override
	@Transactional
	public void updateTitle(Title title) {
		titleRepo.save(title);
	}

	@Override
	@Transactional
	public void deleteTitle(Title title) {
		titleRepo.delete(title);
	}

	@Override
	@Transactional
	public void addTitle(Title title) throws Exception {
		titleRepo.save(title);
	}

	@Transactional
	@Override
	public Title getTitleByName(String titleName) {

		Title title = titleRepo.getTitleByName(titleName);
		return title;
	}

	@Override
	public Title getTitleById(Long titleId) {

		Title title = titleRepo.getTitleById(titleId);
		return title;
	}

}
