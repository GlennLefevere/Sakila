package be.vdab.entities;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "language")
public class Language {
	@Id
	@GeneratedValue
	@Column(name = "language_id")
	private long id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id")
	private Set<Film> films;

	public Language() {
	}

	public Language(long id, String name, Date lastUpdate) {
		this.id = id;
		this.name = name;
		this.lastUpdate = lastUpdate;
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

	public Set<Film> getFilms() {
		return Collections.unmodifiableSet(films);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Language other = (Language) obj;
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
