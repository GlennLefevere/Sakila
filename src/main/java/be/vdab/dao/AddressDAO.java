package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Address;

public interface AddressDAO extends JpaRepository<Address, Long>{
	public Iterable<Address> findByIdNotIn(List<Long> ids);
}
