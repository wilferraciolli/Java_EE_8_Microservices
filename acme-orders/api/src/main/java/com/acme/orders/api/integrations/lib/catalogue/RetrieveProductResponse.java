
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveProductResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://acme.com/schemes/messages/v1}RetrieveProductResponseMessage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductResponse", namespace = "http://acme.com/services/eCommerce/v1", propOrder = {
    "_return"
})
public class RetrieveProductResponse {

    @XmlElement(name = "return", namespace = "")
    protected RetrieveProductResponseMessage _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveProductResponseMessage }
     *     
     */
    public RetrieveProductResponseMessage getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveProductResponseMessage }
     *     
     */
    public void setReturn(RetrieveProductResponseMessage value) {
        this._return = value;
    }

}
