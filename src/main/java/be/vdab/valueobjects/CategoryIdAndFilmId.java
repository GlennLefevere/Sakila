package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoryIdAndFilmId implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="film_id")
	private long filmId;
	@Column(name="category_id")
	private long categoryId;
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
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
		CategoryIdAndFilmId other = (CategoryIdAndFilmId) obj;
		if (categoryId != other.categoryId)
			return false;
		if (filmId != other.filmId)
			return false;
		return true;
	}
	
}
