package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.ItemShelveDetailsServiceDTO;
import com.pro.scm.servicedto.LoadItemServiceDTO;
import com.pro.scm.servicedto.LoadShelveServiceDTO;
import com.pro.scm.servicedto.ShelveRackServiceDTO;


public interface ItemShelveService {

	public String saveItemShelveDetails(ItemShelveDetailsServiceDTO objItemShelveDetailsServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String updateShelveItems(ItemShelveDetailsServiceDTO objItemShelveDetailsServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<ItemShelveDetailsServiceDTO> loadRackByStores(ItemShelveDetailsServiceDTO objItemShelveDetailsServiceDTO, String strRequestID)throws DataNotFoundException;

	public List<LoadItemServiceDTO> loadItems(LoadItemServiceDTO objLoadItemServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<LoadShelveServiceDTO> loadShelves(LoadShelveServiceDTO objLoadShelveServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<ShelveRackServiceDTO> loadShelvesRack(ShelveRackServiceDTO objShelveRackServiceDTO, String strRequestID)throws DataNotFoundException;
	

    public List<ShelveRackServiceDTO> loadStore(String strRequestID)throws DataNotFoundException;

}
