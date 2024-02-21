package dev.emilkorudzhiev.user;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public int getUserCount() {
        return users.size();
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void deleteUser(String username, String password) {
        users.removeIf(user ->
                user.getUsername().equals(username) &&
                user.getPassword().equals(password));
    }
}
