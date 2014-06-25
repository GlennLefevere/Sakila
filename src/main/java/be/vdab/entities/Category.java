package be.vdab.entities;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private long id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToMany(mappedBy = "category")
	private Set<FilmCategory> filmCategories;

	public Category() {
	}

	public Category(long id, String name, Date lastUpdate, Set<FilmCategory> filmCategories) {
		this.id = id;
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.filmCategories = filmCategories;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Set<FilmCategory> getFilmCategories() {
		return Collections.unmodifiableSet(filmCategories);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmCategories == null) ? 0 : filmCategories.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (filmCategories == null) {
			if (other.filmCategories != null)
				return false;
		} else if (!filmCategories.equals(other.filmCategories))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}

}
