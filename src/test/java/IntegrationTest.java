
import static org.junit.jupiter.api.Assertions.*;

import dev.emilkorudzhiev.user.User;
import dev.emilkorudzhiev.user.UserAuth;
import dev.emilkorudzhiev.user.UserManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    private UserManagement userManagement;
    private UserAuth userAuth;

    @BeforeEach
    public void setUp() {
        userManagement = new UserManagement();
        userAuth = new UserAuth();
    }

    @Test
    public void testUserLifecycle() {
        User user = new User("test_user", "password");

        userManagement.addUser(user);
        assertEquals(1, userManagement.getUserCount());

        assertTrue(userAuth.login("test_user", "password"));

        userManagement.deleteUser("test_user", "password");
        assertEquals(0, userManagement.getUserCount());
    }

    @Test
    public void testInvalidLogin() {
        assertFalse(userAuth.login("non_existent_user", "password"));
    }

    @Test
    public void testDeleteNonExistentUser() {
        userManagement.deleteUser("non_existent_user", "password");
        assertEquals(0, userManagement.getUserCount());
    }
}
