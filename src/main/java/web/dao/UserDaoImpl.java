package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;
import javax.persistence.TypedQuery;
import java.util.List;



@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from User user where user.id =:id  ");
            query.setParameter("id", id);
            List<User> users = query.list();
            if (users.isEmpty()) {
                throw new Exception("users is empty");// return null;
            }
            return users.listIterator().next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public User getUserbyLogin(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from User user where user.name=:name  ");
            query.setParameter("name", name);
            List<User> users = query.list();
            if (users.isEmpty()) {
                 return null;
            }
            return users.listIterator().next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeUser(long id) {
        User user = getUserById(id);
        sessionFactory.getCurrentSession().delete(user);
    }


}
