package com.example.demo.repositories;

import com.example.demo.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Products> rowMapper = (rs, rowNum) -> {
        Products product = new Products();
        product.setId(rs.getLong("id_product"));
        product.setName_product(rs.getString("name_product"));
        product.setDescription_product(rs.getString("description_product"));
        product.setPrice(rs.getInt("price"));
        product.setSKU(rs.getString("sku"));
        return product;
    };

    public List<Products> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Products findById(Long id) {
        String sql = "SELECT * FROM products WHERE id_product = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public Optional<Products> findBySKU(String sku) {
        String sql = "SELECT * FROM products WHERE sku = ?";
        try {
            Products product = jdbcTemplate.queryForObject(sql, rowMapper, sku);
            return Optional.ofNullable(product);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public int save(Products product) {
        String sql = "INSERT INTO products (name_product, description_product, price, sku) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                product.getName_product(),
                product.getDescription_product(),
                product.getPrice(),
                product.getSKU());
    }

    public int update(Products product) {
        String sql = "UPDATE products SET nombre_product = ?, descripcion_product = ?, price = ?, sku = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                product.getName_product(),
                product.getDescription_product(),
                product.getPrice(),
                product.getSKU(),
                product.getId());
    }

    public int delete(Long id) {
        String sql = "DELETE FROM products WHERE id_product = ?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Products> findByNameContaining(String name) {
        String sql = "SELECT * FROM products WHERE name_product ILIKE ?";
        return jdbcTemplate.query(sql, rowMapper, "%" + name + "%");
    }

    //consulta 8 productos sin movimientos por mas de 90 dias
    public List<Products> ProductsWithNoMovement() {
        String sql = "SELECT \n" +
                "    p.nombre AS nombre_producto,\n" +
                "    SUM(i.cantidad_en_stock) AS stock_actual,\n" +
                "    MAX(t.fecha) AS ultima_transaccion\n" +
                "FROM productos p\n" +
                "JOIN inventario i ON p.id = i.id_producto\n" +
                "LEFT JOIN transacciones t ON p.id = t.id_producto\n" +
                "GROUP BY p.id, p.nombre\n" +
                "HAVING MAX(t.fecha) IS NULL OR MAX(t.fecha) < CURRENT_DATE - INTERVAL '90 days';\n";
        return  jdbcTemplate.query(sql, rowMapper);
    }
}
