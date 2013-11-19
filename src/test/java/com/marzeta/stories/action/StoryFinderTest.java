package com.marzeta.stories.action;

import org.apache.struts2.StrutsSpringTestCase;

import com.marzeta.stories.action.StoryFinder;
import com.marzeta.stories.model.Story;
import com.opensymphony.xwork2.ActionProxy;

public class StoryFinderTest extends StrutsSpringTestCase {
	@Override
	public String getContextLocations() {
		return "applicationContextTest.xml";
	}

	public void testExecute() throws Exception {
		request.setParameter("id", "1");
		ActionProxy proxy = getActionProxy("storyFinder");
		StoryFinder action = (StoryFinder) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute();
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		Story story = action.getStory();
		assertEquals("Story's first name is not correct", "There was a girl...", story.getDescription());
	}
}
