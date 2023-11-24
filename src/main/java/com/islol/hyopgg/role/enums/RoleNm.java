package com.islol.hyopgg.role.enums;

public enum RoleNm {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String roleName;

    RoleNm(String roleName) {
        this.roleName = roleName;
    }

    public String getRole() {
        return roleName;
    }
}
