package com.checkoutcomponent.domain.model.cart;

import com.checkoutcomponent.domain.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart implements Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private String customerId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CART_PRODUCTS",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private List<Product> products = new ArrayList<>();

    public Cart(@NotNull String customerId) {
        this.customerId = customerId;
    }
}
