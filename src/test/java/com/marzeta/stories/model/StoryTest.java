package com.marzeta.stories.model;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class StoryTest {

	private Story story;

	@Before
	public void setUp() throws Exception {
		Story story2 = new Story();
		initId(story2);
		setStory(story2);
	}

	private void initId(Story story2) {
		story2.setId(new Long(10));
	}

	@Test
	public void testSetId() throws Exception {
		Long expected = new Long(11);
		story.setId(expected);
		Assert.assertEquals(expected, story.getId());
	}

	@Test
	public void testSetDescription() throws Exception {
		String expected = "New desc";
		story.setDescription(expected);
		Assert.assertEquals(expected, story.getDescription());
	}

	@Test
	public void testSetName() throws Exception {
		String expected = "New name";
		story.setName(expected);
		Assert.assertEquals(expected, story.getName());
	}
	
	public Story getStory() {
		return story;
	}
	
	public void setStory(Story story) {
		this.story = story;
	}

	@Test
	public void testHashCode() throws Exception {
		int hash = story.hashCode();
		story.setName("sth");
		Assert.assertNotSame(hash,story.hashCode());
	}
	
	@Test
	public void testDifferent() throws Exception {
		Story story2 = new Story();

		Assert.assertFalse(story.equals(story2));
	}

	@Test
	public void testSame() throws Exception {
		Story story2 = new Story();
		initId(story2);
		
		Assert.assertTrue(story.equals(story2));
	}
}
