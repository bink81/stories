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
	private static final Logger LOGGER = Logger.getLogger(StoryDaoJpa.class.getName());

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Story findbyId(Long id) throws DataAccessException {
		TypedQuery<Story> query = entityManager.createNamedQuery(Story.STORY_FIND_BY_ID, Story.class);
		query.setParameter("id", id);
		try {
			return query.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
			throw new RuntimeException("No result for id " + id, ex);
		}
	}

	@Override
	public List<Story> findbyName(String nameFilter) throws DataAccessException {
		List<Story> stories = null;
		TypedQuery<Story> query = entityManager.createNamedQuery(Story.STORY_FIND_BY_NAME_FILTER, Story.class);
		query.setParameter("nameFilter", nameFilter);
		try {
			stories = query.getResultList();
		} catch (javax.persistence.NoResultException ex) {
			LOGGER.warn("No Story was found with a nameFilter '" + nameFilter + "'");
		}
		return stories;
	}

	@Override
	public List<Story> findAll() {
		TypedQuery<Story> query = entityManager.createQuery("from " + Story.class.getName(), Story.class);
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
