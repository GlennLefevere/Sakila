package be.vdab.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.sun.istack.NotNull;

import be.vdab.entities.Payment;
import be.vdab.entities.Store;

@Entity
@Table(name = "staff")
public class Staff {
	@Id
	@GeneratedValue
	@Column(name = "staff_id")
	private long id;
	@NotNull
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	@NotNull
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;
	@Lob
	private byte[] picture;
	@NotNull
	@NotBlank
	@Email
	private String email;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	private int active;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToMany(mappedBy = "staff")
	private Set<Payment> payments;
	@OneToMany(mappedBy = "staff")
	private Set<Rental> rentals;
	@OneToMany(mappedBy = "manager")
	private Set<Store> stores;

	public Staff() {
	}

	public Staff(String firstName, String lastName, Address address, String email, Store store, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.store = store;
		this.username = username;
		this.password = password;
		this.lastUpdate = new Date();
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

	public Address getAddress() {
		return address;
	}

	public byte[] getPicture() {
		return picture;
	}

	public String getEmail() {
		return email;
	}

	public Store getStore() {
		return store;
	}

	public int getActive() {
		return active;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public Set<Rental> getRentals() {
		return rentals;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public String getNaam() {
		return firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.toLowerCase().hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.toLowerCase().hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.toLowerCase().hashCode());
		result = prime * result + ((password == null) ? 0 : password.toLowerCase().hashCode());
		result = prime * result + ((username == null) ? 0 : username.toLowerCase().hashCode());
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
		Staff other = (Staff) obj;
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equalsIgnoreCase(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equalsIgnoreCase(other.username))
			return false;
		return true;
	}

}
