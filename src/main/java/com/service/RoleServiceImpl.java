package com.service;

import com.model.entity.Role;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    public RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleIgnoreCase(String role){
        return roleRepository.findByRoleIgnoreCase(role);
    }
}