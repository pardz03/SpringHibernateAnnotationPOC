package com.poc.dto;

import java.util.List;

import com.poc.model.User;

public class DataTransferObject {
	private User user;
	
	private List<User> listUser;

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
}
