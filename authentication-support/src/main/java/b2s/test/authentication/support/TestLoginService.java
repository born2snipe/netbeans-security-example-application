package b2s.test.authentication.support;

import netbeans.security.login.LoginService;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service=LoginService.class)
public class TestLoginService implements LoginService {
    @Override
    public boolean login(String username, String password) {
        return username.equals(password) && TestUserManager.getInstance().isValidUser(username);
    }
}
