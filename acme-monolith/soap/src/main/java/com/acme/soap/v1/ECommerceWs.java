package com.acme.soap.v1;

import com.acme.schemes.messages.v1.RetrieveProductRequestMessage;
import com.acme.schemes.messages.v1.RetrieveProductResponseMessage;
import com.acme.services.beans.v1.ProductsLocal;
import com.acme.services.types.ECommerceErrorFault;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "ECommerce",
        targetNamespace = "http://acme.com/services/eCommerce/v1")
public class ECommerceWs {

    @EJB
    private ProductsLocal products;

    @WebMethod(operationName = "RetrieveProduct", action = "http://acme.com" +
            "/services/eCommerce/v1/RetrieveProduct")
    public RetrieveProductResponseMessage retrieveProduct(RetrieveProductRequestMessage retrieveProductRequest)
            throws ECommerceErrorFault {

        return products.retrieveProduct(retrieveProductRequest);
    }
}
