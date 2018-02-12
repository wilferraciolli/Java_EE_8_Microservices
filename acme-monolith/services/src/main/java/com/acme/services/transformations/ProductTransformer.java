package com.acme.services.transformations;

import com.acme.models.ProductEntity;
import com.acme.schemes.ecommerce.v1.Product;

public class ProductTransformer {

    public static Product toProduct(ProductEntity entity) {

        if (entity == null) return null;

        Product product = new Product();
        product.setId(entity.getId());
        product.setTitle(entity.getTitle());
        product.setPrice(entity.getPrice());
        product.setCurrency(entity.getCurrency());

        return product;
    }
}
