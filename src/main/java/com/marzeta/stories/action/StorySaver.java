package com.marzeta.stories.action;

import com.marzeta.stories.model.Story;
import com.marzeta.stories.service.StoryService;
import com.opensymphony.xwork2.ActionSupport;

public class StorySaver extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private StoryService storyService;
	private Story story;
	
	@Override
	public String execute() {
		storyService.save(story); 
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if ( story.getDescription().length() == 0 ){	
			addFieldError( "story.name", "Name is required." );
		}
				
		if ( story.getName().length() == 0 ){	
			addFieldError( "story.description", "Description is required." );
		}
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
}
