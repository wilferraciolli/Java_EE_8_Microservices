
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREDIT_CARD"/>
 *     &lt;enumeration value="PAYPAL"/>
 *     &lt;enumeration value="APPLE_PAY"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethodType")
@XmlEnum
public enum PaymentMethodType {

    CREDIT_CARD,
    PAYPAL,
    APPLE_PAY,
    OTHER;

    public String value() {
        return name();
    }

    public static PaymentMethodType fromValue(String v) {
        return valueOf(v);
    }

}
