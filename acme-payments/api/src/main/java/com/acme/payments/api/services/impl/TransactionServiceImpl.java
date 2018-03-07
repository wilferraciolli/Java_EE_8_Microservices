package com.acme.payments.api.services.impl;

import com.acme.payments.api.mapper.TransactionMapper;
import com.acme.payments.api.models.TransactionRepository;
import com.acme.payments.api.models.db.TransactionEntity;
import com.acme.payments.api.services.TransactionService;
import com.acme.payments.api.services.exceptions.EmptyPayloadException;
import com.acme.payments.api.services.exceptions.ResourceNotFoundException;
import com.acme.payments.lib.PaymentMethodType;
import com.acme.payments.lib.Transaction;
import com.acme.payments.lib.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Transaction service.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    /**
     * Instantiates a new Transaction service.
     * @param transactionRepository the transaction repository
     */
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction findTransactionById(String id) {

        TransactionEntity transactionEntity = transactionRepository.findOne(id);

        if (transactionEntity == null) {
            throw new ResourceNotFoundException(Transaction.class.getSimpleName(), id);
        }

        return TransactionMapper.toTransaction(transactionEntity);
    }

    @Override
    public List<Transaction> findTransactions(Pageable pageable) {

        List<TransactionEntity> transactionEntities = transactionRepository.findAll(pageable).getContent();

        return transactionEntities.stream().map(TransactionMapper::toTransaction).collect(Collectors.toList());
    }

    @Override
    public Long findTransactionsCount() {

        return transactionRepository.count();
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {

        if (transaction == null) {
            throw new EmptyPayloadException(Transaction.class.getSimpleName());
        }

        // Execute transaction at the payment gateway.
        // Use our integration structure we defined before with seperate clients.

        TransactionEntity transactionEntity = TransactionMapper.toTransactionEntity(transaction);
        transactionEntity.setId(null);
        transactionEntity.setStatus(TransactionStatus.SETTLED);
        transactionEntity.setProcessorResponseCode("1000");
        transactionEntity.setProcessorResponseText("Transaction approved");
        transactionEntity.setPaymentMethodType(PaymentMethodType.CREDIT_CARD);
        transactionEntity.setGatewayTransactionId(UUID.randomUUID().toString());

        transactionRepository.save(transactionEntity);

        return TransactionMapper.toTransaction(transactionEntity);
    }
}
