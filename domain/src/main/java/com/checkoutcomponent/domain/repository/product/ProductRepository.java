package com.checkoutcomponent.domain.repository.product;

import com.checkoutcomponent.domain.model.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
