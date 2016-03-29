package com.marzeta.stories.model;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class StoryTest {

	private static final Long STORY_ID = new Long(10);
	private Story story;

	@Before
	public void setUp() throws Exception {
		story = new Story();
		story.setId(STORY_ID);
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

	@Test
	public void testHashCode() throws Exception {
		int hash = story.hashCode();
		story.setName("sth");
		Assert.assertNotSame(hash, story.hashCode());
	}

	@Test
	public void testDifferent() throws Exception {
		Story story2 = new Story();

		Assert.assertFalse(story.equals(story2));
	}

	@Test
	public void testSame() throws Exception {
		Story story2 = new Story();
		story2.setId(STORY_ID);

		Assert.assertTrue(story.equals(story2));
	}
}
