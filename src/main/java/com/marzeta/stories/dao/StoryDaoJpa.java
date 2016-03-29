package com.marzeta.stories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.marzeta.stories.model.Story;
import com.marzeta.stories.model.StoryEntity;

@Repository("storyDao")
public class StoryDaoJpa implements StoryDao {
	private static final Logger LOGGER = Logger.getLogger(StoryDaoJpa.class);

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Story findbyId(Long id) throws DataAccessException {
		StoryEntity storyEntity = findEntityById(id);
		if (storyEntity != null) {
			return new Story(storyEntity.getId(), storyEntity.getName(), storyEntity.getDescription());
		}
		return null;
	}

	@Override
	public List<Story> findbyNameFilter(String nameFilter) throws DataAccessException {
		TypedQuery<StoryEntity> query = entityManager.createNamedQuery(StoryEntity.FIND_BY_NAME_FILTER,
				StoryEntity.class);
		query.setParameter("nameFilter", nameFilter);
		try {
			return mapStoryTablesToStories(query.getResultList());
		} catch (javax.persistence.NoResultException ex) {
			LOGGER.warn("No Story was found with a nameFilter '" + nameFilter + "'");
		}
		return null;
	}

	@Override
	public List<Story> findAll() {
		TypedQuery<StoryEntity> query = entityManager.createQuery("from " + StoryEntity.class.getName(), StoryEntity.class);
		List<StoryEntity> stories = query.getResultList();
		return mapStoryTablesToStories(stories);
	}

	private List<Story> mapStoryTablesToStories(List<StoryEntity> storyTables) {
		List<Story> stories = Lists.transform(storyTables, new Function<StoryEntity, Story>() {
			@Override
			public Story apply(StoryEntity t) {
				return new Story(t.getId(), t.getName(), t.getDescription());
			}
		});
		return stories;
	}

	@Override
	public void update(Story story) {
		StoryEntity storyEntity = findEntityById(story.getId());
		storyEntity = mergeEntity(storyEntity, story);
		entityManager.merge(storyEntity);
	}

	@Override
	public void delete(Story story) {
		StoryEntity storyEntity = findEntityById(story.getId());
		entityManager.remove(storyEntity);
	}

	@Override
	public void save(Story story) {
		StoryEntity storyEntity = new StoryEntity();
		storyEntity = mergeEntity(storyEntity, story);
		entityManager.persist(storyEntity);
	}

	private StoryEntity mergeEntity(StoryEntity storyEntity, Story story) {
		storyEntity.setName(story.getName());
		storyEntity.setDescription(story.getDescription());
		return storyEntity;
	}

	public StoryEntity findEntityById(Long id) throws DataAccessException {
		TypedQuery<StoryEntity> query = entityManager.createNamedQuery(StoryEntity.FIND_BY_ID, StoryEntity.class);
		query.setParameter("id", id);
		try {
			StoryEntity storyTable = query.getSingleResult();
			return storyTable;
		} catch (javax.persistence.NoResultException ex) {
			LOGGER.warn("No result for id " + id);
		}
		return null;
	}
}
