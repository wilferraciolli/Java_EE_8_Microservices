/**
 * (c) Midland Software Limited 2018
 * Name     : CatalogueClientImpl.java
 * Author   : ferraciolliw
 * Date     : 12 Feb 2018
 */
package com.acme.orders.api.integrations.imp;

import java.net.MalformedURLException;
import java.net.URL;

import com.acme.orders.api.integrations.CatalogueClient;
import com.acme.orders.api.integrations.lib.catalogue.ECommerce;
import com.acme.orders.api.integrations.lib.catalogue.ECommerceErrorFault_Exception;
import com.acme.orders.api.integrations.lib.catalogue.ECommerceWsService;
import com.acme.orders.api.integrations.lib.catalogue.Product;
import com.acme.orders.api.integrations.lib.catalogue.RetrieveProductRequestMessage;
import com.acme.orders.api.integrations.lib.catalogue.RetrieveProductResponseMessage;
import com.acme.orders.api.services.exceptions.GeneralServiceException;
import com.acme.orders.api.services.exceptions.ResourceNotFoundException;

/**
 * The type Catalogue client implementation.
 */
public class CatalogueClientImpl implements CatalogueClient{

    private ECommerce port;

    /**
     * Instantiates a new Catalogue client.
     * @param wsdl the wsdl
     */
    public CatalogueClientImpl(String wsdl) {
        try {
            //instantiate new client to make SOAP calls
            URL wsdlUrl = new URL(wsdl);
            ECommerceWsService service = new ECommerceWsService(wsdlUrl);

            port = service.getECommercePort();
        } catch (MalformedURLException e) {
            throw new GeneralServiceException(e);
        }
    }

    @Override public Product findByProductId(final String id) {
        //call the service
        try {
            RetrieveProductRequestMessage retrieveProductRequestMessage = new RetrieveProductRequestMessage();
            retrieveProductRequestMessage.setId(Long.valueOf(id));

            RetrieveProductResponseMessage response = port.retrieveProduct(retrieveProductRequestMessage);

            return response.getProduct();
        } catch (ECommerceErrorFault_Exception e) {
         String code = e.getFaultInfo().getFault().getCode();

         switch (code){
         case "resource.not.found":
             throw new ResourceNotFoundException(Product.class.getSimpleName(), id);
         }

         throw  new GeneralServiceException(e);
        }
    }
}
