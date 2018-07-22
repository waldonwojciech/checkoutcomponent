package com.checkoutcomponent.domain.model.discount;

import com.checkoutcomponent.domain.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discount implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyJoinColumn(name="ID")
    private Map<Product, Long> products = new HashMap<>();

    @NotNull
    private BigDecimal discountAmount = BigDecimal.ZERO;
}
