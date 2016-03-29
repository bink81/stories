package com.marzeta.stories.action;

import java.util.List;

import com.marzeta.stories.model.Story;
import com.marzeta.stories.service.StoryService;
import com.opensymphony.xwork2.ActionSupport;

public class StoryFinderByNameFilter extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String nameFilter;
	private List<Story> stories;
	private StoryService storyService;

	@Override
	public String execute() throws Exception {
		stories = storyService.findByNameFilter(nameFilter);
		return SUCCESS;
	}

	public StoryService getStoryService() {
		return storyService;
	}

	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public String getNameFilter() {
		return nameFilter;
	}

	public void setNameFilter(String nameFilter) {
		this.nameFilter = nameFilter;
	}
}
