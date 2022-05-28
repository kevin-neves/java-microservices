package com.ecommerce.shopcart.controller;

import com.ecommerce.shopcart.model.Shop;
import com.ecommerce.shopcart.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;
//    private SendKafkaMessage sendKafkaMessage;

    @GetMapping
    public Page<Shop> getPurchaseList(Pageable pageable) {
        return shopService.listShopCart(pageable);
    }

    @PostMapping
    public Shop postPurchase(@RequestBody Shop shop) {
//        sendKafkaMessage.sendMessage(shop);
        return shopService.createShopCart(shop);
    }

}


