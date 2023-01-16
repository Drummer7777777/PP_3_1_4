package ivan.vitsin.springsecurity_js_rest.controller;

import ivan.vitsin.springsecurity_js_rest.model.Role;
import ivan.vitsin.springsecurity_js_rest.model.User;
import ivan.vitsin.springsecurity_js_rest.services.RoleService;
import ivan.vitsin.springsecurity_js_rest.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping(value = "/")
    public String start() {
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/admin")
    public String viewAdminPage(Model model, User user, Principal principal) {
        List<User> users = userService.findAll();
        List<Role> roles = roleService.findAllRoles();
        User principalUser = userService.findUserByEmail(principal.getName());
        model.addAttribute("users", users);
        model.addAttribute("user", user);
        model.addAttribute("principalUser", principalUser);
        model.addAttribute("roles", roles);
        return "admin";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return  "redirect:/admin";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return  "redirect:/admin";
    }
}
