package it.example.jpa_jboss_servlet_ejb.service.interfaces;

import it.example.jpa_jboss_servlet_ejb.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserServiceLocal {
    void createUser(User user);

    User findUser(int id);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> findAllUsers();
}
