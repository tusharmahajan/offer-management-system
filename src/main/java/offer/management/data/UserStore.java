package offer.management.data;

import offer.management.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserStore {

    private static final List<User> users = new ArrayList<>();

    public static User getUserById(String userId) {
        return users.stream().filter(s -> s.getUserId().equals(userId)).findFirst().orElse(null);
    }

    public static void addUser(User user){
        users.add(user);
    }
}
