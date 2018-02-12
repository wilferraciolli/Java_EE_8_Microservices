package com.acme.services.beans.v1;

import com.acme.schemes.messages.v1.RetrieveProductRequestMessage;
import com.acme.schemes.messages.v1.RetrieveProductResponseMessage;
import com.acme.services.types.ECommerceErrorFault;

public interface ProductsLocal {

    RetrieveProductResponseMessage retrieveProduct(RetrieveProductRequestMessage retrieveProductRequest) throws ECommerceErrorFault;

    /////////
}
