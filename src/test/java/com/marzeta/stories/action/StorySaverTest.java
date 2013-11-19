package com.marzeta.stories.action;

import org.apache.struts2.StrutsSpringTestCase;

import com.marzeta.stories.action.StorySaver;
import com.marzeta.stories.model.Story;
import com.opensymphony.xwork2.ActionProxy;

public class StorySaverTest extends StrutsSpringTestCase {
	private static final String NEW_DESC = "NewDesc";

	@Override
	public String getContextLocations() {
		return "applicationContextTest.xml";
	}

	public void testInput() throws Exception {
		ActionProxy proxy = getActionProxy("inputStorySave");
		StorySaver action = (StorySaver) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute() ;
		assertEquals("Result of calling input method is not input but it should be.", "input", result);
	}
	
	public void testExecute() throws Exception {
		request.setParameter("story.name", "NewStory");
		request.setParameter("story.description", NEW_DESC);
		ActionProxy proxy = getActionProxy("executeStorySave");
		StorySaver action = (StorySaver) proxy.getAction();
		assertNotNull(action);
		String result = proxy.execute() ;
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		Story story = action.getStory() ;
		assertEquals("Story's name is not updated.", NEW_DESC, story.getDescription() );
	}
}
