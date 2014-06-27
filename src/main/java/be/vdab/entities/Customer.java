package be.vdab.entities;

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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private long id;
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	@Email
	private String email;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;
	private int active;
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToMany(mappedBy = "customer")
	private Set<Payment> payments;
	@OneToMany(mappedBy = "customer")
	private Set<Rental> rentals;
	
	public Customer(){}

	public Customer(long id, String firstName, String lastName, String email, Store store, Address address, int active, Date createDate, Date lastUpdate, Set<Payment> payments, Set<Rental> rentals) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.store = store;
		this.address = address;
		this.active = active;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.payments = payments;
		this.rentals = rentals;
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

	public String getEmail() {
		return email;
	}

	public Store getStore() {
		return store;
	}

	public Address getAddress() {
		return address;
	}

	public int getActive() {
		return active;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Set<Payment> getPayments() {
		return Collections.unmodifiableSet(payments);
	}

	public Set<Rental> getRentals() {
		return Collections.unmodifiableSet(rentals);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.toLowerCase().hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.toLowerCase().hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.toLowerCase().hashCode());
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equalsIgnoreCase(other.email))
			return false;
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
		return true;
	}
	
}
