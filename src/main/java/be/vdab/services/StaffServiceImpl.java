package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.StaffDAO;
import be.vdab.entities.Staff;

@Service
public class StaffServiceImpl implements StaffService{
	private StaffDAO staffDAO;
	
	@Autowired
	public StaffServiceImpl(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	@Override
	public Iterable<Staff> findAll() {
		return staffDAO.findAll();
	}

}
