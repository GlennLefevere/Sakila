package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.FilmDAO;
import be.vdab.entities.Film;

@Service
@Transactional(readOnly = true)
class FilmServiceImpl implements FilmService{
	private final FilmDAO filmDAO;
	@Autowired
	public FilmServiceImpl(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	@Override
	public Iterable<Film> findAll() {
		return filmDAO.findAll();
	}

	@Override
	public Page<Film> findByStukNaam(String deel, Pageable pageable) {
		return filmDAO.findByTitleStartingWith(deel, pageable);
	}

	@Override
	public Film findActeurs(long id) {
		return filmDAO.findActeurs(id);
	}

	@Override
	public Film findById(long id) {
		return filmDAO.findOne(id);
	}

}
