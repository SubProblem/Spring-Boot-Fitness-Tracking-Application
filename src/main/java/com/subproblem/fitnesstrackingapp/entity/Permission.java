package com.subproblem.fitnesstrackingapp.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("read"),
    ADMIN_CREATE("create"),
    ADMIN_UPDATE("update"),
    ADMIN_DELETE("delete"),

    USER_READ("read"),
    USER_CREATE("create"),
    USER_UPDATE("update"),
    USER_DELETE("delete");

    private final String permission;

    public String getPermission() {
        return permission;
    }
}
