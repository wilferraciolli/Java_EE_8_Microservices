
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveProductResponseMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductResponseMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://acme.com/schemes/common/v1}BaseMessageType">
 *       &lt;sequence>
 *         &lt;element name="product" type="{http://acme.com/schemes/ecommerce/v1}Product" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductResponseMessage", namespace = "http://acme.com/schemes/messages/v1", propOrder = {
    "product"
})
public class RetrieveProductResponseMessage
    extends BaseMessageType
{

    protected Product product;

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

}
