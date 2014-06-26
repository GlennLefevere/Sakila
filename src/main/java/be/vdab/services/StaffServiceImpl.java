package be.vdab.services;

import java.util.List;

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

	@Override
	public Iterable<Staff> findByIdIn(List<Long> ids) {
		return staffDAO.findByIdNotIn(ids);
	}

	@Override
	public void create(Staff staff) {
		staffDAO.save(staff);
	}

}
