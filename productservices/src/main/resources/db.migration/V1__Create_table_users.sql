CREATE TABLE if not exists product(
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    price DOUBLE PRECISION
);

CREATE INDEX if not exists idx_product_id_name on product (id, name);