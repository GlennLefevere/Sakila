package be.vdab.services;

import be.vdab.entities.Address;

public interface AddressService {
	public Iterable<Address> findAll();
}
