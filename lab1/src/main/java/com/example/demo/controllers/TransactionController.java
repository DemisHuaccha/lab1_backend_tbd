package com.example.demo.controllers;

import com.example.demo.Dtos.Transfer;
import com.example.demo.entities.Transactions;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        List<Transactions> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable Long id) {
        Transactions transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/searchByType")
    public ResponseEntity<List<Transactions>> getTransactionsByType(@RequestParam String type) {
        List<Transactions> transactions = transactionService.getTransactionsByType(type);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/searchByDate")
    public ResponseEntity<List<Transactions>> getTransactionsByDate(@RequestParam Date date) {
        List<Transactions> transactions = transactionService.getTransactionsByDate(date);
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/unusual")
    public ResponseEntity<List<Transactions>> getUnusualTransactions() {
        List<Transactions> transactions = transactionService.unusualTransaction();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<Integer> createTransaction(@RequestBody Transactions transaction) {
        int createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.ok(createdTransaction);
    }

    @PutMapping("/transfer")
    public ResponseEntity<Integer> transferInventory(@RequestBody Transfer transfer) {
        int result = transactionService.transferInventory(transfer);
        return ResponseEntity.ok(result);
    }

}
