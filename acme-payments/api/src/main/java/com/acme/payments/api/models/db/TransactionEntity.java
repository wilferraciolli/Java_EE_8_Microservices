package com.acme.payments.api.models.db;

import com.acme.payments.api.models.db.common.BaseEntity;
import com.acme.payments.lib.PaymentMethodType;
import com.acme.payments.lib.TransactionStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * The type Transaction entity. This bean maps a java object onto the transaction database table.
 */
@Entity
@Table(name = "transactions")
public class TransactionEntity extends BaseEntity {

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "nonce")
    private String nonce;

    @Column(name = "status")
    private TransactionStatus status;

    @Column(name = "gateway_decline_code")
    private String gatewayDeclineCode;

    @Column(name = "processor_response_code")
    private String processorResponseCode;

    @Column(name = "processor_response_text")
    private String processorResponseText;

    @Column(name = "payment_method_type")
    private PaymentMethodType paymentMethodType;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "gateway_transaction_id")
    private String gatewayTransactionId;

    /**
     * Gets currency.
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets amount.
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     * @param amount the amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets nonce.
     * @return the nonce
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * Sets nonce.
     * @param nonce the nonce
     */
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    /**
     * Gets status.
     * @return the status
     */
    public TransactionStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     * @param status the status
     */
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    /**
     * Gets gateway decline code.
     * @return the gateway decline code
     */
    public String getGatewayDeclineCode() {
        return gatewayDeclineCode;
    }

    /**
     * Sets gateway decline code.
     * @param gatewayDeclineCode the gateway decline code
     */
    public void setGatewayDeclineCode(String gatewayDeclineCode) {
        this.gatewayDeclineCode = gatewayDeclineCode;
    }

    /**
     * Gets processor response code.
     * @return the processor response code
     */
    public String getProcessorResponseCode() {
        return processorResponseCode;
    }

    /**
     * Sets processor response code.
     * @param processorResponseCode the processor response code
     */
    public void setProcessorResponseCode(String processorResponseCode) {
        this.processorResponseCode = processorResponseCode;
    }

    /**
     * Gets processor response text.
     * @return the processor response text
     */
    public String getProcessorResponseText() {
        return processorResponseText;
    }

    /**
     * Sets processor response text.
     * @param processorResponseText the processor response text
     */
    public void setProcessorResponseText(String processorResponseText) {
        this.processorResponseText = processorResponseText;
    }

    /**
     * Gets payment method type.
     * @return the payment method type
     */
    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    /**
     * Sets payment method type.
     * @param paymentMethodType the payment method type
     */
    public void setPaymentMethodType(PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    /**
     * Gets customer id.
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets order id.
     * @return the order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     * @param orderId the order id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets gateway transaction id.
     * @return the gateway transaction id
     */
    public String getGatewayTransactionId() {
        return gatewayTransactionId;
    }

    /**
     * Sets gateway transaction id.
     * @param gatewayTransactionId the gateway transaction id
     */
    public void setGatewayTransactionId(String gatewayTransactionId) {
        this.gatewayTransactionId = gatewayTransactionId;
    }
}
