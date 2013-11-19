package com.marzeta.stories.service;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.marzeta.stories.model.Story;
import com.marzeta.stories.service.StoryService;

@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StoryServiceTest {
	
	private static final Logger logger = Logger.getLogger(StoryServiceTest.class.getName() );
	
	@Autowired
	StoryService storyService;

	@Test
		public void testFindById() {
			
			Story story = storyService.findById( new Long("1") );
			
			assertNotNull("Story object is null but should not be.", story);
			
			logger.info("Story state is " + story);
			
			
		}

}
