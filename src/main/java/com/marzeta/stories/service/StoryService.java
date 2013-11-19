package com.marzeta.stories.service;

import java.util.List;

import com.marzeta.stories.model.Story;

public interface StoryService {
	public Story findById(Long id);
	public List<Story> findAll();
	public void update(Story story);
	public void delete(Story story);
	public void save(Story story); 
}
