
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SupplierStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SupplierStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="INACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SupplierStatus")
@XmlEnum
public enum SupplierStatus {

    ACTIVE,
    INACTIVE;

    public String value() {
        return name();
    }

    public static SupplierStatus fromValue(String v) {
        return valueOf(v);
    }

}
