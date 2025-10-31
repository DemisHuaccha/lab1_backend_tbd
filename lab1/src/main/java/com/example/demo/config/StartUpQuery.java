package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class StartUpQuery implements CommandLineRunner {

    private final DataSource dataSource;

    public StartUpQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void run(String... args) {
        List<String> sqlFiles = List.of(
                "SqlResources/productsTable.sql",
                "SqlResources/storesTable.sql",
                "SqlResources/usersTable.sql",
                "SqlResources/inventorysTable.sql",
                "SqlResources/transactionsTable.sql",
                "SqlResources/suppliersTable.sql",
                "SqlResources/supplier_productTable.sql",
                "SqlResources/resumen_stock_tienda.sql",
                "SqlResources/index_resumen_stock_tienda.sql",
                //"SqlResources/initData.sql",
                "SqlResources/consulta7.sql"
        );

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            for (String path : sqlFiles) {
                InputStream input = getClass().getClassLoader().getResourceAsStream(path);
                if (input == null) throw new FileNotFoundException("No se encontró el archivo SQL: " + path);

                String sql = new String(input.readAllBytes(), StandardCharsets.UTF_8).trim();
                if (!sql.isEmpty()) {
                    stmt.execute(sql);
                    System.out.println("Archivo ejecutado con éxito: " + path);
                }
            }

            System.out.println("Todos los archivos SQL se ejecutaron correctamente.");

        } catch (SQLException | IOException e) {
            System.err.println("Error al ejecutar SQL: " + e.getMessage());
        }
    }


}
