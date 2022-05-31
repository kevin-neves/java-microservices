package com.ecommerce.shopcart.kafka;

import com.ecommerce.shopcart.model.ShopCart;
import com.ecommerce.shopcart.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {

    private final ShopService shopService;

    @KafkaListener(topics = "SHOPCART_TOPIC_RESPONSE", groupId = "group-1")
    public void listenTopic(ShopCart shopCart) {
        shopService.updateShopCart(shopCart);
    }
}
