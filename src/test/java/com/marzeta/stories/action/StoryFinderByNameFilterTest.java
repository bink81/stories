package com.marzeta.stories.action;

import java.util.List;

import com.marzeta.stories.model.Story;
import com.opensymphony.xwork2.ActionProxy;

public class StoryFinderByNameFilterTest extends CommonContextTestCase {

	public void testExecute() throws Exception {
		request.setParameter("nameFilter", "Cindirella");
		ActionProxy proxy = getActionProxy("storyFinderByNameFilter");
		StoryFinderByNameFilter action = (StoryFinderByNameFilter) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute();
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		List<Story> stories = action.getStories();
		assertEquals("Story's first name is not correct", "There was a girl...", stories.get(0).getDescription());
	}
}
