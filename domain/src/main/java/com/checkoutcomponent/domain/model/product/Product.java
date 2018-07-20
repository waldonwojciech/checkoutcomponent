package com.checkoutcomponent.domain.model.product;

import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.discount.Discount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany
    private List<Cart> carts;

//    @ManyToMany
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
//    @JoinTable(
//            name = "DISCOUNT",
//            joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID")})
////            inverseJoinColumns={@JoinColumn(name="ID", referencedColumnName="ID")})
    private Discount discount;

    public Product(@NotNull String name) {
        this.name = name;
    }
}
