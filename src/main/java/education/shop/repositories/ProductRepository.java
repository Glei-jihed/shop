package education.shop.repositories;


import education.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>{

    Optional<Product> findProductByReference(String reference);

    List<Product> findProductByPrice(double price);

    List<Product> findProductByCategory(String category);

    List<Product> findProductByProductName(String name);

    List<Product> findProductByPriceBetween(double min,double max);

    List<Product> findProductByInStock(boolean exist);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:word%")
    List<Product> findProductByProductNameLike(@Param("word") String word);


}
