package com.marzeta.stories.dao;

import java.util.List;

import com.marzeta.stories.model.Story;

public interface StoryDao {
	public Story findbyId(Long id);
	public List<Story> findbyName(String nameFilter);
	public List<Story> findAll();
	public void update(Story story);
	public void delete(Story story);
	public void save(Story story); 
}
