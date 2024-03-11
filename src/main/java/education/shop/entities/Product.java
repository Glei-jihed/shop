package education.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {


    @Id
    @Column(nullable = false)
    private String reference;


    @Column(nullable = false)
    private String productName;


    @Column(nullable = false)
    private String description;


    @Column()
    private Integer numberInStock;

    @Column
    private boolean inStock;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<Cart> carts;




}
