package com.ecommerce.shopcart.kafka;

import com.ecommerce.shopcart.model.ShopCart;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendKafkaMessage {

    private final KafkaTemplate<String, ShopCart> kafkaTemplate;

    public void sendMessage(ShopCart shopCart) {
        kafkaTemplate.send("SHOPCART_TOPIC", shopCart);
    }
}
