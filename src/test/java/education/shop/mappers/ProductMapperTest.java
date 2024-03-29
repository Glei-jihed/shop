package education.shop.mappers;

import education.shop.entities.Dto.ProductAdminRespDto;
import education.shop.entities.Dto.ProductDto;
import education.shop.entities.Dto.ProductRespDto;
import education.shop.entities.Product;
import education.shop.entities.ProductImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        this.productMapper = new ProductMapper();
    }

    @Test
    void toProduct() {
        //Given
        ProductDto productDto = new ProductDto("05671","voiture","c'est une voiture",50,"Cars",25000,new HashSet<ProductImage>());

        //When
        Product product = productMapper.toProduct(productDto);

        //Then
        assertEquals(product.getReference(),productDto.reference());
        assertEquals(product.getProductName(),productDto.productName());
        assertEquals(productDto.numberInStock(),product.getNumberInStock());
        System.out.println("To product test done !");
    }

    @Test
    void toProductDto() {
        //Given
        Product product = new Product("075321",
                "car",
                "a car",
                "Cars",
                50,
                true,
                25000,
                new HashSet<ProductImage>(),
                new HashSet<>());


        //When
        ProductDto productDto = productMapper.toProductDto(product);

        //Then
        assertEquals(product.getProductName(),productDto.productName());
        assertEquals(product.getReference(),productDto.reference());
        assertEquals(product.getPrice(),productDto.price());
        System.out.println("To productDto Test done !");

    }

    @Test
    void toProductRespDto() {
        //Given
        Product product = new Product("075321",
                "car",
                "a car",
                "Cars",
                50,
                true,
                25000,
                new HashSet<ProductImage>(),
                new HashSet<>());

        //when
        ProductRespDto productRespDto =  productMapper.toProductRespDto(product);

        //Then
        assertEquals(product.getProductName(),productRespDto.productName());
        assertEquals(product.getReference(),productRespDto.reference());
        assertEquals(product.getPrice(),productRespDto.price());
        System.out.println("To productRespDto Test done !");

    }

    @Test
    void toProductAdminRespDto() {
        //Given
        Product product = new Product("075321",
                "car",
                "a car",
                "Cars",
                50,
                true,
                25000,
                new HashSet<ProductImage>(),
                new HashSet<>());

        //When
        ProductAdminRespDto dto = productMapper.toProductAdminRespDto(product);


        //Then
        assertEquals(product.getProductName(),dto.productName());
        assertEquals(product.getReference(),dto.reference());
        assertEquals(product.getPrice(),dto.price());
        System.out.println("To productAdminRespDto Test done !");





    }
}