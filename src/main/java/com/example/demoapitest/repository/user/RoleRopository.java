package com.example.demoapitest.repository.user;


import com.example.demoapitest.common.ERole;
import com.example.demoapitest.entities.user.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRopository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByName(ERole name);
}
