package education.shop.entities.Dto;

import education.shop.entities.Product;

import java.util.Set;

public record CartDto(
        Set<Product> products

) {
}
