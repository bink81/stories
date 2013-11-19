package com.marzeta.stories.action;

import java.util.List;

import com.marzeta.stories.model.Story;
import com.marzeta.stories.service.StoryService;
import com.opensymphony.xwork2.ActionSupport;

public class AllStoriesFinder extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Story> stories;
	private StoryService storyService;
	
	@Override
	public String execute() throws Exception {
		stories = storyService.findAll();
		return SUCCESS;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public StoryService getStoryService() {
		return storyService;
	}

	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
}
