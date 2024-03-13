package education.shop.controllers;


import education.shop.entities.Dto.UserRespDto;
import education.shop.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users/operations")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //================================== User ops ======================================================================

    @GetMapping(path = "/users/{id}")
    public Optional<UserRespDto> findUserByID(@PathVariable String id){
        return userService.findUserByID(id);
    }
}
