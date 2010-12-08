package b2s.test.authentication.support;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUserManager {
    private static final TestUserManager INSTANCE = new TestUserManager();
    
    private Properties properties = new Properties();
    
    public static TestUserManager getInstance() {
        return INSTANCE;
    }
    
    private TestUserManager() {
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("b2s/test/authentication/support/users.properties"));
        } catch (IOException ex) {
            Logger.getLogger(TestUserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isValidUser(String username) {
        return properties.containsKey(username);
    }
    
    public List<String> getRolesFor(String username) {
        return Arrays.asList(properties.getProperty(username).split(","));
    }
}
