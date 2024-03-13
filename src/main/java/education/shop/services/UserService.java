package education.shop.services;


import education.shop.entities.User;
import education.shop.mappers.ProductMapper;
import education.shop.mappers.UserMapper;
import education.shop.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final ProductMapper productMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, ProductMapper productMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
    }






}
