package ru.javaprojects.restaurant_vote_system.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role extends AbstractNamedEntity implements GrantedAuthority {
    public Role() {
    }

    public Role(String name) {
        super(name);
    }

    public Role(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
