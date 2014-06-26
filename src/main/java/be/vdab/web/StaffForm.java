package be.vdab.web;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotBlank;

import be.vdab.entities.Staff;

public class StaffForm extends Staff {
	@NotBlank
	private String repeat;
	
	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	@AssertTrue
	public boolean isRepeateEqualToPassword() {
		if (getPassword() == null || getRepeat() == null) {
			return true;
		}
		return repeat.equals(getPassword());		
	}
	
}
