package com.example.Spring_Security.repository;

import com.example.Spring_Security.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
    //public Optional<AppUser> findByEmail(String email);
}
