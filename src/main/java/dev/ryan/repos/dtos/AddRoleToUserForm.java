package dev.ryan.repos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public
class AddRoleToUserForm {
    private String username;
    private String roleName;
}
