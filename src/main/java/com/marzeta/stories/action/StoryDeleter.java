package com.marzeta.stories.action;

import com.marzeta.stories.model.Story;
import com.marzeta.stories.service.StoryService;
import com.opensymphony.xwork2.ActionSupport;

public class StoryDeleter extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private StoryService StoryService;
	private Story story ;
	private Long id ;

	@Override
	public String execute() {
		story = StoryService.findById(id);
		StoryService.delete(story); 
		return SUCCESS;
	}

	public StoryService getStoryService() {
		return StoryService;
	}

	public void setStoryService(StoryService storyService) {
		this.StoryService = storyService;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
