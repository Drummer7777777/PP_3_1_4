package ivan.vitsin.springsecurity_js_rest.services;

import ivan.vitsin.springsecurity_js_rest.model.User;

import java.util.List;

public interface UserService {


    User findById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(Long id);

    User findUserByEmail(String email);

}
