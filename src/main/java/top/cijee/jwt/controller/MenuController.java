package top.cijee.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cijee
 * @version 1.0
 */
@RestController
public class MenuController {

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/menu")
    public String get() {
        return "menu";
    }
}
