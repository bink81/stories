package com.marzeta.stories.action;

import java.util.List;

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
		request.setParameter("nameFilter", "Cindirella");
		ActionProxy proxy = getActionProxy("storyFinder");
		StoryFinder action = (StoryFinder) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute();
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		List<Story> stories = action.getStories();
		assertEquals("Story's first name is not correct", "There was a girl...", stories.get(0).getDescription());
	}
}
