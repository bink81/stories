package com.marzeta.stories.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.marzeta.stories.model.Story;
import com.opensymphony.xwork2.ActionProxy;

public class AllStoriesFinderTest extends CommonContextTestCase {
	private static final Logger LOGGER = Logger.getLogger(AllStoriesFinderTest.class.getName());
	
	@Test
	public void testExecute() throws Exception {
		ActionProxy proxy = getActionProxy("allStoriesFinder");
		AllStoriesFinder action = (AllStoriesFinder) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute();
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		List<Story> stories = action.getStories() ;
		assertEquals("The number of stories found is not 3 but should be.", 3, stories.size());
		for (Story story : stories) {
			LOGGER.info(story);
		}
	}
}
