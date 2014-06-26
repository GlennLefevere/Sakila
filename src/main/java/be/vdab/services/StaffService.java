package be.vdab.services;

import java.util.List;

import be.vdab.entities.Staff;

public interface StaffService {
	public Iterable<Staff> findAll();
	public Iterable<Staff> findByIdIn(List<Long> ids);
	public void create(Staff staff);
}
