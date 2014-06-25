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
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private long id;
	private String address;
	@Column(name = "address2")
	private String adresstwee;
	private String district;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;
	@Column(name = "postal_code")
	private String postalCode;
	private String phone;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToMany(mappedBy="address")
	private Set<Staff> staffs;
	@OneToMany(mappedBy="address")
	private Set<Store> stores;
	@OneToMany(mappedBy="address")
	private Set<Customer> customers;

	public Address() {
	}

	public Address(long id, String address, String adresstwee, String district, City city, String postalCode, String phone, Date lastUpdate) {
		this.id = id;
		this.address = address;
		this.adresstwee = adresstwee;
		this.district = district;
		this.city = city;
		this.postalCode = postalCode;
		this.phone = phone;
		this.lastUpdate = lastUpdate;
	}

	public long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getAdresstwee() {
		return adresstwee;
	}

	public String getDistrict() {
		return district;
	}

	public City getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.toLowerCase().hashCode());
		result = prime * result + ((adresstwee == null) ? 0 : adresstwee.toLowerCase().hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((district == null) ? 0 : district.toLowerCase().hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.toLowerCase().hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.toLowerCase().hashCode());
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
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equalsIgnoreCase(other.address))
			return false;
		if (adresstwee == null) {
			if (other.adresstwee != null)
				return false;
		} else if (!adresstwee.equalsIgnoreCase(other.adresstwee))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equalsIgnoreCase(other.district))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equalsIgnoreCase(other.phone))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equalsIgnoreCase(other.postalCode))
			return false;
		return true;
	}
	
	

}
