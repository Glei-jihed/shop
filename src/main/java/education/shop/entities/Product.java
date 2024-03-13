package education.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
    @Column(nullable = false,unique = true)
    private String reference;


    @Column(nullable = false)
    private String productName;


    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;


    @Column(nullable = false)
    private Integer numberInStock;

    @Column(nullable = false)
    private boolean inStock;

    @Column(nullable = false)
    private double price;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<ProductImage> images;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<Cart> carts;

    //=========================================== Pre persist ==========================================================


    @PrePersist
    @PreUpdate
    public void prePersist(){
        this.inStock = this.numberInStock != 0;
    }




}
