package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByCar(String carModel, int carSeries) {
        return (User) sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series")
                .setParameter("model", carModel)
                .setParameter("series", carSeries)
                .getSingleResult();

//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
//                        "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series")
//                .setParameter("model", carModel)
//                .setParameter("series", carSeries);
//        query.setMaxResults(1);
//        return query.getResultList().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").getResultList();
    }
}
