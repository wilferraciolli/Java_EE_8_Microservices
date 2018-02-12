
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://acme.com/schemes/messages/v1}RetrieveProductRequestMessage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProduct", namespace = "http://acme.com/services/eCommerce/v1", propOrder = {
    "arg0"
})
public class RetrieveProduct {

    @XmlElement(namespace = "")
    protected RetrieveProductRequestMessage arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveProductRequestMessage }
     *     
     */
    public RetrieveProductRequestMessage getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveProductRequestMessage }
     *     
     */
    public void setArg0(RetrieveProductRequestMessage value) {
        this.arg0 = value;
    }

}
