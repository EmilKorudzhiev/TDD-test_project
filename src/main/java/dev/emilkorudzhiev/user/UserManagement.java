package dev.emilkorudzhiev.user;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    static List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public int getUserCount() {
        return users.size();
    }

    public void deleteUser(String username, String password) {
        users.removeIf(user ->
                user.getUsername().equals(username) &&
                user.getPassword().equals(password));
    }
}
