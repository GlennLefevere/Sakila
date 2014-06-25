package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.ActorDAO;
import be.vdab.entities.Actor;

@Service
@Transactional(readOnly = true)
public class ActorServiceImpl implements ActorService{
	private ActorDAO actorDAO;
	
	@Autowired
	public ActorServiceImpl(ActorDAO actorDAO) {
		this.actorDAO = actorDAO;
	}

	@Override
	public Iterable<Actor> findByLastNameStartingWith(String naam){
		return actorDAO.findByLastNameStartingWith(naam);
	}

	@Override
	public void create(Actor actor) {
		actorDAO.save(actor);
	}

	@Override
	public Actor findById(long id) {
		return actorDAO.findOne(id);
	}

}
