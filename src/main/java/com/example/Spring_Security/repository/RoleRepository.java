package com.example.Spring_Security.repository;

import com.example.Spring_Security.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole,Long> {

    AppRole findByRoleName(String s);

}
