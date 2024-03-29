package education.shop.entities.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import education.shop.entities.ProductImage;
import jakarta.validation.constraints.*;

import java.util.Set;

public record ProductDto(
        @NotEmpty(message = "The reference should not be empty !")
        String reference,

        @NotEmpty(message = "The product must have a name !")
        String productName,


        @Size(min = 5,max = 255,message = "The product should have a description between 5 and 255 chars !")
        String description,

        @PositiveOrZero
        Integer numberInStock,

        @NotEmpty(message = "The product should have a category !")
        String category,

        @PositiveOrZero
        double price,

        @NotEmpty(message = "you must set some pictures link !")
        Set<ProductImage> images
) {
}
