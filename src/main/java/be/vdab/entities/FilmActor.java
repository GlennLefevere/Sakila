package be.vdab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.vdab.valueobjects.ActorIdAndFilmId;

@Entity
@Table(name = "film_actor")
public class FilmActor {
	@EmbeddedId
	private ActorIdAndFilmId actorAndFilmId;
	@MapsId("actorId")
	@ManyToOne
	@JoinColumn(name="actor_id")
	private Actor actor;
	@MapsId("filmId")
	@ManyToOne
	@JoinColumn(name="film_id")
	private Film film;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;

	public FilmActor() {
	}
	
	public FilmActor(Film film, Actor actor) {
		this.lastUpdate = new Date();
		ActorIdAndFilmId actorIdAndFilmId = new ActorIdAndFilmId();
		actorIdAndFilmId.setActorId(actor.getId());
		actorIdAndFilmId.setFilmId(film.getId());
		this.actorAndFilmId=actorIdAndFilmId;
		this.actor = actor;
		this.film=film;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Film getFilm() {
		return film;
	}


	public Actor getActor() {
		return actor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorAndFilmId == null) ? 0 : actorAndFilmId.hashCode());
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
		FilmActor other = (FilmActor) obj;
		if (actorAndFilmId == null) {
			if (other.actorAndFilmId != null)
				return false;
		} else if (!actorAndFilmId.equals(other.actorAndFilmId))
			return false;
		return true;
	}

}
