package at.ac.htlstp.s2020.k5bhet.demoserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class BaseController {

    @GetMapping("/ping")
    public ResponseEntity<String> pingGet()  {
        return ResponseEntity.ok("pong");
    }

    @PostMapping("/ping")
    public ResponseEntity<String> pingPost()  {
        return ResponseEntity.ok("pong");
    }

}
