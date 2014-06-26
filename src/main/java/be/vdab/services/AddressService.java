package be.vdab.services;

import java.util.List;

import be.vdab.entities.Address;

public interface AddressService {
	public Iterable<Address> findAll();
	public Iterable<Address> findByIdNotIn(List<Long> ids);
}
