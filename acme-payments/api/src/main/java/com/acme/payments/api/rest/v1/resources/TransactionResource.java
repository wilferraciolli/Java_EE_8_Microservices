package com.acme.payments.api.rest.v1.resources;

import com.acme.payments.api.services.TransactionService;
import com.acme.payments.lib.Transaction;
import com.acme.payments.lib.response.CountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Transaction resource.
 */
@RestController
@RequestMapping("/transactions")
public class TransactionResource {

    private final TransactionService transactionService;

    /**
     * Instantiates a new Transaction resource.
     * @param transactionService the transaction service
     */
    @Autowired
    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Gets transactions.
     * @param pageable the pageable
     * @return the transactions
     */
    @RequestMapping
    public ResponseEntity getTransactions(Pageable pageable) {

        List<Transaction> transactions = transactionService.findTransactions(pageable);
        Long transactionsCount = transactionService.findTransactionsCount();

        return ResponseEntity.ok().header("X-Total-Count", transactionsCount.toString()).body(transactions);
    }

    /**
     * Gets transactions count.
     * @return the transactions count
     */
    @RequestMapping("/count")
    public ResponseEntity getTransactionsCount() {

        Long transactionsCount = transactionService.findTransactionsCount();

        CountResponse countResponse = new CountResponse();
        countResponse.setCount(transactionsCount);

        return ResponseEntity.ok(countResponse);
    }

    /**
     * Gets transaction.
     * @param id the id
     * @return the transaction
     */
    @RequestMapping("/{id}")
    public ResponseEntity getTransaction(@PathVariable String id) {

        Transaction transaction = transactionService.findTransactionById(id);

        return ResponseEntity.ok(transaction);
    }

    /**
     * Create customer response entity.
     * @param newTransaction the new transaction
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody Transaction newTransaction) {

        Transaction transaction = transactionService.createTransaction(newTransaction);

        return ResponseEntity.ok(transaction);
    }
}
