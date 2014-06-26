package be.vdab.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Staff;
import be.vdab.entities.Store;
import be.vdab.services.AddressService;
import be.vdab.services.StaffService;
import be.vdab.services.StoreService;

@Controller
@RequestMapping("/staffs")
public class StaffControler {
	private static final String STAFF_TOEVOEGEN_VIEW = "/staffs/toevoegen";
	private static final String REDIRECT_NA_TOEVOEGEN = "redirect:/stores/stores";
	private AddressService addressService;
	private StoreService storeService;
	private StaffService staffService;
	
	@Autowired
	public StaffControler(StoreService storeService, AddressService addressService,StaffService staffService) {
		this.addressService = addressService;
		this.storeService = storeService;
		this.staffService = staffService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="toevoegen")
	ModelAndView view(){
		List<Store> stores = (List<Store>) storeService.findAll();
		List<Long> addressIds = new ArrayList<>();
		for (Store store : stores) {
			addressIds.add(store.getAddress().getId());
		}
		return new ModelAndView(STAFF_TOEVOEGEN_VIEW).addObject("addresses", addressService.findByIdNotIn(addressIds)).addObject("stores", stores).addObject(new StaffForm());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "toevoegen")
	ModelAndView create(@Valid StaffForm staffForm, BindingResult bindingResult){
		if(!bindingResult.hasErrors() && staffForm.isValid()){
			staffService.create(new Staff( staffForm.getFirstName(), staffForm.getLastName(), staffForm.getAddress(), staffForm.getEmail(), staffForm.getStore(), staffForm.getUsername(), staffForm.getPassword()));
			return new ModelAndView(REDIRECT_NA_TOEVOEGEN);
		}
		bindingResult.reject("repeat", "paswoord en herhaal zijn niet gelijk");
		List<Store> stores = (List<Store>) storeService.findAll();
		List<Long> addressIds = new ArrayList<>();
		for (Store store : stores) {
			addressIds.add(store.getAddress().getId());
		}
		return new ModelAndView(STAFF_TOEVOEGEN_VIEW).addObject("addresses", addressService.findByIdNotIn(addressIds)).addObject("stores", stores).addObject(staffForm);
	}

}
