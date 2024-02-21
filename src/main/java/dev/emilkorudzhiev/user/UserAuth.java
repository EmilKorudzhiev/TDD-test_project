package dev.emilkorudzhiev.user;

public class UserAuth {
    public boolean login(String username, String password) {
        for (User user : UserManagement.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
