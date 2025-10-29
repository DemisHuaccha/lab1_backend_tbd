package com.example.demo.services;

import com.example.demo.entities.Transactions;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // Finders
    public List<Transactions> getAllTransactions() { return transactionRepository.findAll(); }
    public Transactions getTransactionById(Long id_transaction) { return transactionRepository.findById( id_transaction ); }
    public List<Transactions> getTransactionsByType(String type_transaction) { return transactionRepository.findByType_transaction(type_transaction) ; }
    public List<Transactions> getTransactionsByDate(Date date_transaction) { return transactionRepository.findByDate_transaction(date_transaction) ; }

    // Create
    public int createTransaction(Transactions transaction) { return transactionRepository.save(transaction); }

    // Update
    public int updateTransaction(Transactions transaction) { return transactionRepository.update(transaction); }

    // Delete
    public int deleteTransaction(Long id_transaction) { return transactionRepository.delete(id_transaction); }
}
