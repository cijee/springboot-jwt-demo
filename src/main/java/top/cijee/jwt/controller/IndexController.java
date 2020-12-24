package top.cijee.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cijee
 * @version 1.0
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "hello security";
    }

    @GetMapping("/login")
    public String login() {
        return "hello";
    }

}
