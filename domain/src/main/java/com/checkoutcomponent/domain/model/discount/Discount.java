package com.checkoutcomponent.domain.model.discount;

import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "ID", referencedColumnName = "ID")})
    @ManyToMany(targetEntity = Product.class, fetch = FetchType.LAZY)
//    @MapKey(name = "discounts")
    private Map<Integer, Product> products = new HashMap<>();

    @NotNull
    private BigDecimal discountAmount;

    @ManyToMany
    private List<Cart> carts;
}
