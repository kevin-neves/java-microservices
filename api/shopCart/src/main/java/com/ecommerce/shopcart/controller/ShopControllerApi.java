package com.ecommerce.shopcart.controller;

import com.ecommerce.shopcart.model.ShopCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "shop-cart-api")
public interface ShopControllerApi {

    @GetMapping
    Page<ShopCart> getPurchaseList(Pageable pageable);

    @PostMapping
    ShopCart postPurchase(@RequestBody ShopCart shop);

}
