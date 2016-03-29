package com.marzeta.stories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marzeta.stories.dao.StoryDao;
import com.marzeta.stories.model.Story;

@Service("storyService")
public class StoryServiceImpl implements StoryService {

	@Autowired
	private StoryDao storyDao;

	@Override
	public Story findById(Long id) {
		return storyDao.findbyId(id);
	}

	@Override
	public List<Story> findByNameFilter(String nameFilter) {
		return storyDao.findbyNameFilter(nameFilter);
	}

	public StoryDao getStoryDao() {
		return storyDao;
	}

	public void setStoryDao(StoryDao storyDao) {
		this.storyDao = storyDao;
	}

	@Override
	public List<Story> findAll() {
		return storyDao.findAll();
	}

	@Override
	@Transactional
	public void update(Story story) {
		storyDao.update(story);
	}

	@Override
	@Transactional
	public void delete(Story story) {
		storyDao.delete(story);
	}

	@Override
	@Transactional
	public void save(Story story) {
		storyDao.save(story);
	}
}
