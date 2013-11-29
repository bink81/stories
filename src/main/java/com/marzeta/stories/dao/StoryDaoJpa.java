package com.marzeta.stories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.marzeta.stories.model.Story;

@Repository("storyDao")
public class StoryDaoJpa implements StoryDao {
	private static final Class<Story> STORY_CLASS = Story.class;

	private static final Logger logger = Logger.getLogger(StoryDaoJpa.class.getName());
	
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Story findbyId(Long id) throws DataAccessException {
		Story story = null ;
		TypedQuery<Story> query =  entityManager.createNamedQuery(Story.STORY_FIND_BY_ID, STORY_CLASS);
		query.setParameter("id", id);
		try {
			story = query.getSingleResult() ;
		} catch (javax.persistence.NoResultException ex) {
			logger.warn("No Story was found with an id " + id);
		}
		
		return story;
	}

	@Override
	public List<Story> findAll() {
		TypedQuery<Story> query = entityManager.createQuery("from " + STORY_CLASS.getName(), STORY_CLASS);
		List<Story> stories = query.getResultList();
		return stories;
	}

	@Override
	public void update(Story story) {
		entityManager.merge(story);
	}

	@Override
	public void delete(Story story) {
		Story deleteStory = entityManager.merge(story);
		entityManager.remove(deleteStory);
	}

	@Override
	public void save(Story story) {
		entityManager.persist(story);
	}
}
