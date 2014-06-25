package be.vdab.entities;

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

import com.sun.istack.NotNull;

@Entity
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue
	@Column(name = "city_id")
	private long id;
	@NotBlank
	@NotNull
	private String city;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
	@OneToMany(mappedBy="city")
	private Set<Address> addresses;

	public City() {
		super();
	}

	public City(long id, String city, Date lastUpdate, Country country) {
		super();
		this.id = id;
		this.city = city;
		this.lastUpdate = lastUpdate;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.toLowerCase().hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		City other = (City) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equalsIgnoreCase(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

	
	
}
