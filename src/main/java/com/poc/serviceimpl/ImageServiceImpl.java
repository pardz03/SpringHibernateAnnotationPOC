package com.poc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dao.ImageDao;
import com.poc.dto.DataTransferObject;
import com.poc.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	ImageDao imageDao;
	
	@Override
	public DataTransferObject fetchImage(DataTransferObject dto) {
		// TODO Auto-generated method stub	
		return imageDao.fetch(dto);
	}

	@Override
	public DataTransferObject fetchImageDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return imageDao.fetchImageDetails(dto);
	}

	@Override
	public DataTransferObject fetchImageNative(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return imageDao.fetchImageNative(dto);
	}

	@Override
	public void save(DataTransferObject dto) {
		// TODO Auto-generated method stub
		imageDao.save(dto);
	}

	@Override
	public void saveDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		imageDao.saveDetails(dto);
	}

	@Override
	public void delete(DataTransferObject dto) {
		// TODO Auto-generated method stub
		imageDao.delete(dto);
	}

	@Override
	public void deleteDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		imageDao.deleteDetails(dto);
	}

}
