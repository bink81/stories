package com.marzeta.stories.action;

import org.apache.struts2.StrutsSpringTestCase;

import com.marzeta.stories.action.StoryUpdater;
import com.marzeta.stories.model.Story;
import com.opensymphony.xwork2.ActionProxy;

public class StoryUpdaterTest extends StrutsSpringTestCase {
	private static final String NEW_DESCRIPTION = "New descripion";
	private static final String NEW_NAME = "Another Snow White";

	@Override
	public String getContextLocations() {
		return "applicationContextTest.xml";
	}

	public void testInput() throws Exception {
		request.setParameter("id", "1");
		ActionProxy proxy = getActionProxy("inputStoryUpdate");
		StoryUpdater action = (StoryUpdater) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute() ;
		assertEquals("Result of calling input method is not input but it should be.", "input", result);
		Story story = action.getStory() ;
		assertEquals("Story's name is not correct.", "Cindirella", story.getName());
	}
	
	public void testExecute() throws Exception {
		request.setParameter("story.id", "2");
		request.setParameter("story.name", NEW_NAME);
		request.setParameter("story.description", NEW_DESCRIPTION);
		
		ActionProxy proxy = getActionProxy("executeStoryUpdate");
		StoryUpdater action = (StoryUpdater) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute() ;
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		Story story = action.getStory() ;
		assertEquals("Story's description is not updated.", NEW_DESCRIPTION, story.getDescription());
		assertEquals("Story's name is not updated.", NEW_NAME, story.getName());
	}
}
