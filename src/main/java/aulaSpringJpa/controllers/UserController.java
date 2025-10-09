package aulaSpringJpa.controllers;

import aulaSpringJpa.entities.User;
import aulaSpringJpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<List<User>> findAll(){

        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
