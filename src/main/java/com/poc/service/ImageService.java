package com.poc.service;

import com.poc.dto.DataTransferObject;

public interface ImageService {
	public DataTransferObject fetchImage(DataTransferObject dto);
	public DataTransferObject fetchImageDetails(DataTransferObject dto);
	public DataTransferObject fetchImageNative(DataTransferObject dto);
	public void save(DataTransferObject dto);
	public void saveDetails(DataTransferObject dto);
}
