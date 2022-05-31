package com.ecommerce.shopvalidator.kafka;

import com.ecommerce.shopcart.model.Product;
import com.ecommerce.shopcart.model.ShopCart;
import com.ecommerce.shopvalidator.dto.CustomerResponse;
import com.ecommerce.shopvalidator.dto.ProductResponse;
import com.ecommerce.shopvalidator.service.CustomerService;
import com.ecommerce.shopvalidator.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {

    private final SendKafkaMessage sendKafkaMessage;

    @KafkaListener(topics = "SHOPCART_TOPIC", groupId = "group-1")
    public void listenTopic(ShopCart shopCart) {

        System.out.println("Received shop list: " + shopCart.getProducts().stream().map(p -> p.getName())
                .collect(java.util.stream.Collectors.joining(", ")));
        System.out.println("Status: " + shopCart.getStatus());

        CustomerResponse customerResponse = CustomerService.getCustomer(shopCart.getCpfCustomer());
        if (customerResponse == null && customerResponse.getCpf() != null || !customerResponse.getCpf().equals(shopCart.getCpfCustomer())) {
            throw new RuntimeException("Client not found.");
        }

        Float valorTotal = 0F;
        for (Product product : shopCart.getProducts()) {
            ProductResponse productResponse = ProductService.getProduto(product.getProductIdReference());
            if (productResponse == null) {
                throw new RuntimeException("Produto invalido.");
            }
            valorTotal += productResponse.getPrice().floatValue() * product.getQuantity();
        }
        shopCart.setTotal(valorTotal.doubleValue());
        shopCart.setStatus("PROCESSADA");

        System.out.println("Compra processada: " + "Customer CPF: " + shopCart.getCpfCustomer() + " " + shopCart.getTotal());
        sendKafkaMessage.sendMessage(shopCart);
    }
}
