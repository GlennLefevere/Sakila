package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.FilmActor;

public interface FilmActorDAO extends JpaRepository<FilmActor, Long>{
	
}
