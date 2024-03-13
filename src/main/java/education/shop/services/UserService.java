package education.shop.services;


import education.shop.entities.Cart;
import education.shop.entities.Dto.*;
import education.shop.entities.Product;
import education.shop.entities.User;
import education.shop.mappers.CartMapper;
import education.shop.mappers.ProductMapper;
import education.shop.mappers.UserMapper;
import education.shop.repositories.CartRepository;
import education.shop.repositories.ProductRepository;
import education.shop.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class  UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final CartMapper cartMapper;

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, CartMapper cartMapper, CartRepository cartRepository, ProductRepository productRepository, ProductMapper productMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.cartMapper = cartMapper;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    //=========================== User functions =======================================================================


    public Optional<UserRespDto> findUserByID(String id){
        Optional<User> user = userRepository.findById(id);
        return Optional.ofNullable(userMapper.toUserRespDto(user.get()));
    }

    public ResponseEntity<Optional<UserRespDto>> setNewPassword(String id, String password){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user.get().setPassword(password);
        User savedUser = userRepository.save(user.get());
        return new ResponseEntity<>(Optional.ofNullable(userMapper.toUserRespDto(savedUser)),HttpStatus.OK);
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

    public CartDto addProductToCart(String reference,String id){
        Optional<Product> product = productRepository.findById(reference);
        Optional<User> user = userRepository.findById(id);
        Optional<Cart> cart = cartRepository.findCartByUserId(id);
        cart.get().getProducts().add(product.get());
        product.get().setNumberInStock(product.get().getNumberInStock()-1);
        return cartMapper.toCartDto(cart.get());
    }

    public CartDto findUserCart(String id){
        Optional<Cart> cart = cartRepository.findCartByUserId(id);
        return cartMapper.toCartDto(cart.get());
    }





}
