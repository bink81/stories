package com.marzeta.stories.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Story implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private String name;

	public Story() {
	}

	public Story(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	// all fields should be added here
	private ToStringBuilder createNewStringBuilder(ToStringBuilder builder) {
		return builder.append("id", this.id).append("description", this.description).append("name", this.name);
	}

	@Override
	public String toString() {
		return createNewStringBuilder(new ToStringBuilder(this)).toString();
	}

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
