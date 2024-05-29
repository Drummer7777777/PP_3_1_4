package js_rest.services;

import js_rest.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    void saveRole(Role role);

    Role findRoleByName (String roleName);
}
