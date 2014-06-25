package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Actor;

public interface ActorDAO extends JpaRepository<Actor, Long> {
	public List<Actor> findByLastNameStartingWith(String naam);
}
