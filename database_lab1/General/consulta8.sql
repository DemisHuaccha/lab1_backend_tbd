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
HAVING MAX(t.date_transaction) IS NULL OR MAX(t.date_transaction) < CURRENT_DATE - INTERVAL '90 days'""";

-- esta querry da como resultado los productos que no han tenido ningun tipo de movimiento en 90 dias