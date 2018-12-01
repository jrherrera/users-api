package unsl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unsl.entities.User;
import unsl.services.UserService;

import static unsl.utils.Responses.NOT_FOUND_BODY;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users/search")
    @ResponseBody
    public Object searchUser(@RequestParam("dni") Long dni) {
        User user = userService.findByDni(dni);
        return buildResponse(user);
    }

    @GetMapping(value = "/users/{userId}")
    @ResponseBody
    public Object getUser(@PathVariable("userId") Long userId) {
        User user = userService.getUser(userId);
        return buildResponse(user);
    }

    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Object createUser(@RequestBody User User) {
        User user = userService.saveUser(User);
        return buildResponse(user);
    }

    /**
     * @param user
     * @return
     */
    private Object buildResponse(User user) {
        if ( user == null) {
            return new ResponseEntity(NOT_FOUND_BODY, HttpStatus.NOT_FOUND);
        }
        return user;
    }

}

