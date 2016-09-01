package com.poc.dto;

import java.util.List;

import com.poc.model.Image;
import com.poc.model.ImageDetails;
import com.poc.model.User;

public class DataTransferObject {
	private User user;
	
	private List<User> listUser;
	
	private List<Image> listImage;
	
	private List<ImageDetails> listImageDetails;
	
	private Image image;
	
	private ImageDetails imageDetails;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public List<Image> getListImage() {
		return listImage;
	}

	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}

	public List<ImageDetails> getListImageDetails() {
		return listImageDetails;
	}

	public void setListImageDetails(List<ImageDetails> listImageDetails) {
		this.listImageDetails = listImageDetails;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ImageDetails getImageDetails() {
		return imageDetails;
	}

	public void setImageDetails(ImageDetails imageDetails) {
		this.imageDetails = imageDetails;
	}
}
