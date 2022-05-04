package pl.km.exercise201;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("Wojciech", "Kolano", 32));
        users.add(new User("Agnieszka", "Wywrotna", 27));
        users.add(new User("Arkadiusz", "Prosty", 63));
    }

    public void add(String firstName, String lastName, int age) {
        users.add(new User(firstName, lastName, age));
    }
}
