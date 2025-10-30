package com.example.demo.repositories;

import com.example.demo.Dtos.ninetyDays;
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
    public List<ninetyDays> ProductsWithNoMovement() {
        String sql = """
        SELECT
            p.name_product AS product_name,
            s.name_store AS store_name,
            i.stock_inventory AS stock,
            MAX(t.date_transaction) AS las_date
                        FROM products p
                    LEFT JOIN inventory i ON p.id_product = i.id_productIn
                    LEFT JOIN transactions t ON p.id_product = t.id_product
    				LEFT JOIN stores s ON s.id_store = i.id_storein
                    GROUP BY p.id_product, p.name_product, p.sku, s.id_store,i.stock_inventory
                    HAVING MAX(t.date_transaction) IS NULL OR MAX(t.date_transaction) < CURRENT_DATE - INTERVAL '5 days'""";

        RowMapper<ninetyDays> rowMapper = (rs, rowNum) -> new ninetyDays(
                rs.getString("product_name"),
                rs.getString("store_name"),
                rs.getInt("stock"),
                rs.getDate("las_date")
        );

        return jdbcTemplate.query(sql, rowMapper);
    }

}
