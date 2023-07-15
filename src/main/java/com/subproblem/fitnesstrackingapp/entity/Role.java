package com.subproblem.fitnesstrackingapp.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;

import static com.subproblem.fitnesstrackingapp.entity.Permission.*;


@RequiredArgsConstructor
@Getter
public enum Role {

    USER(
            Set.of(
                    USER_CREATE,
                    USER_UPDATE,
                    USER_READ,
                    USER_DELETE
            )
    ),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_CREATE,
                    ADMIN_DELETE,
                    ADMIN_UPDATE,
                    USER_CREATE,
                    USER_UPDATE,
                    USER_READ,
                    USER_DELETE
            )
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = new java.util.ArrayList<>(permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
