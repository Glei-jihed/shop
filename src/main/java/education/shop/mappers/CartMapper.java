package education.shop.mappers;


import education.shop.entities.Cart;
import education.shop.entities.Dto.CartDto;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {
    public CartDto toCartDto(Cart cart){
        return new CartDto(
          cart.getProducts()
        );
    }
}
