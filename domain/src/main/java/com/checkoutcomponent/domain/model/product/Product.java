package com.checkoutcomponent.domain.model.product;

import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.discount.Discount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "DISCOUNT_ID", referencedColumnName = "ID")
    private Discount discount;

    private BigDecimal price;

    public Product(@NotNull String name, @NotNull BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
