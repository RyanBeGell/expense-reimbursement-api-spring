package dev.ryan.dtos;

import dev.ryan.entities.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public
class AddRoleToUserForm {
    private String username;
    private Role role;
}
