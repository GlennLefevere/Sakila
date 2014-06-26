package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Staff;

public interface StaffDAO extends JpaRepository<Staff, Long>{
	public Iterable<Staff> findByIdNotIn(List<Long> ids);
}
