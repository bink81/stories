package com.marzeta.stories.action;

import org.apache.struts2.StrutsSpringTestCase;

import com.marzeta.stories.action.StoryDeleter;
import com.opensymphony.xwork2.ActionProxy;

public class StoryDeleterTest extends StrutsSpringTestCase {
	
	@Override
	public String getContextLocations() {
		return "applicationContextTest.xml";
	}
	
	public void testExecute() throws Exception {
		request.setParameter("id", "3");
		ActionProxy proxy = getActionProxy("storyDelete");
		StoryDeleter action = (StoryDeleter) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute() ;
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
	}
}
