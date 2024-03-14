package education.shop.controllers;


import education.shop.entities.Dto.CartDto;
import education.shop.entities.Dto.ProductRespDto;
import education.shop.entities.Dto.UserRespDto;
import education.shop.entities.User;
import education.shop.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/users/operations")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //================================== User ops ======================================================================


    @PostMapping(path = "/logout/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserRespDto logout(@PathVariable String id){
        return userService.logout(id);
    }



    @GetMapping(path = "/users/{id}")
    public Optional<UserRespDto> findUserByID(@PathVariable String id){
        return userService.findUserByID(id);
    }


    @PatchMapping(path = "/users/{id}/{password}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Optional<UserRespDto>> newPassword(@PathVariable String id, @PathVariable String password){
        return userService.setNewPassword(id,password);
    }

    @GetMapping(path = "/products/{min}/{max}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRespDto> findProductByPriceBetween(@PathVariable double min, @PathVariable double max){
        return userService.findProductByPriceBetween(min,max);
    }


    @GetMapping(path = "/products/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRespDto> findByName(@PathVariable String name){
        return userService.findByName(name);
    }

    @GetMapping(path = "/products/{price}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRespDto> findProductByPrice(@PathVariable double price){
        return userService.findProductByPrice(price);
    }


    @GetMapping(path = "/products/{inStock}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductRespDto>> findProductInStock(@PathVariable boolean inStock){
        return userService.findProductInStock(inStock);
    }


    @PatchMapping(path = "/products/cart/{reference}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CartDto addProductToCart(@PathVariable String reference,@PathVariable String id){
        return userService.addProductToCart(reference,id);
    }


    @GetMapping(path = "/users/cart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CartDto myCart(@PathVariable String id){
        return userService.findUserCart(id);
    }






}
