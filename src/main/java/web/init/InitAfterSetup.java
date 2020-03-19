package web.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
@Scope
public class InitAfterSetup {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initing() {
        if (userService.getUserByLogin("pavel") == null) {
            User user = new User("pavel", "herson", "123", 97, Collections.singleton(new Role("ADMIN")));
            userService.addUser(user);
        } else
            return;


    }
}
