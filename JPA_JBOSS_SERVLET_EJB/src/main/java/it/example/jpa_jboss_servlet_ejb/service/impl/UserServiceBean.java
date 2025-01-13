package it.example.jpa_jboss_servlet_ejb.service.impl;

import it.example.jpa_jboss_servlet_ejb.DAO.UsersDAO;
import it.example.jpa_jboss_servlet_ejb.model.User;
import it.example.jpa_jboss_servlet_ejb.service.interfaces.UserServiceLocal;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserServiceBean implements UserServiceLocal {

    private UsersDAO usersDAO;

    public UserServiceBean() {
        usersDAO = new UsersDAO();
    }


    @Override
    public void createUser(User user) {
        usersDAO.insertUser(user);
    }

    @Override
    public User findUser(int id) {
       return usersDAO.getUser(id);
    }

    @Override
    public void updateUser(User user) {
        usersDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = findUser(id);
        if (user != null) {
            usersDAO.deleteUser(id);
        }
    }

    @Override
    public List<User> findAllUsers() {
        return usersDAO.getAllUsers();
    }
}
