-- ARCHIVO ÚNICO DE POBLAMIENTO DE DATOS SQL (TOTAL: 300 REGISTROS)

-- 1. POBLAMIENTO DE LA TABLA 'Stores' (8 Registros)
-----------------------------------------------------------------
INSERT INTO Stores (id_store, name_store, direction_store, city_store) VALUES
                                                                           (1, 'Tienda Central Santiago', 'Av. Libertador 100', 'Santiago'),
                                                                           (2, 'Tienda Costera Valparaíso', 'Calle Prat 250', 'Valparaíso'),
                                                                           (3, 'Tienda Sur Concepción', 'Bulnes 50', 'Concepción'),
                                                                           (4, 'Tienda Norte Antofagasta', 'Avenida Balmaceda 300', 'Antofagasta'),
                                                                           (5, 'Tienda Cordillera Rancagua', 'Calle del Cobre 150', 'Rancagua'),
                                                                           (6, 'Tienda Iquique Playa', 'Paseo Costero 50', 'Iquique'),
-- Nuevas tiendas para volumen
                                                                           (7, 'Tienda Playera La Serena', 'Avenida del Mar 10', 'La Serena'),
                                                                           (8, 'Tienda Austral Temuco', 'Av. Alemania 700', 'Temuco');

-- 2. POBLAMIENTO DE LA TABLA 'Products' (15 Registros)
-----------------------------------------------------------------
INSERT INTO Products (id_product, name_product, description_product, price, SKU) VALUES
                                                                                     (1, 'Smartphone Galaxy X', 'Teléfono de alta gama, 128GB', 499.99, 'SMARTX128'),
                                                                                     (2, 'Laptop UltraBook Pro', 'Portátil ligero, 16GB RAM', 899.50, 'LAPUPB16'),
                                                                                     (3, 'Audífonos Inalámbricos Z', 'Cancelación de ruido, batería 20h', 79.99, 'AUDIWZ'),
                                                                                     (4, 'Mouse Óptico Ergonómico', 'Diseño para largas jornadas', 19.99, 'MOUSOPT'),
                                                                                     (5, 'Teclado Mecánico RGB', 'Switches Blue, full size', 65.00, 'TECMECRGB'),
                                                                                     (6, 'Monitor Curvo 27"', 'Pantalla LED, 144Hz', 249.99, 'MONCURV27'),
                                                                                     (7, 'Webcam HD 1080p', 'Micrófono integrado', 35.50, 'WEBCAMHD'),
                                                                                     (8, 'Disco SSD 1TB', 'Velocidad de lectura 550MB/s', 89.00, 'SSD1TB'),
                                                                                     (9, 'Router WiFi 6 Gigabit', 'Alto rendimiento, doble banda', 95.99, 'RTRWFG6'),
                                                                                     (10, 'Impresora Multifuncional Lazer', 'Color, dúplex automático', 175.50, 'IMPLAZERC'),
                                                                                     (11, 'Smartwatch Deportivo X4', 'Monitoreo de ritmo cardíaco y GPS', 120.00, 'SMARTWX4'),
                                                                                     (12, 'Adaptador USB-C a HDMI', 'Plug and play, 4K compatible', 15.00, 'ADAPUCHDMI'),
                                                                                     (13, 'Tablet Pro 11"', 'Pantalla Liquid Retina, 256GB', 699.00, 'TABPRO11'),
                                                                                     (14, 'Silla Gamer Ergonómica', 'Soporte lumbar ajustable', 189.99, 'SLLGMERGO'),
                                                                                     (15, 'Toner Impresora Negro', 'Rendimiento 2500 páginas', 45.00, 'TNRB2500');

-- 3. POBLAMIENTO DE LA TABLA 'Supplier' (6 Registros)
-----------------------------------------------------------------
INSERT INTO Supplier (supplier_id, supplier_name) VALUES
                                                      (101, 'Distribuidora Tecnológica Limitada'),
                                                      (102, 'Importadora Electrónica S.A.'),
                                                      (103, 'Global Components Chile'),
                                                      (104, 'Tecno Suministros Rápido'),
                                                      (105, 'Proveeduría Industrial Sur'),
                                                      (106, 'Componentes Avanzados SPA');

-- 4. POBLAMIENTO DE LA TABLA 'Users' (12 Registros) - Depende de Stores
-----------------------------------------------------------------
-- 1 Admin (NULL Store)
INSERT INTO Users (id_user, name_user, email_user, password_user, role, id_storeU) VALUES
    (1001, 'Ana Gutiérrez', 'ana.gutierrez@sys.com', 'hashedpass123', 'Admin', NULL);
-- Managers (T1, T4, T7)
INSERT INTO Users (id_user, name_user, email_user, password_user, role, id_storeU) VALUES
                                                                                       (1002, 'Benjamín Soto', 'benjamin.soto@stgo.com', 'hashedpass456', 'Manager', 1),
                                                                                       (1007, 'Gloria Hernández', 'gloria.h@antofa.com', 'hashedpass999', 'Manager', 4),
                                                                                       (1011, 'Horacio Izquierdo', 'horacio.i@serena.com', 'hashedpass111', 'Manager', 7);
-- Employees
INSERT INTO Users (id_user, name_user, email_user, password_user, role, id_storeU) VALUES
                                                                                       (1003, 'Carla Díaz', 'carla.diaz@valpo.com', 'hashedpass789', 'Employee', 2),
                                                                                       (1004, 'Daniel Flores', 'daniel.flores@valpo.com', 'hashedpass012', 'Employee', 2),
                                                                                       (1005, 'Elena Rojas', 'elena.rojas@concep.com', 'hashedpass345', 'Employee', 3),
                                                                                       (1006, 'Felipe Muñoz', 'felipe.munoz@concep.com', 'hashedpass678', 'Employee', 3),
                                                                                       (1008, 'Héctor Ibarra', 'hector.i@ranca.com', 'hashedpass777', 'Employee', 5),
                                                                                       (1009, 'Isabel Jaramillo', 'isabel.j@iquique.com', 'hashedpass666', 'Employee', 6),
                                                                                       (1010, 'Javier Leiva', 'javier.l@iquique.com', 'hashedpass555', 'Employee', 6),
                                                                                       (1012, 'Karla Núñez', 'karla.n@temuco.com', 'hashedpass222', 'Employee', 8);

-- 5. POBLAMIENTO DE LA TABLA 'Supplier_Product' (90 Registros) - 15 Productos x 6 Proveedores
-------------------------------------------------------------------------------------------------
-- Nota: Solo se muestra una muestra. El script genera 15x6=90 registros.
INSERT INTO Supplier_Product (supplier_idP, product_idP, quantity, unit_purchase_price) VALUES
-- Producto 1 (Smartphone)
(101, 1, 500, 400.00), (102, 1, 300, 410.00), (103, 1, 400, 405.00), (104, 1, 450, 415.00), (105, 1, 350, 408.00), (106, 1, 300, 403.00),
-- Producto 2 (Laptop)
(101, 2, 300, 750.00), (102, 2, 200, 760.00), (103, 2, 350, 755.00), (104, 2, 300, 770.00), (105, 2, 250, 758.00), (106, 2, 280, 752.00),
-- Producto 3 (Audífonos)
(101, 3, 1000, 60.00), (102, 3, 800, 62.00), (103, 3, 900, 61.00), (104, 3, 700, 63.00), (105, 3, 750, 61.50), (106, 3, 850, 60.50),
-- Producto 4 (Mouse)
(101, 4, 1500, 10.00), (102, 4, 1200, 11.00), (103, 4, 1300, 10.50), (104, 4, 1100, 11.50), (105, 4, 1400, 10.80), (106, 4, 1000, 10.20),
-- Producto 5 (Teclado)
(101, 5, 600, 50.00), (102, 5, 500, 52.00), (103, 5, 550, 51.00), (104, 5, 650, 53.00), (105, 5, 450, 51.50), (106, 5, 580, 50.50),
-- Producto 6 (Monitor)
(101, 6, 400, 200.00), (102, 6, 300, 205.00), (103, 6, 350, 202.00), (104, 6, 450, 208.00), (105, 6, 380, 203.00), (106, 6, 420, 201.00),
-- Producto 7 (Webcam)
(101, 7, 700, 25.00), (102, 7, 600, 26.00), (103, 7, 650, 25.50), (104, 7, 550, 27.00), (105, 7, 680, 25.80), (106, 7, 720, 25.20),
-- Producto 8 (SSD)
(101, 8, 500, 70.00), (102, 8, 400, 72.00), (103, 8, 450, 71.00), (104, 8, 350, 73.00), (105, 8, 480, 71.50), (106, 8, 520, 70.50),
-- Producto 9 (Router)
(101, 9, 700, 75.00), (102, 9, 600, 76.00), (103, 9, 650, 75.50), (104, 9, 500, 77.00), (105, 9, 550, 76.50), (106, 9, 620, 75.20),
-- Producto 10 (Impresora)
(101, 10, 400, 140.00), (102, 10, 300, 145.00), (103, 10, 350, 142.00), (104, 10, 250, 146.00), (105, 10, 300, 143.00), (106, 10, 330, 141.00),
-- Producto 11 (Smartwatch)
(101, 11, 800, 90.00), (102, 11, 700, 92.00), (103, 11, 750, 91.00), (104, 11, 650, 93.00), (105, 11, 700, 91.50), (106, 11, 850, 90.50),
-- Producto 12 (Adaptador)
(101, 12, 1200, 8.00), (102, 12, 1000, 9.00), (103, 12, 1100, 8.50), (104, 12, 900, 9.50), (105, 12, 1050, 8.75), (106, 12, 1150, 8.25),
-- Producto 13 (Tablet - NUEVO)
(101, 13, 300, 550.00), (102, 13, 250, 560.00), (103, 13, 350, 555.00), (104, 13, 200, 565.00), (105, 13, 280, 558.00), (106, 13, 320, 552.00),
-- Producto 14 (Silla Gamer - NUEVO)
(101, 14, 200, 150.00), (102, 14, 180, 155.00), (103, 14, 220, 152.00), (104, 14, 150, 158.00), (105, 14, 210, 153.00), (106, 14, 230, 151.00),
-- Producto 15 (Toner - NUEVO)
(101, 15, 800, 35.00), (102, 15, 700, 37.00), (103, 15, 900, 36.00), (104, 15, 600, 38.00), (105, 15, 750, 36.50), (106, 15, 850, 35.50);

-- 6. POBLAMIENTO DE LA TABLA 'Inventory' (120 Registros) - 15 Productos x 8 Tiendas
--------------------------------------------------------------------------------------
INSERT INTO Inventory (id_storeIn, id_productIn, stock_inventory) VALUES
-- T1 (Santiago)
(1, 1, 450), (1, 2, 320), (1, 3, 500), (1, 4, 380), (1, 5, 210), (1, 6, 410), (1, 7, 150), (1, 8, 270), (1, 9, 300), (1, 10, 250), (1, 11, 350), (1, 12, 400), (1, 13, 280), (1, 14, 150), (1, 15, 300),
-- T2 (Valparaíso)
(2, 1, 300), (2, 2, 250), (2, 3, 400), (2, 4, 310), (2, 5, 180), (2, 6, 350), (2, 7, 120), (2, 8, 200), (2, 9, 280), (2, 10, 200), (2, 11, 300), (2, 12, 350), (2, 13, 200), (2, 14, 100), (2, 15, 400),
-- T3 (Concepción)
(3, 1, 350), (3, 2, 280), (3, 3, 450), (3, 4, 400), (3, 5, 250), (3, 6, 300), (3, 7, 100), (3, 8, 150), (3, 9, 320), (3, 10, 220), (3, 11, 380), (3, 12, 420), (3, 13, 250), (3, 14, 120), (3, 15, 350),
-- T4 (Antofagasta)
(4, 1, 380), (4, 2, 290), (4, 3, 420), (4, 4, 350), (4, 5, 230), (4, 6, 370), (4, 7, 180), (4, 8, 250), (4, 9, 300), (4, 10, 200), (4, 11, 400), (4, 12, 500), (4, 13, 300), (4, 14, 180), (4, 15, 450),
-- T5 (Rancagua)
(5, 1, 400), (5, 2, 300), (5, 3, 450), (5, 4, 380), (5, 5, 200), (5, 6, 350), (5, 7, 130), (5, 8, 220), (5, 9, 250), (5, 10, 180), (5, 11, 350), (5, 12, 450), (5, 13, 220), (5, 14, 110), (5, 15, 380),
-- T6 (Iquique)
(6, 1, 330), (6, 2, 260), (6, 3, 480), (6, 4, 420), (6, 5, 270), (6, 6, 320), (6, 7, 110), (6, 8, 180), (6, 9, 280), (6, 10, 190), (6, 11, 380), (6, 12, 480), (6, 13, 270), (6, 14, 140), (6, 15, 420),
-- T7 (La Serena - NUEVA)
(7, 1, 360), (7, 2, 310), (7, 3, 430), (7, 4, 340), (7, 5, 220), (7, 6, 360), (7, 7, 160), (7, 8, 260), (7, 9, 290), (7, 10, 210), (7, 11, 370), (7, 12, 460), (7, 13, 310), (7, 14, 160), (7, 15, 330),
-- T8 (Temuco - NUEVA)
(8, 1, 340), (8, 2, 270), (8, 3, 410), (8, 4, 320), (8, 5, 190), (8, 6, 330), (8, 7, 140), (8, 8, 210), (8, 9, 260), (8, 10, 190), (8, 11, 310), (8, 12, 410), (8, 13, 240), (8, 14, 130), (8, 15, 390);

-- 7. POBLAMIENTO DE LA TABLA 'Transactions' (88 Registros) - Flujo Consistente y Redundante
-------------------------------------------------------------------------------------------
-- Transacciones pre-existentes (39 registros)
INSERT INTO Transactions (id_transaction, type_transaction, date_transaction, amount_product, id_product, id_storeOR, id_storeDE) VALUES
                                                                                                                                      (1, 'Receipt', '2025-10-25 09:00:00', 50, 1, NULL, 1), (2, 'Receipt', '2025-10-25 09:30:00', 100, 3, NULL, 1),
                                                                                                                                      (3, 'Receipt', '2025-10-25 10:00:00', 75, 5, NULL, 1), (4, 'Receipt', '2025-10-25 10:30:00', 50, 7, NULL, 1),
                                                                                                                                      (5, 'Receipt', '2025-10-25 11:00:00', 60, 8, NULL, 1), (11, 'Receipt', '2025-10-26 09:00:00', 100, 9, NULL, 4),
                                                                                                                                      (12, 'Receipt', '2025-10-26 09:30:00', 50, 10, NULL, 4), (13, 'Receipt', '2025-10-26 10:00:00', 150, 11, NULL, 4),
                                                                                                                                      (14, 'Receipt', '2025-10-26 10:30:00', 200, 12, NULL, 4), (15, 'Receipt', '2025-10-26 11:00:00', 70, 2, NULL, 4),
                                                                                                                                      (9, 'Transfer', '2025-10-25 16:00:00', 20, 7, 1, 3), (10, 'Transfer', '2025-10-25 16:30:00', 30, 8, 1, 3),
                                                                                                                                      (23, 'Transfer', '2025-10-26 17:00:00', 50, 5, 1, 6), (24, 'Transfer', '2025-10-26 17:30:00', 40, 11, 4, 5),
                                                                                                                                      (25, 'Transfer', '2025-10-26 18:00:00', 20, 2, 2, 3), (26, 'Sale', '2025-10-27 10:00:00', 2, 1, 1, NULL),
                                                                                                                                      (27, 'Sale', '2025-10-27 10:30:00', 5, 3, 1, NULL), (28, 'Sale', '2025-10-27 11:00:00', 1, 5, 1, NULL),
                                                                                                                                      (29, 'Sale', '2025-10-27 11:30:00', 3, 7, 1, NULL), (6, 'Sale', '2025-10-25 14:00:00', 5, 2, 2, NULL),
                                                                                                                                      (7, 'Sale', '2025-10-25 14:15:00', 10, 4, 2, NULL), (8, 'Sale', '2025-10-25 14:30:00', 2, 6, 2, NULL),
                                                                                                                                      (30, 'Sale', '2025-10-27 12:00:00', 4, 1, 2, NULL), (31, 'Sale', '2025-10-27 14:00:00', 3, 2, 3, NULL),
                                                                                                                                      (32, 'Sale', '2025-10-27 14:30:00', 5, 4, 3, NULL), (33, 'Sale', '2025-10-27 15:00:00', 1, 6, 3, NULL),
                                                                                                                                      (34, 'Sale', '2025-10-27 15:30:00', 2, 8, 3, NULL), (35, 'Sale', '2025-10-28 10:00:00', 4, 9, 4, NULL),
                                                                                                                                      (36, 'Sale', '2025-10-28 10:30:00', 1, 10, 4, NULL), (37, 'Sale', '2025-10-28 11:00:00', 6, 11, 4, NULL),
                                                                                                                                      (38, 'Sale', '2025-10-28 11:30:00', 10, 12, 4, NULL), (16, 'Sale', '2025-10-26 14:00:00', 3, 1, 5, NULL),
                                                                                                                                      (17, 'Sale', '2025-10-26 14:15:00', 8, 3, 5, NULL), (18, 'Sale', '2025-10-26 14:30:00', 1, 10, 5, NULL),
                                                                                                                                      (39, 'Sale', '2025-10-28 14:00:00', 2, 7, 5, NULL), (19, 'Sale', '2025-10-26 15:00:00', 5, 9, 6, NULL),
                                                                                                                                      (20, 'Sale', '2025-10-26 15:15:00', 15, 12, 6, NULL), (21, 'Sale', '2025-10-26 15:30:00', 2, 6, 6, NULL),
                                                                                                                                      (22, 'Sale', '2025-10-26 15:45:00', 4, 8, 6, NULL);

-- Transacciones ADICIONALES (49 registros - IDs 40-88)
-- FASE 3: Recepción y Transferencia (41 Transacciones)
INSERT INTO Transactions (id_transaction, type_transaction, date_transaction, amount_product, id_product, id_storeOR, id_storeDE) VALUES
-- Receipts (Proveedor -> Tienda)
(40, 'Receipt', '2025-10-29 08:00:00', 80, 13, NULL, 7), (41, 'Receipt', '2025-10-29 08:30:00', 40, 14, NULL, 7), -- T7: P13, P14
(42, 'Receipt', '2025-10-29 09:00:00', 50, 15, NULL, 8), (43, 'Receipt', '2025-10-29 09:30:00', 120, 4, NULL, 8), -- T8: P15, P4
-- Transfers (Movimiento entre tiendas para balancear)
(44, 'Transfer', '2025-10-29 11:00:00', 30, 10, 1, 7), -- T1 -> T7: P10
(45, 'Transfer', '2025-10-29 11:30:00', 25, 9, 4, 8),  -- T4 -> T8: P9
(46, 'Transfer', '2025-10-29 12:00:00', 15, 13, 7, 3), -- T7 -> T3: P13
(47, 'Transfer', '2025-10-29 12:30:00', 10, 14, 8, 5), -- T8 -> T5: P14
-- Múltiples Transferencias y Receipts adicionales (33 registros restantes para alcanzar 41 R/T)
(48, 'Receipt', '2025-10-29 13:00:00', 50, 1, NULL, 1), (49, 'Receipt', '2025-10-29 13:30:00', 30, 2, NULL, 2),
(50, 'Transfer', '2025-10-29 14:00:00', 15, 3, 2, 4), (51, 'Transfer', '2025-10-29 14:30:00', 20, 4, 3, 5),
(52, 'Receipt', '2025-10-29 15:00:00', 60, 5, NULL, 6), (53, 'Transfer', '2025-10-29 15:30:00', 5, 6, 6, 1),
(54, 'Receipt', '2025-10-29 16:00:00', 40, 7, NULL, 7), (55, 'Transfer', '2025-10-29 16:30:00', 10, 8, 5, 8),
(56, 'Receipt', '2025-10-29 17:00:00', 70, 9, NULL, 3), (57, 'Transfer', '2025-10-29 17:30:00', 8, 10, 4, 2),
(58, 'Receipt', '2025-10-29 18:00:00', 90, 11, NULL, 5), (59, 'Transfer', '2025-10-29 18:30:00', 12, 12, 1, 4),
(60, 'Receipt', '2025-10-30 08:00:00', 100, 13, NULL, 2), (61, 'Transfer', '2025-10-30 08:30:00', 15, 14, 6, 7),
(62, 'Receipt', '2025-10-30 09:00:00', 20, 15, NULL, 1), (63, 'Transfer', '2025-10-30 09:30:00', 5, 1, 2, 5),
(64, 'Receipt', '2025-10-30 10:00:00', 40, 2, NULL, 3), (65, 'Transfer', '2025-10-30 10:30:00', 10, 3, 4, 6),
(66, 'Receipt', '2025-10-30 11:00:00', 50, 4, NULL, 5), (67, 'Transfer', '2025-10-30 11:30:00', 8, 5, 3, 1),
(68, 'Receipt', '2025-10-30 12:00:00', 60, 6, NULL, 6), (69, 'Transfer', '2025-10-30 12:30:00', 12, 7, 5, 2),
(70, 'Receipt', '2025-10-30 13:00:00', 70, 8, NULL, 7), (71, 'Transfer', '2025-10-30 13:30:00', 9, 9, 6, 3),
(72, 'Receipt', '2025-10-30 14:00:00', 80, 10, NULL, 8), (73, 'Transfer', '2025-10-30 14:30:00', 11, 11, 7, 4),
(74, 'Receipt', '2025-10-30 15:00:00', 90, 12, NULL, 1), (75, 'Transfer', '2025-10-30 15:30:00', 7, 13, 8, 5),
(76, 'Receipt', '2025-10-30 16:00:00', 100, 14, NULL, 2), (77, 'Transfer', '2025-10-30 16:30:00', 6, 15, 1, 6),
(78, 'Receipt', '2025-10-30 17:00:00', 110, 1, NULL, 3), (79, 'Transfer', '2025-10-30 17:30:00', 5, 2, 2, 7),
(80, 'Receipt', '2025-10-30 18:00:00', 120, 3, NULL, 4);

-- FASE 4: Ventas Adicionales (8 Sales)
-- 4 Sales para T7 y 4 Sales para T8 (Mínimo de 4 ventas por tienda)
INSERT INTO Transactions (id_transaction, type_transaction, date_transaction, amount_product, id_product, id_storeOR, id_storeDE) VALUES
                                                                                                                                      (81, 'Sale', '2025-10-31 10:00:00', 5, 1, 7, NULL),  -- T7: P1
                                                                                                                                      (82, 'Sale', '2025-10-31 10:30:00', 2, 13, 7, NULL), -- T7: P13 (Tablet)
                                                                                                                                      (83, 'Sale', '2025-10-31 11:00:00', 8, 3, 7, NULL),  -- T7: P3
                                                                                                                                      (84, 'Sale', '2025-10-31 11:30:00', 1, 10, 7, NULL), -- T7: P10
                                                                                                                                      (85, 'Sale', '2025-10-31 14:00:00', 3, 4, 8, NULL),  -- T8: P4
                                                                                                                                      (86, 'Sale', '2025-10-31 14:30:00', 1, 15, 8, NULL), -- T8: P15 (Toner)
                                                                                                                                      (87, 'Sale', '2025-10-31 15:00:00', 4, 9, 8, NULL),  -- T8: P9
                                                                                                                                      (88, 'Sale', '2025-10-31 15:30:00', 2, 11, 8, NULL); -- T8: P11

-- ---------------------------------------------------------------------
-- FIN DEL ARCHIVO DE POBLAMIENTO
-- ---------------------------------------------------------------------