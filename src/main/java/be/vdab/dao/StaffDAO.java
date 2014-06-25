package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Staff;

public interface StaffDAO extends JpaRepository<Staff, Long>{
}
