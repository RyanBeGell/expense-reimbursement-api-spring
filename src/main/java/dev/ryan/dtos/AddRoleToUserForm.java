package dev.ryan.dtos;

import dev.ryan.config.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public
class AddRoleToUserForm {
    private String username;
    private Role role;
}
