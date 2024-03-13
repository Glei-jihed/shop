package education.shop.services;


import education.shop.entities.Dto.ProductAdminRespDto;
import education.shop.entities.Dto.ProductDto;
import education.shop.entities.Product;
import education.shop.mappers.CartMapper;
import education.shop.mappers.ProductMapper;
import education.shop.mappers.UserMapper;
import education.shop.repositories.CartRepository;
import education.shop.repositories.ProductRepository;
import education.shop.repositories.UserRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final CartMapper cartMapper;


    public AdminService(UserRepository userRepository,
                        ProductRepository productRepository,
                        CartRepository cartRepository,
                        UserMapper userMapper,
                        ProductMapper productMapper,
                        CartMapper cartMapper
    ) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.cartMapper = cartMapper;
    }

    //=======================================   Product Ops   ==========================================================

    public ProductAdminRespDto addProduct(ProductDto productDto){
        Product product = productMapper.toProduct(productDto);
        productRepository.save(product);
        return productMapper.toProductAdminRespDto(product);
    }

    public List<ProductAdminRespDto> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductAdminRespDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductAdminRespDto> findProductById(String reference){
        Optional<Product> product = productRepository.findById(reference);
        return Optional.ofNullable( productMapper.toProductAdminRespDto(product.get()));
    }

    public ProductAdminRespDto updateProduct(ProductDto product){
        Product product1 = productMapper.toProduct(product);
        Product savedProduct = productRepository.save(product1);
        return productMapper.toProductAdminRespDto(savedProduct);
    }

    public void deleteProduct(String reference){
        Optional<Product> product = productRepository.findById(reference);
        productRepository.delete(product.get());
    }

    public List<ProductAdminRespDto> findProductInStock(boolean inStock){
        if (inStock){
            return productRepository.findProductByInStock(true)
                    .stream()
                    .map(productMapper::toProductAdminRespDto)
                    .collect(Collectors.toList());
        }
        return productRepository.findProductByInStock(false)
                .stream()
                .map(productMapper::toProductAdminRespDto)
                .collect(Collectors.toList());
    }


    public List<ProductAdminRespDto> findProductByCategory(String category){
        return productRepository.findProductByCategory(category)
                .stream()
                .map(productMapper::toProductAdminRespDto)
                .collect(Collectors.toList());
    }


    public List<ProductAdminRespDto> findProductByPrice(double price){
        return productRepository.findProductByPrice(price)
                .stream()
                .map(productMapper::toProductAdminRespDto)
                .collect(Collectors.toList());
    }

    public List<ProductAdminRespDto> findProductByPriceBetween(double min, double max){
        return productRepository.findProductByPriceBetween(min,max)
                .stream()
                .map(productMapper::toProductAdminRespDto)
                .collect(Collectors.toList());
    }

    public List<ProductAdminRespDto> findByName(String name){
        return productRepository.findProductByProductNameLike(name)
                .stream()
                .map(productMapper::toProductAdminRespDto)
                .collect(Collectors.toList());
    }


    //============================================== User Ops ==========================================================












}
