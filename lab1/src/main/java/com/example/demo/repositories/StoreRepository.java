package com.example.demo.repositories;

import com.example.demo.entities.Stores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Stores> rowMapper = (rs, rowNum) -> {
        Stores store = new Stores();
        store.setId_store(rs.getLong("id_store"));
        store.setName_store(rs.getString("name_store"));
        store.setAddress_store(rs.getString("address_store"));
        store.setCity_store(rs.getString("city_store"));
        return store;
    };

    //Finders

    public List<Stores> findAll() {
        String sql = "SELECT * FROM stores";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Stores> findByCity(String city) {
        String sql = "SELECT * FROM stores WHERE city_store = ?";
        return jdbcTemplate.query(sql, rowMapper, city);
    }

    public Stores findById(Long id) {
        String sql = "SELECT * FROM stores WHERE id_store = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public Stores findByName(String name) {
        String sql = "SELECT * FROM stores WHERE name_store = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, name);
    }

    public Stores findByAddress(String address) {
        String sql = "SELECT * FROM stores WHERE address_store = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, address);
    }

    // Create

    public int save(Stores store) {
        String sql = "INSERT INTO stores (name_store, address_store, city_store) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, store.getName_store(), store.getAddress_store(), store.getCity_store());
    }

    // Update

    public int update(Stores store) {
        String sql = "UPDATE stores SET name_store = ?, address_store = ?, city_store = ? WHERE id_store = ?";
        return jdbcTemplate.update(sql, store.getName_store(), store.getAddress_store(), store.getCity_store(), store.getId_store());
    }

    // Delete

    public int delete(Long id) {
        String sql = "DELETE FROM stores WHERE id_store = ?";
        return jdbcTemplate.update(sql, id);
    }



}
