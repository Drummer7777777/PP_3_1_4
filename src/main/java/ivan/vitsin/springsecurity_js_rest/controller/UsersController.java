package Ivan.Vitsin.springsecurity.controller;

import Ivan.Vitsin.springsecurity.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import Ivan.Vitsin.springsecurity.service.UserService;

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
