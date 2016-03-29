package com.marzeta.stories.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
public class StoryDaoDeleteTest {
	private static final Logger LOGGER = Logger.getLogger(StoryDaoDeleteTest.class.getName());

	@Autowired
	StoryDao storyDao;

	@Test
	public void testDelete() {
		Story story = storyDao.findbyId(new Long("3"));
		storyDao.delete(story);
		LOGGER.info("Story with id of 3 was deleted.");
		List<Story> stories = storyDao.findAll();
		assertEquals("The number of stories found is not 2 but should be.", 2, stories.size());
	}
}