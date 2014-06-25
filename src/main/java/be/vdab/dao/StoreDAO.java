package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Store;

public interface StoreDAO extends JpaRepository<Store, Long> {

}
