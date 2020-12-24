package top.cijee.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cijee.jwt.domain.UserAuth;
import top.cijee.jwt.service.UserAuthService;

import javax.annotation.Resource;

/**
 * @author CiJee
 * @version 1.0
 */
@RestController
@RequestMapping("/auth")
public class SecurityController {

    private final UserAuthService userAuthService;

    @Resource
    private UserDetailsService userDetailsService;

    public SecurityController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String username, String password) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("success");
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/get")
    public UserAuth getUse() {
        return userAuthService.findByName("root");
    }
}
