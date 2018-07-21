package com.checkoutcomponent.domain.repository.discount;

import com.checkoutcomponent.domain.model.discount.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, String> {
}
