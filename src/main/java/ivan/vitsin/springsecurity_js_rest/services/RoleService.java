package Ivan.Vitsin.springsecurity.service;

import Ivan.Vitsin.springsecurity.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    void saveRole(Role role);

    Role findRoleByName (String roleName);
}
