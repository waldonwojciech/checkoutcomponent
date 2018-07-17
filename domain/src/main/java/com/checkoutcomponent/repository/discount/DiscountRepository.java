package com.checkoutcomponent.repository.discount;

import com.checkoutcomponent.model.discount.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {
}
