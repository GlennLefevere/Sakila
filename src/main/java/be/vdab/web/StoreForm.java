package be.vdab.web;


import javax.validation.constraints.NotNull;

import be.vdab.entities.Address;
import be.vdab.entities.Staff;

public class StoreForm {
	@NotNull
	private Staff staff;
	@NotNull
	private Address address;
	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
