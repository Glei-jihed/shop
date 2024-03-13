package education.shop.entities.Dto;

import education.shop.entities.ProductImage;

import java.util.Set;

public record ProductRespDto(
        String reference,
        String productName,

        String description,

        boolean inStock,

        double price,

        String category,

        Set<ProductImage> images
) {
}
