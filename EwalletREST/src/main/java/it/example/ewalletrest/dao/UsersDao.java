package it.example.ewalletrest.dao;

import it.example.ewalletrest.model.Users;

import java.util.List;

public interface UsersDao {

	public void create(Users u);
	public void update(Users u);
	public void delete(int id);
	public List<Users> findAll();
	public Users findByUserAndPwd(String user);
}
