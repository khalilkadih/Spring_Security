package com.example.Spring_Security.dao;

import com.example.Spring_Security.domain.AppRole;
import com.example.Spring_Security.domain.AppUser;
import com.example.Spring_Security.repository.RoleRepository;
import com.example.Spring_Security.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class Userdata {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Userdata(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    private final static List<UserDetails> USER_APPLICATION= Arrays.asList(
            new User("khalil@gmail.com","khalil", Collections.singleton(new SimpleGrantedAuthority("ADMIN"))),
            new User("omar@gmail.com","omar", Collections.singleton(new SimpleGrantedAuthority("USER"))),
            new User("omar@gmail.com","omar", Collections.singleton(new SimpleGrantedAuthority("Fournisseur")))
    );

    public UserDetails findUserByEmail(String email){
        return  USER_APPLICATION.stream().filter(
                userDetails -> userDetails.getUsername().equals(email)).findFirst()
                .orElseThrow(()->new UsernameNotFoundException("No user Was Found"));
    }


    public AppUser addNewUser(AppUser user) {
        String password=user.getPassword();
        return userRepository.save(user);
    }


    public AppRole addNewRole(AppRole appRole) {
        return roleRepository.save(appRole);
    }

    public void addRoleToUser(String userName, String roleName) {

        AppRole appRole=roleRepository.findByRoleName(roleName);
        AppUser appUser =userRepository.findByUserName(userName);
        appUser.getRoles().add(appRole);
    }
    public List<AppUser> users() {
        return userRepository.findAll();
    }



}
