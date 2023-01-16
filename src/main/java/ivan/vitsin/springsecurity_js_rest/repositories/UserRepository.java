package ivan.vitsin.springsecurity_js_rest.repositories;

import ivan.vitsin.springsecurity_js_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles where u.email = :email ")
    User findUserByEmail (String email);
}
