package com.islol.hyopgg.role.repository;

import com.islol.hyopgg.role.entity.Role;
import com.islol.hyopgg.role.enums.RoleNm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleNm(RoleNm user);
}
