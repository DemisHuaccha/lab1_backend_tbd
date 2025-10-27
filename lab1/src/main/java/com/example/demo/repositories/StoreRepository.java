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
        store.setNombre_store(rs.getString("nombre_store"));
        store.setDireccion_store(rs.getString("direccion_store"));
        store.setCiudad_store(rs.getString("ciudad_store"));
        return store;
    };

    //Finders

    public List<Stores> findAll() {
        String sql = "SELECT * FROM stores";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Stores> findByCity(String ciudad) {
        String sql = "SELECT * FROM stores WHERE ciudad_store = ?";
        return jdbcTemplate.query(sql, rowMapper, ciudad);
    }

    public Stores findById(Long id) {
        String sql = "SELECT * FROM stores WHERE id_store = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public Stores findByName(String name) {
        String sql = "SELECT * FROM stores WHERE nombre_store = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, name);
    }

    public Stores findByDirection(String direccion) {
        String sql = "SELECT * FROM stores WHERE direccion_store = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, direccion);
    }

    // Create

    public int save(Stores store) {
        String sql = "INSERT INTO stores (nombre_store, direccion_store, ciudad_store) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, store.getNombre_store(), store.getDireccion_store(), store.getCiudad_store());
    }

    // Update

    public int update(Stores store) {
        String sql = "UPDATE stores SET nombre_store = ?, direccion_store = ?, ciudad_store = ? WHERE id_store = ?";
        return jdbcTemplate.update(sql, store.getNombre_store(), store.getDireccion_store(), store.getCiudad_store(), store.getId_store());
    }

    // Delete

    public int delete(Long id) {
        String sql = "DELETE FROM stores WHERE id_store = ?";
        return jdbcTemplate.update(sql, id);
    }



}
