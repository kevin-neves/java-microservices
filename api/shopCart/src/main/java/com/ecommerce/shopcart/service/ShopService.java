package com.ecommerce.shopcart.service;

import com.ecommerce.shopcart.model.Product;
import com.ecommerce.shopcart.model.ShopCart;
import com.ecommerce.shopcart.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public Page<ShopCart> listShopCart(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    public ShopCart createShopCart(ShopCart shop) {
        ShopCart shopCart = new ShopCart().builder()
                    .cpfCustomer(shop.getCpfCustomer())
                    .id(shop.getId())
                    .status(shop.getStatus())
                    .build();
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : shop.getProducts()) {
            products.add(new Product(product.getId(),
                    product.getProductIdReference(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    shopCart));
        }
        shopCart.setProducts(products);
        return shopRepository.save(shopCart);
    }

    public ShopCart updateShopCart(ShopCart shopCart) {
        return shopRepository.save(shopCart);
    }
}
