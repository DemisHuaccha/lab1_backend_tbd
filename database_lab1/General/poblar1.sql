BEGIN;

-- Tiendas
INSERT INTO Stores (name_store, direction_store, city_store) VALUES
('Tienda Central', 'Av. Principal 123', 'Santiago'),
('Sucursal Norte', 'Calle Norte 456', 'Antofagasta');

-- Productos
INSERT INTO Products (name_product, description_product, price, SKU) VALUES
('Laptop X', 'Laptop de alto rendimiento', 800000, 'SKU-LAPTOP-X'),
('Mouse Óptico', 'Mouse inalámbrico', 15000, 'SKU-MOUSE-OPT');

-- Usuarios
INSERT INTO Users (name_user, email_user, password_user, role, id_storeU) VALUES
('Ana Pérez', 'ana@tienda.cl', 'pass123', 'ADMINISTRATOR', 1),
('Luis Soto', 'luis@sucursal.cl', 'pass456', 'EMPLOYEE', 2);

-- Proveedores
INSERT INTO Supplier (supplier_name) VALUES
('TechPro'),
('GadgetWorld');

-- Relación proveedor-producto
INSERT INTO Supplier_Product (supplier_idP, product_idP, quantity, unit_purchase_price) VALUES
(1, 1, 100, 700000),
(2, 2, 200, 12000);

-- Inventario inicial
INSERT INTO Inventory (id_storeIn, id_productIn, stock_inventory) VALUES
(1, 1, 60),
(1, 2, 80),
(2, 1, 40),
(2, 2, 50);

-- Transacciones de recepción por trimestre
INSERT INTO Transactions (type_transaction, date_transaction, amount_product, id_product, id_storeOR, id_storeDE) VALUES
('Receipt', '2025-01-15', 25, 1, NULL, 1),
('Receipt', '2025-04-10', 30, 2, NULL, 2),
('Receipt', '2025-07-05', 20, 1, NULL, 2),
('Receipt', '2025-10-20', 40, 2, NULL, 1),

-- Transacciones de venta por trimestre
('Sale', '2025-02-05', 5, 1, 1, NULL),
('Sale', '2025-05-12', 10, 2, 2, NULL),
('Sale', '2025-08-18', 3, 1, 2, NULL),
('Sale', '2025-11-25', 8, 2, 1, NULL),

-- Transacción de transferencia
('Transfer', '2025-06-01', 10, 1, 1, 2);

-- Nuevo producto
INSERT INTO Products (name_product, description_product, price, SKU) VALUES
('Teclado Mecánico Pro', 'Teclado mecánico con retroiluminación RGB', 45000, 'SKU-KEYBOARD-PRO');

-- Inventario inicial en tienda 2
INSERT INTO Inventory (id_storeIn, id_productIn, stock_inventory) VALUES
(2, 3, 30);  -- Asumiendo que el nuevo producto tiene id_product = 3

-- Recepción en tienda 2
INSERT INTO Transactions (type_transaction, date_transaction, amount_product, id_product, id_storeOR, id_storeDE) VALUES
('Receipt', '2025-08-01', 30, 3, NULL, 2);

-- Venta en tienda 2, 20 días después
INSERT INTO Transactions (type_transaction, date_transaction, amount_product, id_product, id_storeOR, id_storeDE) VALUES
('Sale', '2025-08-21', 5, 3, 2, NULL);

COMMIT;