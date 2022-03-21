package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Mazda", 11);
        Car car2 = new Car("BMW", 12);
        Car car3 = new Car("Mercedez", 13);
        Car car4 = new Car("Toyota", 41);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("\nId = " + user.getId() +
                    "\nFirst Name = " + user.getFirstName() +
                    "\nLast Name = " + user.getLastName() +
                    "\nEmail = " + user.getEmail() +
                    "\nCar Model = " + user.getCar().getModel() +
                    "\nCar Series = " + user.getCar().getSeries() + "\n");
        }

        User user = userService.getUser("Mazda", 11);
        if (user != null) {
            System.out.println("\nId = " + user.getId() +
                    "\nFirst Name = " + user.getFirstName() +
                    "\nLast Name = " + user.getLastName() +
                    "\nEmail = " + user.getEmail() +
                    "\nCar Model = " + user.getCar().getModel() +
                    "\nCar Series = " + user.getCar().getSeries());
        } else {
            System.out.println("No user with such a car!");
        }

        context.close();
    }
}
