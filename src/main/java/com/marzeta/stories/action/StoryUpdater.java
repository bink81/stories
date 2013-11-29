package com.marzeta.stories.action;

import com.marzeta.stories.model.Story;
import com.marzeta.stories.service.StoryService;
import com.opensymphony.xwork2.ActionSupport;

public class StoryUpdater extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private StoryService storyService;
	private Story story ;
	private Long id ;
	
	@Override
	public void validate() {
		if (story.getName().length() == 0){	
			addFieldError("story.name", "Name is mandatory.");
		}
				
		if ( story.getDescription().length() == 0 ){	
			addFieldError("story.description", "Description is mandatory.");
		}
	}
	
	@Override
	public String input() {
		story = storyService.findById(id);
		return INPUT ;
	}

	@Override
	public String execute() {
		storyService.update(story);
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
