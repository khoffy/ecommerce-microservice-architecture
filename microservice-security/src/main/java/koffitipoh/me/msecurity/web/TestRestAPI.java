package koffitipoh.me.msecurity.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestAPI {

    @GetMapping("/data-test")
    public Map<String, Object> dataTest(Authentication auth) {
        return Map.of("message", "Data test",
                "username", auth.getName(),
                "authorities", auth.getAuthorities()
        );
    }
}
