package be.vdab.services;

import java.util.List;

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

	@Override
	public Iterable<Address> findByIdNotIn(List<Long> ids) {
		return addressDAO.findByIdNotIn(ids);
	}

}
