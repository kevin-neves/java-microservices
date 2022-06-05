package com.ecommerce.product.controller;

import com.ecommerce.product.dto.request.ProductRequest;
import com.ecommerce.product.dto.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product")
public interface ProductApi {

    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public Page<ProductResponse> getProducts(Pageable pageable);

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public ProductResponse getProduct(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public ProductResponse postProduct(@RequestBody ProductRequest productRequest);
}
