package b2s.test.authentication.support;

import java.util.List;
import netbeans.security.login.UserRoleService;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service=UserRoleService.class)
public class TestUserRoleService implements UserRoleService {
    @Override
    public List<String> rolesUser(String username) {
        return TestUserManager.getInstance().getRolesFor(username);
    }
}
