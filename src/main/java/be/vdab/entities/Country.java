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

import org.hibernate.validator.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue
	@Column(name = "country_id")
	private long id;
	@NotNull
	@NotBlank
	private String country;
	@OneToMany(mappedBy = "country")
	private Set<City> cities;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;

	public Country() {
	}

	public Country(long id, String country, Set<City> cities, Date lastUpdate) {
		this.id = id;
		this.country = country;
		this.cities = cities;
		this.lastUpdate = lastUpdate;
	}

	public long getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public Set<City> getCities() {
		return Collections.unmodifiableSet(cities);
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((country == null) ? 0 : country.toLowerCase().hashCode());
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
		Country other = (Country) obj;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equalsIgnoreCase(other.country))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

}
