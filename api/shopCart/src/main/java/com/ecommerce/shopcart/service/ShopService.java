package com.ecommerce.shopcart.service;

import com.ecommerce.shopcart.model.Shop;
import com.ecommerce.shopcart.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository ShopRepository;

    public Page<Shop> listShopCart(Pageable pageable) {
        return ShopRepository.findAll(pageable);
    }

    public Shop createShopCart(Shop shop) {
        return ShopRepository.save(shop);
    }

}
