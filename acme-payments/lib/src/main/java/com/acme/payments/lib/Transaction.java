package com.acme.payments.lib;

import com.acme.payments.lib.common.BaseType;

import java.math.BigDecimal;

/**
 * The type Transaction.
 */
public class Transaction extends BaseType {

    private String currency;
    private BigDecimal amount;
    private String nonce;
    private TransactionStatus status;
    private String gatewayDeclineCode;
    private String processorResponseCode;
    private String processorResponseText;
    private PaymentMethodType paymentMethodType;
    private String customerId;
    private String orderId;
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
