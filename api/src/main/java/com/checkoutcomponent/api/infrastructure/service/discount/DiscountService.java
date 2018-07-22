package com.checkoutcomponent.api.infrastructure.service.discount;

import com.checkoutcomponent.api.infrastructure.exception.CartNotFoundException;
import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.discount.Discount;
import com.checkoutcomponent.domain.model.product.Product;
import com.checkoutcomponent.domain.repository.cart.CartRepository;
import com.checkoutcomponent.domain.repository.discount.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private CartRepository cartRepository;

    public BigDecimal getDiscountsAmountForCustomerId(String customerId) throws CartNotFoundException {
        BigDecimal discountAmount = BigDecimal.ZERO;

        Cart customerCart = getCartForCustomerId(customerId);
        Map<Product, Long> customerProducts = getCustomerProducts(customerCart);

        List<Discount> availableDiscounts = getAvailableDiscountsSortedByAmount().collect(Collectors.toList());

        for (Discount discount : availableDiscounts) {
            Map<Product, Long> productsRequiredForDiscount = discount.getProducts();

            for (Map.Entry<Product, Long> productRequiredForDiscount : productsRequiredForDiscount.entrySet()) {
                for (Map.Entry<Product, Long> customerProduct : customerProducts.entrySet()) {
                    String customerProductId = customerProduct.getKey().getId();
                    Long customerProductAmount = customerProduct.getValue();

                    String productRequiredForDiscountId = productRequiredForDiscount.getKey().getId();
                    Long productAmountRequiredForDiscount = productRequiredForDiscount.getValue();

                    if (customerProductId.equals(productRequiredForDiscountId)) {
                        while (customerProductAmount >= productAmountRequiredForDiscount) {
                            customerProducts.remove(productRequiredForDiscount);
                            customerProductAmount = customerProductAmount - productAmountRequiredForDiscount;
                            discountAmount = discountAmount.add(discount.getDiscountAmount());
                        }
                    }
                }
            }
        }
        return discountAmount;
    }

    private Map<Product, Long> getCustomerProducts(Cart cart) {
        return cart.getProducts().stream()
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()));
    }

    private Stream<Discount> getAvailableDiscountsSortedByAmount() {
        List<Discount> availableDiscount = new ArrayList<>();
        discountRepository.findAll().forEach(availableDiscount::add);

        return availableDiscount.stream().sorted(Comparator.comparing(Discount::getDiscountAmount));
    }

    private Cart getCartForCustomerId(String customerId) throws CartNotFoundException {
        return cartRepository.findById(customerId)
                .orElseThrow(CartNotFoundException::new);
    }
}
