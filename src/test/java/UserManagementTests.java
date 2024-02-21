import dev.emilkorudzhiev.user.User;
import dev.emilkorudzhiev.user.UserManagement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserManagementTests {

    @Test
    public void testAddUser() {
        UserManagement userManagement = new UserManagement();
        User user = new User("John", "Doe");
        userManagement.addUser(user);
        assertEquals(1, userManagement.getUserCount());
    }

    @Test
    public void testLogin() {
        UserManagement userManagement = new UserManagement();
        User user = new User("test_user", "password");
        userManagement.addUser(user);
        assertTrue(userManagement.login("test_user", "password"));
    }

    @Test
    public void testDeleteUser() {
        UserManagement userManagement = new UserManagement();
        User user1 = new User("test_user1", "password1");
        User user2 = new User("test_user2", "password2");

        userManagement.addUser(user1);
        userManagement.addUser(user2);

        userManagement.deleteUser("test_user1", "password1");
        assertEquals(1, userManagement.getUserCount());

        userManagement.deleteUser("test_user2", "password2");
        assertEquals(0, userManagement.getUserCount());
    }
}
