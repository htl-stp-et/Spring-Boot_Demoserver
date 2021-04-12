package at.ac.htlstp.s2020.k5bhet.demoserver.controller;

import at.ac.htlstp.s2020.k5bhet.demoserver.config.Endpoints;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Für eine Kommunikation Server zu Server
 */
@RestController
public class BaseController {

    @GetMapping(Endpoints.ping)
    public ResponseEntity<String> pingGet()  {
        return ResponseEntity.ok("pong");
    }

    @PostMapping(Endpoints.ping)
    public ResponseEntity<String> pingPost()  {
        return ResponseEntity.ok("pong");
    }

}
