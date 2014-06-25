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

import be.vdab.valueobjects.CategoryIdAndFilmId;

@Entity
@Table(name = "film_category")
public class FilmCategory {
	@EmbeddedId
	private CategoryIdAndFilmId categoryIdAndFilmId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@MapsId("filmId")
	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;
	@MapsId("categoryId")
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public FilmCategory() {
	}

	public FilmCategory(Film film, Category category) {
		CategoryIdAndFilmId categoryIdAndFilmId = new CategoryIdAndFilmId();
		categoryIdAndFilmId.setCategoryId(category.getId());
		categoryIdAndFilmId.setFilmId(film.getId());
		this.lastUpdate = new Date();
		this.film = film;
		this.category = category;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Film getFilm() {
		return film;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryIdAndFilmId == null) ? 0 : categoryIdAndFilmId.hashCode());
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
		FilmCategory other = (FilmCategory) obj;
		if (categoryIdAndFilmId == null) {
			if (other.categoryIdAndFilmId != null)
				return false;
		} else if (!categoryIdAndFilmId.equals(other.categoryIdAndFilmId))
			return false;
		return true;
	}

}
