package com.ecommerce.shopcart.service;

import com.ecommerce.shopcart.model.ShopCart;
import com.ecommerce.shopcart.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public Page<ShopCart> listShopCart(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    public ShopCart createShopCart(ShopCart shop) {
        return shopRepository.save(shop);
    }

    public ShopCart updateShopCart(ShopCart shopCart) {
        //Update an existing shopCart
        return shopRepository.save(shopCart);
    }
}
