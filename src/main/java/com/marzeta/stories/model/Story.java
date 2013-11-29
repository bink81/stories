package com.marzeta.stories.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="story")
@NamedQueries({@NamedQuery(name=Story.STORY_FIND_BY_ID, query="from Story where id = :id"),
@NamedQuery(name=Story.STORY_FIND_BY_NAME, query="from Story where name LIKE :nameFilter")})
public class Story implements Serializable {
	public static final String STORY_FIND_BY_ID = "story.findById";
	public static final String STORY_FIND_BY_NAME = "story.findByName";

	private static final long serialVersionUID = 3697535594187479699L;

	private Long id;
	private String description;
	private String name;
	
	// all fields should be added here
	private ToStringBuilder createNewStringBuilder(ToStringBuilder builder) {
		return builder.
				append("id",  this.id). 
				append("description",  this.description).
				append("name", this.name);
	}
	
	@Override
	public String toString() {
		return createNewStringBuilder(new ToStringBuilder(this)).toString();
	}

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

	public void setName(String last_name) {
		this.name = last_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Story other = (Story) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
}
