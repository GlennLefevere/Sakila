package be.vdab.entities;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@GeneratedValue
	@Column(name = "film_id")
	private long id;
	@NotBlank
	private String title;
	@NotBlank
	private String description;
	@DateTimeFormat(pattern = "yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "release_year")
	private Date releaseYear;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id")
	private Language language;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "original_language_id")
	private Language originalLanguage;
	@NumberFormat(style = Style.NUMBER)
	@Column(name = "rental_duration")
	private int rentalDuration;
	@NumberFormat(pattern = "#,##0.00")
	@Column(name = "rental_rate")
	private BigDecimal rentalRate;
	@NumberFormat(style = Style.NUMBER)
	private int length;
	@NumberFormat(pattern = "#,##0.00")
	@Column(name = "replacement_cost")
	private BigDecimal replacementCost;
	private String rating;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToMany(mappedBy = "film")
	private Set<Inventory> inventories;
	@OneToMany(mappedBy = "film")
	private Set<FilmActor> filmActors;
	@OneToMany(mappedBy = "film")
	private Set<FilmCategory> filmCategories;

	public Film() {
	}

	public Film(long filmId, String title, String description, Date releaseYear, Language language, Language originalLanguage, int rentalDuration, BigDecimal rentalRate, int length, BigDecimal replacementCost, String rating, /*
																																																								 * Set
																																																								 * <
																																																								 * String
																																																								 * >
																																																								 * specialFeatures
																																																								 * ,
																																																								 */Date lastUpdate, Set<FilmActor> filmActors,/*
																																																																			 * Set
																																																																			 * <
																																																																			 * FilmCategory
																																																																			 * >
																																																																			 * filmCategories
																																																																			 * ,
																																																																			 */Set<Inventory> inventories) {
		this.id = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = language;
		this.originalLanguage = originalLanguage;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.lastUpdate = lastUpdate;
		this.inventories = inventories;
		this.filmActors = filmActors;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public Language getLanguage() {
		return language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public int getLength() {
		return length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Set<Inventory> getInventories() {
		return Collections.unmodifiableSet(inventories);
	}

	public Set<FilmActor> getFilmActors() {
		return Collections.unmodifiableSet(filmActors);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.toLowerCase().hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		result = prime * result + ((rentalRate == null) ? 0 : rentalRate.hashCode());
		result = prime * result + ((replacementCost == null) ? 0 : replacementCost.hashCode());
		result = prime * result + ((title == null) ? 0 : title.toLowerCase().hashCode());
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
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equalsIgnoreCase(other.description))
			return false;
		if (inventories == null) {
			if (other.inventories != null)
				return false;
		} else if (!inventories.equals(other.inventories))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (length != other.length)
			return false;
		if (rating.equalsIgnoreCase(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (rentalRate == null) {
			if (other.rentalRate != null)
				return false;
		} else if (!rentalRate.equals(other.rentalRate))
			return false;
		if (replacementCost == null) {
			if (other.replacementCost != null)
				return false;
		} else if (!replacementCost.equals(other.replacementCost))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equalsIgnoreCase(other.title))
			return false;
		return true;
	}

}
