package com.acme.services.beans.v1;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(PaymentsLocal.class)
@Remote(PaymentsRemote.class)
public class PaymentsSB implements PaymentsLocal, PaymentsRemote {
}
