package be.vdab.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ActeurNaam {
	@NotNull
	@Size(min=1, max = 50)
	private String naamdeel;

	public String getNaamdeel() {
		return naamdeel;
	}

	public void setNaamdeel(String naamdeel) {
		this.naamdeel = naamdeel;
	}
}
