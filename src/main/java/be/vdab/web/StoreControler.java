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
		return createModelAndView().addObject(new StoreForm());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/toevoegen")
	ModelAndView create(@Valid StoreForm storeForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			storeService.create(new Store(storeForm.getAddress(), storeForm.getStaff()));
			return new ModelAndView(REDIRECT_STORES);
		}
		return createModelAndView();
	}

	private ModelAndView createModelAndView() {
		ModelAndView modelAndView = new ModelAndView(NIEUWE_STORE_VIEW);
		List<Store> stores = (List<Store>) storeService.findAll();
		List<Long> managerIds = new ArrayList<>();
		List<Long> addressIds = new ArrayList<>();
		for (Store store : stores) {
			addressIds.add(store.getAddress().getId());
			managerIds.add(store.getManager().getId());
		}
		modelAndView.addObject("staffs", staffService.findByIdNotIn(managerIds));
		modelAndView.addObject("addresses", addressService.findByIdNotIn(addressIds));
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/stores")
	ModelAndView stores() {
		return new ModelAndView(STORES_VIEW).addObject("stores", storeService.findAll());
	}
}
