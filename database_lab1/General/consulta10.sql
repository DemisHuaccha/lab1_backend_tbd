-- Crear la vista materializada para la consulta 10
CREATE MATERIALIZED VIEW IF NOT EXISTS resumen_stock_tienda AS
SELECT
    t.id_store AS id_tienda,
    t.name_store AS nombre_tienda,
    SUM(i.stock_inventory * p.price) AS valor_total_inventario,
    COUNT(DISTINCT i.id_productin) AS productos_unicos
FROM stores t
         JOIN inventory i ON t.id_store = i.id_storein
         JOIN products p ON i.id_productin = p.id_product
GROUP BY t.id_store, t.name_store;
-- se crea un index unico para poder operar con la vista materializada
CREATE UNIQUE INDEX idx_resumen_stock_tienda ON resumen_stock_tienda (id_tienda, nombre_tienda);

-- para poder actualizar los datos de la vista materializada se debe ejecutar esta querry:
REFRESH MATERIALIZED VIEW CONCURRENTLY resumen_stock_tienda
--para poder ver los datos de la vista materializada simplemente se ejecuta una querry simple donde se seleccionan todos los datos:
SELECT * FROM resumen_stock_tienda