package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Address;

public interface AddressDAO extends JpaRepository<Address, Long>{
}
