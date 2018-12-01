package unsl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unsl.entities.ResponseError;
import unsl.entities.User;
import unsl.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @param dni
     * @return
     */
    @GetMapping(value = "/users/search")
    @ResponseBody
    public Object searchUser(@RequestParam("dni") Long dni) {
        User user = userService.findByDni(dni);
        return buildResponse(user);
    }

    /**
     * @param userId
     * @return
     */
    @GetMapping(value = "/users/{userId}")
    @ResponseBody
    public Object getUser(@PathVariable("userId") Long userId) {
        User user = userService.getUser(userId);
        return buildResponse(user);
    }

    /**
     * @param User
     * @return
     */
    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Object createUser(@RequestBody User User) {
        return userService.saveUser(User);
    }

    /**
     * @param user
     * @return
     */
    private Object buildResponse(User user) {
        if ( user == null) {
            return new ResponseEntity(new ResponseError(404, "User not found"), HttpStatus.NOT_FOUND);
        }
        return user;
    }

}

