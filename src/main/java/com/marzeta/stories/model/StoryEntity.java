package com.marzeta.stories.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "story")
@NamedQueries({
		@NamedQuery(name = StoryEntity.FIND_BY_ID, query = "SELECT s from StoryEntity s WHERE s.id = :id"),
		@NamedQuery(name = StoryEntity.FIND_BY_NAME_FILTER, query = "SELECT s from StoryEntity s WHERE s.name LIKE :nameFilter")
})
public class StoryEntity {
	public static final String FIND_BY_ID = "StoryEntity.findById";
	public static final String FIND_BY_NAME_FILTER = "StoryEntity.findByNameFilter";

	private Long id;
	private String description;
	private String name;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this, obj);
	}

	@Override
	public String toString() {
		return Objects.toString(this);
	}
}
