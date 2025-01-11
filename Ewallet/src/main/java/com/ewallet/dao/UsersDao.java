package com.ewallet.dao;

import java.util.List;

import com.ewallet.model.Users;

public interface UsersDao {

	public void create(Users u);
	public void update(Users u);
	public void delete(int id);
	public List<Users> findAll();
	public Users findByUserAndPwd(String user);
}
