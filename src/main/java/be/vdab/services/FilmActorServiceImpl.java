package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.FilmActorDAO;
import be.vdab.entities.FilmActor;

@Service
@Transactional(readOnly = true)
public class FilmActorServiceImpl implements FilmActorService{
	private FilmActorDAO filmActorDAO;
	
	@Autowired
	public FilmActorServiceImpl(FilmActorDAO filmActorDAO) {
		this.filmActorDAO = filmActorDAO;
	}
	
	@Override
	public void create(FilmActor filmActor) {
		filmActorDAO.save(filmActor);
	}

}
