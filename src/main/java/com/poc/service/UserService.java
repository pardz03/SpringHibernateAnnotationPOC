package com.poc.service;

import com.poc.dto.DataTransferObject;

public interface UserService {
	boolean save(DataTransferObject dto);
	boolean update(DataTransferObject dto);
	boolean delete(DataTransferObject dto);
	DataTransferObject fetch(DataTransferObject dto);
}
