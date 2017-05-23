package by.kraskovski.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
    @RequestMapping("/secured")
    public String securedApi() {
        return "Hello World";
    }
}
