package be.vdab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import be.vdab.entities.Film;

public interface FilmDAO extends JpaRepository<Film, Long> {
	public Page<Film> findByTitleStartingWith(String naam, Pageable pageable);
	public Film findActeurs(@Param("id") long id);
}
