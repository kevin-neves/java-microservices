package com.ecommerce.shopcart.controller;

import com.ecommerce.shopcart.kafka.SendKafkaMessage;
import com.ecommerce.shopcart.model.ShopCart;
import com.ecommerce.shopcart.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;
    private final SendKafkaMessage sendKafkaMessage;

    @GetMapping
    public Page<ShopCart> getPurchaseList(Pageable pageable) {
        return shopService.listShopCart(pageable);
    }

    @PostMapping
    public ShopCart postPurchase(@RequestBody ShopCart shop) {
        shop.setStatus("CRIADA");
        sendKafkaMessage.sendMessage(shop);
        return shopService.createShopCart(shop);
    }

}


