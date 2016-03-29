package com.marzeta.stories.action;

import org.apache.struts2.StrutsSpringTestCase;

public abstract class CommonContextTestCase extends StrutsSpringTestCase {

	public CommonContextTestCase() {
		super();
	}

	@Override
	public String[] getContextLocations() {
		return new String[] { "applicationContextTest.xml" };
	}
}