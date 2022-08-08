package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from Users");
        return query.getResultList();
    }

    @Override
    public User getUserByCarAndSeries(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from Users user " +
                "left join fetch user.car " +
                "where user.car.model = :model " +
                "and user.car.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }
}
