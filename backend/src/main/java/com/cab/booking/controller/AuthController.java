package com.cab.booking.controller;

import com.cab.booking.entity.User;
import com.cab.booking.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        if (repo.existsByEmail(u.getEmail()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already registered");
        if (!"DRIVER".equals(u.getRole())) u.setRole("USER"); // nobody can self-register as admin
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> body) {
        User u = repo.findByEmail(body.get("email"))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));
        if (!encoder.matches(body.get("password"), u.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        return u;
    }
}
