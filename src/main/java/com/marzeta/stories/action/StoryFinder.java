package com.marzeta.stories.action;

import com.marzeta.stories.model.Story;
import com.marzeta.stories.service.StoryService;
import com.opensymphony.xwork2.ActionSupport;

public class StoryFinder extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Story story;
	private StoryService storyService;

	@Override
	public String execute() throws Exception {
		setStory(storyService.findById(getId()));
		return SUCCESS;
	}

	public StoryService getStoryService() {
		return storyService;
	}

	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
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
