/**
 * (c) Midland Software Limited 2018
 * Name     : CatalogueClientMock.java
 * Author   : ferraciolliw
 * Date     : 14 Apr 2018
 */
package com.acme.orders.api.integrations.mock;

import java.math.BigDecimal;

import com.acme.orders.api.integrations.CatalogueClient;
import com.acme.orders.api.integrations.lib.catalogue.Product;

/**
 * The type Catalogue client mock. This class is to mock the monolith SOAP web services from the catalogue server on port 9080.
 */
public class CatalogueClientMock implements CatalogueClient {

    @Override
    public Product findByProductId(final String id) {
        Product product = new Product();
        product.setId(100L);
        product.setCurrency("EUR");
        product.setPrice(new BigDecimal(9.99));
        product.setTitle("Gift Card");

        return product;
    }
}
