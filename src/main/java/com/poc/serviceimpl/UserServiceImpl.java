package com.poc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dao.UserDao;
import com.poc.dto.DataTransferObject;
import com.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean save(DataTransferObject dto) {
		// TODO Auto-generated method stub			
		return userDao.save(dto);
	}

	@Override
	public boolean update(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return userDao.update(dto);
	}

	@Override
	public boolean delete(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return userDao.delete(dto);
	}

	@Override
	public DataTransferObject fetch(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return userDao.fetch(dto);
	}

}
