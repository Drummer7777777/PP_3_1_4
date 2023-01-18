package ivan.vitsin.springsecurity_js_rest.RestControllers;


import ivan.vitsin.springsecurity_js_rest.Exceptions.ExceptionMain;
import ivan.vitsin.springsecurity_js_rest.Exceptions.NoSuchUserException;
import ivan.vitsin.springsecurity_js_rest.model.User;
import ivan.vitsin.springsecurity_js_rest.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRest {

    private final UserService userService;

    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    User getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NoSuchUserException("No user with such ID found");
        }
        return user;
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMain> handleException(NoSuchUserException exception) {
    ExceptionMain data = new ExceptionMain();
    data.setInfo(exception.getMessage());
    return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }


    @PostMapping("/user")
    public User addNewUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @PatchMapping("/user")
    public User updateUser (@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NoSuchUserException("No user with such ID found");
        }
        userService.deleteById(id);
        return "User with ID = " + id + " was deleted!";
    }

    @GetMapping("/principal")
    public User viewAdminPage(Principal principal) {
        return userService.findUserByEmail(principal.getName());
    }
}
