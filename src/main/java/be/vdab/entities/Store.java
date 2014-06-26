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
@Table(name = "store")
public class Store {
	@Id
	@GeneratedValue
	@Column(name = "store_id")
	private long id;
	@OneToMany(mappedBy="store")
	private Set<Inventory> inventories;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;
	@OneToMany(mappedBy="store")
	private Set<Staff> staffMembers;
	@OneToMany(mappedBy="store")
	private Set<Customer> customers;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "manager_staff_id")
	private Staff manager;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;

	public Store() {
	}

	public Store(Address address, Staff manager){
		this.manager = manager;
		this.address = address;
		this.lastUpdate = new Date();
	}
	
	public Store(long id, Set<Inventory> invetnories, Address address, Set<Staff> staffMembers, Set<Customer> customers, Staff manager) {
		this.id = id;
		this.inventories = invetnories;
		this.address = address;
		this.staffMembers = staffMembers;
		this.customers = customers;
		this.manager = manager;
	}

	public long getId() {
		return id;
	}

	public Set<Inventory> getInvetnories() {
		return inventories;
	}

	public Address getAddress() {
		return address;
	}

	public Set<Staff> getStaffMembers() {
		return staffMembers;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public Staff getManager() {
		return manager;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Store other = (Store) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getNaam(){
		return address.getAddresses() + " - " + manager.getNaam() ;
	}

}
