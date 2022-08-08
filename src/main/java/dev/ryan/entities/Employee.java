package dev.ryan.entities;

import dev.ryan.config.Role;
import lombok.*;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String username;

    @Column(length = 60)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}