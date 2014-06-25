package be.vdab.services;

import be.vdab.entities.Actor;

public interface ActorService {
	public Iterable<Actor> findByLastNameStartingWith(String naam);
	public void create(Actor actor);
	public Actor findById(long id);
}
