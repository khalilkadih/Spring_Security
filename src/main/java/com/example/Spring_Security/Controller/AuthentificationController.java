package com.example.Spring_Security.Controller;

import com.example.Spring_Security.config.JwtUtil;
import com.example.Spring_Security.dao.Userdata;
import com.example.Spring_Security.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthentificationController {

    private final AuthenticationManager authenticationManager;
    private final Userdata userdata;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        final UserDetails userDetails=userdata.findUserByEmail(authenticationRequest.getEmail());
        System.out.println("khalil"+userDetails.toString());

        if(userDetails !=null){
            return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
        }
        return ResponseEntity.status(400).body("Error ,Something Happeng !!");

    }
}

