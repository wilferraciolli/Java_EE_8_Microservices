package com.acme.payments.api.services;

import com.acme.payments.lib.Transaction;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Transaction service.
 */
public interface TransactionService {

    /**
     * Find transaction by id transaction.
     * @param id the id
     * @return the transaction
     */
    Transaction findTransactionById(String id);

    /**
     * Find transactions list.
     * @param pageable the pageable
     * @return the list
     */
    List<Transaction> findTransactions(Pageable pageable);

    /**
     * Find transactions count long.
     * @return the long
     */
    Long findTransactionsCount();

    /**
     * Create transaction transaction.
     * @param transaction the transaction
     * @return the transaction
     */
    Transaction createTransaction(Transaction transaction);
}
