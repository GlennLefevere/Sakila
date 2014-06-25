package be.vdab.web;

import javax.validation.constraints.NotNull;

import be.vdab.entities.Actor;

public class ActorForm {
	@NotNull
	private Actor actor;

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor acteur) {
		this.actor = acteur;
	}
	

}
