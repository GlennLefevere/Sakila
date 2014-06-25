package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ActorIdAndFilmId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="actor_id")
	private long actorId;
	@Column(name="film_id")
	private long filmId;
	public long getActorId() {
		return actorId;
	}
	public void setActorId(long actorId) {
		this.actorId = actorId;
	}
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (actorId ^ (actorId >>> 32));
		result = prime * result + (int) (filmId ^ (filmId >>> 32));
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
		ActorIdAndFilmId other = (ActorIdAndFilmId) obj;
		if (actorId != other.actorId)
			return false;
		if (filmId != other.filmId)
			return false;
		return true;
	}
	
	
}
