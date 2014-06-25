package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.StoreDAO;
import be.vdab.entities.Store;

@Service
public class StoreServiceImpl implements StoreService{
	private StoreDAO storeDAO;
	
	@Autowired
	public StoreServiceImpl(StoreDAO storeDAO) {
		this.storeDAO = storeDAO;
	}
	
	@Override
	public void create(Store store) {
		storeDAO.save(store);
	}

}
