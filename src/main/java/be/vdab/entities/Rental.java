package be.vdab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rental")
public class Rental {
	@Id
	@GeneratedValue
	@Column(name = "rental_id")
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	@Temporal(TemporalType.DATE)
	@Column(name = "rental_date")
	private Date rentalDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	private Date returnDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@ManyToOne
	@JoinColumn(name="inventory_id")
	private Inventory inventory;

	public Rental() {
	}

	public Rental(long id, Customer customer, Staff staff, Date rentalDate, Date returnDate, Date lastUpdate, Inventory inventory) {
		this.id = id;
		this.customer = customer;
		this.staff = staff;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.lastUpdate = lastUpdate;
		this.inventory = inventory;
	}

	public long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Inventory getInventory() {
		return inventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
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
		Rental other = (Rental) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		return true;
	}
	
}
