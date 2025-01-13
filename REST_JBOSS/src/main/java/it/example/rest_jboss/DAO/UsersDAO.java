package it.example.rest_jboss.DAO;

import it.example.rest_jboss.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsersDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
    EntityManager em = emf.createEntityManager();

    public void insertUser(User user) {
            this.em.getTransaction().begin();
            this.em.persist(user);
            this.em.getTransaction().commit();
    }

    public void updateUser(User user) {
            this.em.getTransaction().begin();
            this.em.merge(user);
            this.em.getTransaction().commit();
    }

    public User getUser(Integer id) {
            return this.em.find(User.class, id);
    }

    public void deleteUser(Integer id) {
        this.em.getTransaction().begin();
        this.em.remove(em.find(User.class, id));
        this.em.getTransaction().commit();
    }

    public List<User> getAllUsers() {
            TypedQuery<User> query = this.em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = query.getResultList();
            return users;
    }

}
