package com.checkoutcomponent.model.cart;

import com.checkoutcomponent.model.cart.state.CartState;
import com.checkoutcomponent.model.discount.Discount;
import com.checkoutcomponent.model.product.Product;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_ID", unique = true, nullable = false)
    private String customerId;

    @Enumerated(EnumType.STRING)
    //    @Type( type = "com.checkoutcomponent.model.cart.state.CartState",
    //            parameters = {
    //                    @Parameter( name = "enumClass", value =  "my.package.Status" ),
    //                    @Parameter( name = "identifierMethod", value = "toString" ),
    //                    @Parameter( name = "valueOfMethod", value = "fromString" ) } )
    private CartState cartState = CartState.OPEN;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE}, mappedBy = "carts")
    private List<Product> products = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE}, mappedBy = "carts")
    private List<Discount> discounts = new ArrayList<>();

    public Cart(@NotNull String customerId) {
        this.customerId = customerId;
    }
}