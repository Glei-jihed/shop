package education.shop.entities.Dto;

import education.shop.entities.ProductImage;

import java.util.Set;

public record ProductDtoRespForAdmin(
        String reference,
        String productName,

        String description,

        boolean inStock,

        Integer numberInStock,

        double price,

        Set<ProductImage> images
) {
}
