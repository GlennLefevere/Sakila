package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import be.vdab.entities.Film;

public interface FilmDAO extends JpaRepository<Film, Long> {
	public List<Film> findByTitleStartingWith(String naam);
	public Film findActeurs(@Param("id") long id);
}
