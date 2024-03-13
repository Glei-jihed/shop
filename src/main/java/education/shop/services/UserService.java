package education.shop.services;


import education.shop.entities.Dto.ProductAdminRespDto;
import education.shop.entities.Dto.ProductRespDto;
import education.shop.entities.Dto.UserRespDto;
import education.shop.entities.Dto.UserRespForAdmin;
import education.shop.entities.User;
import education.shop.mappers.ProductMapper;
import education.shop.mappers.UserMapper;
import education.shop.repositories.ProductRepository;
import education.shop.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class  UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, ProductRepository productRepository, ProductMapper productMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    //=========================== User functions =======================================================================


    public Optional<UserRespDto> findUserByID(String id){
        Optional<User> user = userRepository.findById(id);
        return Optional.ofNullable(userMapper.toUserRespDto(user.get()));
    }

    public Optional<UserRespDto> setNewPassword(String id, String password){
        Optional<User> user = userRepository.findById(id);
        user.get().setPassword(password);
        User savedUser = userRepository.save(user.get());
        return Optional.ofNullable(userMapper.toUserRespDto(savedUser));
    }

    public List<ProductRespDto> findProductByPriceBetween(double min, double max){
        return productRepository.findProductByPriceBetween(min,max)
                .stream()
                .map(productMapper::toProductRespDto)
                .collect(Collectors.toList());
    }

    public List<ProductRespDto> findByName(String name){
        return productRepository.findProductByProductNameLike(name)
                .stream()
                .map(productMapper::toProductRespDto)
                .collect(Collectors.toList());
    }

    public List<ProductRespDto> findProductByCategory(String category){
        return productRepository.findProductByCategory(category)
                .stream()
                .map(productMapper::toProductRespDto)
                .collect(Collectors.toList());
    }


    public List<ProductRespDto> findProductByPrice(double price){
        return productRepository.findProductByPrice(price)
                .stream()
                .map(productMapper::toProductRespDto)
                .collect(Collectors.toList());
    }

    public List<ProductRespDto> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductRespDto)
                .collect(Collectors.toList());
    }


    public ResponseEntity<List<ProductRespDto>> findProductInStock(boolean inStock){
            List<ProductRespDto> products = productRepository.findProductByInStock(true)
                    .stream()
                    .map(productMapper::toProductRespDto)
                    .collect(Collectors.toList());
            if(products.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<>(products,HttpStatus.OK);
    }





}
