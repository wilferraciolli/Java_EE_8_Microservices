
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://acme.com/schemes/common/v1}BaseType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseMessageType", namespace = "http://acme.com/schemes/common/v1")
@XmlSeeAlso({
    RetrieveProductRequestMessage.class,
    RetrieveProductResponseMessage.class
})
public class BaseMessageType
    extends BaseType
{


}
