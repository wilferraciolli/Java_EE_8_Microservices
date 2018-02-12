package com.acme.services.beans.v1;

import com.acme.models.ProductEntity;
import com.acme.schemes.messages.v1.ECommerceError;
import com.acme.schemes.messages.v1.RetrieveProductRequestMessage;
import com.acme.schemes.messages.v1.RetrieveProductResponseMessage;
import com.acme.services.transformations.ProductTransformer;
import com.acme.services.types.ECommerceErrorFault;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Stateless
@Local(ProductsLocal.class)
@Remote(ProductsRemote.class)
public class ProductsSB implements ProductsLocal, ProductsRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public RetrieveProductResponseMessage retrieveProduct(RetrieveProductRequestMessage retrieveProductRequest)
            throws ECommerceErrorFault {

        if (retrieveProductRequest == null) {

            ECommerceError error = new ECommerceError();
            error.setCode("empty.body");
            error.setRef(UUID.randomUUID().toString());

            throw new ECommerceErrorFault(error);
        }

        ProductEntity productEntity = em.find(ProductEntity.class, retrieveProductRequest.getId());

        if (productEntity == null) {

            ECommerceError error = new ECommerceError();
            error.setCode("resource.not.found");
            error.setRef(UUID.randomUUID().toString());

            throw new ECommerceErrorFault(error);
        }

        RetrieveProductResponseMessage retrieveProductResponse = new RetrieveProductResponseMessage();
        retrieveProductResponse.setProduct(ProductTransformer.toProduct(productEntity));

        return retrieveProductResponse;
    }
}
