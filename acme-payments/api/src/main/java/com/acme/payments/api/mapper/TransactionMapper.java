package com.acme.payments.api.mapper;

import com.acme.payments.api.models.db.TransactionEntity;
import com.acme.payments.lib.Transaction;

/**
 * The type Transaction mapper.
 */
public class TransactionMapper {

    /**
     * To transaction transaction.
     * @param entity the entity
     * @return the transaction
     */
    public static Transaction toTransaction(TransactionEntity entity) {

        if (entity == null) return null;

        Transaction transaction = new Transaction();
        transaction.setId(entity.getId());
        transaction.setUpdatedAt(entity.getUpdatedAt());
        transaction.setCreatedAt(entity.getCreatedAt());
        transaction.setCurrency(entity.getCurrency());
        transaction.setAmount(entity.getAmount());
        transaction.setNonce(entity.getNonce());
        transaction.setStatus(entity.getStatus());
        transaction.setGatewayDeclineCode(entity.getGatewayDeclineCode());
        transaction.setProcessorResponseCode(entity.getProcessorResponseCode());
        transaction.setProcessorResponseText(entity.getProcessorResponseText());
        transaction.setPaymentMethodType(entity.getPaymentMethodType());
        transaction.setCustomerId(entity.getCustomerId());
        transaction.setOrderId(entity.getOrderId());
        transaction.setGatewayTransactionId(entity.getGatewayTransactionId());

        return transaction;
    }

    /**
     * To transaction entity transaction entity.
     * @param transaction the transaction
     * @return the transaction entity
     */
    public static TransactionEntity toTransactionEntity(Transaction transaction) {

        if (transaction == null) return null;

        TransactionEntity entity = new TransactionEntity();
        entity.setId(transaction.getId());
        entity.setCurrency(transaction.getCurrency());
        entity.setAmount(transaction.getAmount());
        entity.setNonce(transaction.getNonce());
        entity.setCustomerId(transaction.getCustomerId());
        entity.setOrderId(transaction.getOrderId());

        return entity;
    }
}
