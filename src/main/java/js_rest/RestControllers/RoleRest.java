package js_rest.RestControllers;

import js_rest.model.Role;
import js_rest.services.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleRest {

    private final RoleService roleService;

    public RoleRest(RoleService roleService) {

        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {

        return roleService.findAllRoles();
    }
}
