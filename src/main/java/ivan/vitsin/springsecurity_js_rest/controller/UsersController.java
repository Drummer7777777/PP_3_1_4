package ivan.vitsin.springsecurity_js_rest.controller;

import ivan.vitsin.springsecurity_js_rest.model.User;
import ivan.vitsin.springsecurity_js_rest.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getMainPage(Model model, Principal principal){
        User principalUser = userService.findUserByEmail(principal.getName());
        model.addAttribute("user", principalUser);
        return "user";
    }
}
