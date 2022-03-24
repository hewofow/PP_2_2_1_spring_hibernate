package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User getUserByCar(String carModel, int carSeries);
    List<User> listUsers();
}
