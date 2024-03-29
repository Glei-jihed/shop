package education.shop.services;

import education.shop.mappers.CartMapper;
import education.shop.mappers.ProductMapper;
import education.shop.mappers.UserMapper;
import education.shop.repositories.CartRepository;
import education.shop.repositories.ProductRepository;
import education.shop.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    // which service we want to test
    @InjectMocks
    private UserService userService;


    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private CartMapper cartMapper;
    @Mock
    private CartRepository cartRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void setNewPassword() {

    }

    @Test
    void findByName() {
    }

    @Test
    void addProductToCart() {
    }

    @Test
    void findUserCart() {
    }

    @Test
    void logout() {
    }
}