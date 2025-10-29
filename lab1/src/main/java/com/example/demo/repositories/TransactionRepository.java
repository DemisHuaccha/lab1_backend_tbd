package com.example.demo.repositories;


import com.example.demo.entities.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TransactionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Transactions> rowMapper = (rs, rowNum) -> {
        Transactions transaction = new Transactions();
        transaction.setId_transaction(rs.getLong("id_transaction"));
        transaction.setType_transaction(rs.getString("type_transaction"));
        transaction.setDate_transaction(rs.getDate("date_transaction"));
        transaction.setAmount_product(rs.getInt("amount_product"));
        return transaction;
    };

    public List<Transactions> findAll() {
        String sql = "SELECT * FROM transactions";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Transactions> findByType_transaction(String type_transaction) {
        String sql = "SELECT * FROM transactions WHERE type_transaction = ?";
        return jdbcTemplate.query(sql, rowMapper, type_transaction);
    }

    public List<Transactions> findByDate_transaction(Date date_transaction) {
        String sql = "SELECT * FROM transactions WHERE date_transaction = ?";
        return jdbcTemplate.query(sql, rowMapper, date_transaction);
    }

    public Transactions findById(Long id) {
        String sql = "SELECT * FROM transactions WHERE id_transaction = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public int save(Transactions transaction) {
        String sql = "INSERT INTO transactions (type_transaction, date_transaction, amount_transaction) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                transaction.getType_transaction(),
                transaction.getDate_transaction(),
                transaction.getAmount_product());
    }

    public int update(Transactions transaction) {
        String sql = "UPDATE transactions SET type_transaction = ?, date_transaction = ?, amount_transaction = ? WHERE id_transaction = ?";
        return jdbcTemplate.update(sql,
                transaction.getType_transaction(),
                transaction.getDate_transaction(),
                transaction.getAmount_product());
    }

    public int delete(Long id) {
        String sql = "DELETE FROM transactions WHERE id_transaction = ?";
        return jdbcTemplate.update(sql, id);
    }
}
