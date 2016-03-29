package com.marzeta.stories.dao;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.marzeta.stories.model.Story;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class StoryDaoUpdateTest {
	private static final Logger LOGGER = Logger.getLogger(StoryDaoTest.class);

	@Autowired
	StoryDao storyDao;

	@Test
	public void testUdate() {
		Story story1 = new Story();
		story1.setId(new Long("1"));
		story1.setDescription("NewDescription");
		story1.setName("NewStory");

		storyDao.update(story1);
		LOGGER.info("Story with id of 1 name was changed to NewStory");

		Story story = storyDao.findbyId(new Long("1"));
		assertEquals("Name of update story is not NewDescription but it should be.", "NewDescription",
				story.getDescription());
	}
}
