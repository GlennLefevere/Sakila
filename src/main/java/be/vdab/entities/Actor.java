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
@Table(name = "actor")
public class Actor {
	@Id
	@GeneratedValue
	@Column(name = "actor_id")
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToMany(mappedBy="actor")
	private Set<FilmActor> filmActors;

	public Actor() {
	}

	public Actor(long id, String firstName, String lastName, Date lastUpdate, Set<FilmActor> filmActors) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
		this.filmActors = filmActors;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Set<FilmActor> getFilmActors() {
		return Collections.unmodifiableSet(filmActors);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.toLowerCase().hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.toLowerCase().hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
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
		Actor other = (Actor) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equalsIgnoreCase(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equalsIgnoreCase(other.lastName))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	public String getName() {
		return lastName + ' ' + firstName;
	}
	

}
