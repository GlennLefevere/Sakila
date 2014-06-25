package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Store;
import be.vdab.services.AddressService;
import be.vdab.services.StaffService;
import be.vdab.services.StoreService;

@Controller
@RequestMapping("/stores")
public class StoreControler {
	private static final String NIEUWE_STORE_VIEW = "/stores/toevoegen";
	private static final String STORES_VIEW = "/stores/stores";
	private static final String REDIRECT_STORES = "redirect:/stores/stores";
	private final StoreService storeService;
	private final StaffService staffService;
	private final AddressService addressService;

	@Autowired
	public StoreControler(StoreService storeService, StaffService staffService, AddressService addressService) {
		this.staffService = staffService;
		this.addressService = addressService;
		this.storeService = storeService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/toevoegen")
	ModelAndView view() {
		return new ModelAndView(NIEUWE_STORE_VIEW).addObject("staffs",staffService.findAll()).addObject("addresses",addressService.findAll()).addObject(new StoreForm());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/toevoegen")
	ModelAndView create(@Valid StoreForm storeForm, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			storeService.create(new Store(storeForm.getAddress(), storeForm.getStaff()));
			return new ModelAndView(REDIRECT_STORES);
		}
		ModelAndView modelAndView = new ModelAndView(NIEUWE_STORE_VIEW);
		modelAndView.addObject(storeForm);
		modelAndView.addObject("staffs",staffService.findAll());
		modelAndView.addObject("addresses",addressService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/stores")
	ModelAndView stores(){
		return new ModelAndView(STORES_VIEW).addObject("stores",storeService.findAll());
	}
}
