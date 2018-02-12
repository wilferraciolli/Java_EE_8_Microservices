package com.acme.services.beans.v1;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(OrdersLocal.class)
@Remote(OrdersRemote.class)
public class OrdersSB implements OrdersLocal, OrdersRemote {
}
