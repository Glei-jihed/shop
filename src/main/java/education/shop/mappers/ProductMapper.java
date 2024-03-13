package education.shop.mappers;


import education.shop.entities.Dto.ProductDto;
import education.shop.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductDto dto){
        var product = new Product();
        product.setProductName(dto.productName());
        product.setReference(dto.reference());
        product.setDescription(dto.description());
        product.setImages(dto.images());
        product.setNumberInStock(dto.numberInStock());
        product.setPrice(dto.price());
        return product;
    }

    public ProductDto productDto(Product product){
        return new ProductDto(
                product.getReference(),
                product.getProductName(),
                product.getDescription(),
                product.getNumberInStock(),
                product.getPrice(),
                product.getImages()
        );
    }

}
