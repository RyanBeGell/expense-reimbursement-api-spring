package dev.ryan.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public
class AddRoleToUserForm {
    private String username;
    private String roleName;
}
