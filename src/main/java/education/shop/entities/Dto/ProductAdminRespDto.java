package education.shop.entities.Dto;

import education.shop.entities.ProductImage;

import java.util.Set;

public record ProductAdminRespDto(
        String reference,
        String productName,
        String description,
        boolean inStock,
        double price,
        Set<ProductImage> images,
        Integer numberInStock
) {
}
