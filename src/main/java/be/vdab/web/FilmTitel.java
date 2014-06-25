package be.vdab.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FilmTitel {
	@NotNull
	@Size(min=1, max = 50)
	private String titel;

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}
	

}
