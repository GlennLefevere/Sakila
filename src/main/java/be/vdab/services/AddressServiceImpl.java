package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.AddressDAO;
import be.vdab.entities.Address;

@Service
public class AddressServiceImpl implements AddressService{
	private AddressDAO addressDAO;

	@Autowired
	public AddressServiceImpl(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}
	
	@Override
	public Iterable<Address> findAll() {
		return addressDAO.findAll();
	}

}
