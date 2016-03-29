package com.marzeta.stories.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class StoryDaoTest {
	private static final Logger LOGGER = Logger.getLogger(StoryDaoTest.class);

	@Autowired
	StoryDao storyDao;

	@Test
	public void testFindbyId() {
		Story story = storyDao.findbyId(new Long("1"));
		assertNotNull("Story object is null but should not be.", story);
		LOGGER.info("Story state is " + story);
	}

	@Test
	public void testFindAll() {
		List<Story> stories = storyDao.findAll();
		assertEquals("The number of stories found is not 3 but should be.", 3, stories.size());
	}

	@Test
	public void testSaveStory() {
		Story story = new Story();
		story.setDescription("New Description");
		story.setName("New Story");
		storyDao.save(story);
		List<Story> stories = storyDao.findAll();

		assertEquals("The number of stories found is not 4 but should be.", 4, stories.size());
		LOGGER.info("Story state is " + story);
	}
}
