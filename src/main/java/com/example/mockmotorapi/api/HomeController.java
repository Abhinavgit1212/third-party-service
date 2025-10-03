package com.example.mockmotorapi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // Redirect root to Swagger UI
        return "redirect:/swagger-ui/index.html";
    }

    @RestController
    static class HealthController {
        @GetMapping("/health")
        public ResponseEntity<String> health() {
            return ResponseEntity.ok("OK");
        }
    }
}
