package com.acme.services.types;

import com.acme.schemes.messages.v1.ECommerceError;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECommerceErrorFault")
public class ECommerceErrorFault extends Exception implements Serializable {

    private final static long serialVersionUID = 1L;

    private ECommerceError fault;

    public ECommerceErrorFault() {
    }

    public ECommerceErrorFault(ECommerceError fault) {
        this.fault = fault;
    }

    public ECommerceError getFault() {
        return fault;
    }
}
