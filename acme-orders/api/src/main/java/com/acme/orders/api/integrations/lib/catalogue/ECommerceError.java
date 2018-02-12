
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ECommerceError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ECommerceError">
 *   &lt;complexContent>
 *     &lt;extension base="{http://acme.com/schemes/common/v1}BaseErrorType">
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
@XmlType(name = "ECommerceError", namespace = "http://acme.com/schemes/messages/v1")
public class ECommerceError
    extends BaseErrorType
{


}
