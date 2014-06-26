package be.vdab.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Film;

public interface FilmService {
	public Iterable<Film> findAll();
	public Page<Film> findByStukNaam(String deel, Pageable pageable);
	public Film findActeurs(long id);
	public Film findById(long id);
}
