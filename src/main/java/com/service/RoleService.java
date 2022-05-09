package com.service;

import com.model.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional <Role> findByRoleIgnoreCase (String role);
}
