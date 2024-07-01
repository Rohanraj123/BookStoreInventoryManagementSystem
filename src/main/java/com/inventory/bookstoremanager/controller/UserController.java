package com.inventory.bookstoremanager.controller;

import com.inventory.bookstoremanager.dto.RegisterDTO;
import com.inventory.bookstoremanager.entity.Roles;
import com.inventory.bookstoremanager.entity.UserEntity;
import com.inventory.bookstoremanager.repository.RoleRepository;
import com.inventory.bookstoremanager.repository.UserRepository;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        if (userRepository.existsByUserName(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setUserName(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode((registerDTO.getPassword())));

        Optional<Roles> optionalRole = roleRepository.findByName("USER");
        if (optionalRole.isPresent()) {
            user.setRoles(Collections.singletonList(optionalRole.get()));
        } else {
            return new ResponseEntity<>("Role not found!", HttpStatus.BAD_REQUEST);
        }

        userRepository.save(user);

        return new ResponseEntity<>("User registered success", HttpStatus.OK);
    }

}
