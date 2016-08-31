package com.poc.service;

import com.poc.dto.DataTransferObject;

public interface UserService {
	//basic hibernate query
	boolean save(DataTransferObject dto);
	boolean update(DataTransferObject dto);
	boolean delete(DataTransferObject dto);
	DataTransferObject fetch(DataTransferObject dto);
	
	//HQL 
	boolean saveViaHQL(DataTransferObject dto);
	boolean updateViaHQL(DataTransferObject dto);
	boolean deleteViaHQL(DataTransferObject dto);
	DataTransferObject fetchViaHQL(DataTransferObject dto);
	
	//NATIVE Query
	DataTransferObject fetchViaNative(DataTransferObject dto);
}
