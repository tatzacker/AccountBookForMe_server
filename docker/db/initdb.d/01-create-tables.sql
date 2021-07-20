DROP TABLE IF EXISTS expenses;
CREATE TABLE expenses (
    id INT(20) NOT NULL AUTO_INCREMENT,
    total_amount FLOAT(12,2) DEFAULT NULL,
    store_id INT(20) DEFAULT NULL,
    store_name VARCHAR(30) DEFAULT NULL,
    purchased_at Date DEFAULT NULL,
    note VARCHAR(140) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS items;
CREATE TABLE items (
    id INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) DEFAULT NULL,
    price FLOAT(12,2) DEFAULT NULL,
    sub_category_id INT(20) DEFAULT NULL,
    expense_id INT(20) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS stores;
CREATE TABLE stores (
    id INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS payment_methods;
CREATE TABLE payment_methods (
    id INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) DEFAULT NULL,
    color_id INT(20) DEFAULT NULL,
    icon_id INT(20) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS expenses_payment_methods;
CREATE TABLE expenses_payment_methods (
    id INT(20) NOT NULL AUTO_INCREMENT,
    expense_id INT(20) DEFAULT NULL,
    payment_method_id INT(20) DEFAULT NULL,
    sub_total FLOAT(12,2) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
    id INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS sub_categories;
CREATE TABLE sub_categories (
    id INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) DEFAULT NULL,
    tax_rate FLOAT(5,2) DEFAULT NULL,
    category_id INT(20) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS icons;
CREATE TABLE icons (
    id INT(20) NOT NULL AUTO_INCREMENT,
    color_code CHAR(6) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS colors;
CREATE TABLE colors (
    id INT(20) NOT NULL AUTO_INCREMENT,
    img_url VARCHAR(50) DEFAULT NULL,
    created_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at Datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;
