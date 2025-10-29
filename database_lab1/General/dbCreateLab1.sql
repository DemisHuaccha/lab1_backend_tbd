CREATE TABLE IF NOT EXISTS Products(
	id_product SERIAL PRIMARY KEY,
	name_product VARCHAR(255),
	description_product VARCHAR(255),
	price INTEGER,
	SKU VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Stores(
	id_store SERIAL PRIMARY KEY,
	name_store VARCHAR(255),
	direction_store VARCHAR(255),
	city_store VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Users(
    id_user SERIAL PRIMARY KEY,
	name_user VARCHAR(255),
	email_user VARCHAR(255) UNIQUE NOT NULL,
	password_user VARCHAR(255) NOT NULL,
	role VARCHAR(255),
	id_storeU BIGINT,
	CONSTRAINT fk_store_user FOREIGN KEY (id_storeU) REFERENCES Stores(id_store)
);

CREATE TABLE IF NOT EXISTS Inventory(
    id_storeIn BIGINT NOT NULL,
    id_productIn BIGINT NOT NULL,
    stock_inventory INTEGER,
    PRIMARY KEY (id_storeIn, id_productIn),
    CONSTRAINT fk_store_inventory FOREIGN KEY (id_storeIn) REFERENCES Stores(id_store),
    CONSTRAINT fk_product_inventory  FOREIGN KEY (id_productIn) REFERENCES Products(id_product)
);

/*
Transactions Types: 
'Sale', 'Transfer', 'Receipt'
*/
CREATE TABLE IF NOT EXISTS Transactions(
	id_transaction SERIAL,
	type_transaction VARCHAR(255),
	date_transaction DATE,
	amount_product INTEGER,
	id_product BIGINT,
	id_storeOR BIGINT,
	id_storeDE BIGINT,
	CONSTRAINT fk_storeOrigin_transaction FOREIGN KEY (id_storeOR) REFERENCES Stores(id_store),
	CONSTRAINT fk_storeDestiny_transaction FOREIGN KEY (id_storeDE) REFERENCES Stores(id_store),
    CONSTRAINT fk_product_transaction FOREIGN KEY (id_product) REFERENCES Products(id_product)
);

CREATE TABLE IF NOT EXISTS Supplier(
	supplier_id SERIAL PRIMARY KEY,
	supplier_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Supplier_Product(
	supplier_idP BIGINT NOT NULL,
	product_idP BIGINT NOT NULL,
	quantity INTEGER,
	unit_purchase_price INTEGER,
	PRIMARY KEY (supplier_idP, product_idP),
	CONSTRAINT fk_supplier_product FOREIGN KEY (supplier_idP) REFERENCES Supplier(supplier_id),
    CONSTRAINT fk_product_supplier FOREIGN KEY (product_idP) REFERENCES Products(id_product)
);

