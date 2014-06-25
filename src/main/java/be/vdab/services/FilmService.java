package be.vdab.services;

import be.vdab.entities.Film;

public interface FilmService {
	public Iterable<Film> findAll();
	public Iterable<Film> findByStukNaam(String deel);
	public Film findActeurs(long id);
	public Film findById(long id);
}
