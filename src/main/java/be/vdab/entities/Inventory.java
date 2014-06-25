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

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue
	@Column(name = "inventory_id")
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private Film film;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	@OneToMany(mappedBy = "inventory")
	private Set<Rental> rentals;

	public Inventory() {
	}

	public Inventory(long id, Date lastUpdate, Film film, Store store, Set<Rental> rentals) {
		super();
		this.id = id;
		this.lastUpdate = lastUpdate;
		this.film = film;
		this.store = store;
		this.rentals = rentals;
	}

	public long getId() {
		return id;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Film getFilm() {
		return film;
	}

	public Store getStore() {
		return store;
	}

	public Set<Rental> getRentals() {
		return rentals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
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
		Inventory other = (Inventory) obj;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		return true;
	}

}
