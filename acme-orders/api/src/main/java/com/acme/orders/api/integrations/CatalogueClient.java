/**
 * (c) Midland Software Limited 2018
 * Name     : CatalogueClient.java
 * Author   : ferraciolliw
 * Date     : 12 Feb 2018
 */
package com.acme.orders.api.integrations;

import com.acme.orders.api.integrations.lib.catalogue.Product;

/**
 * The interface Catalogue client. Integration class to integrate with Monolith catalogue service.
 */
public interface CatalogueClient {

    /**
     * Find by product id product.
     * @param id the id
     * @return the product
     */
    Product findByProductId(String id);
}
