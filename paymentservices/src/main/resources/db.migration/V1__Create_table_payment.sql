
CREATE TABLE if not exists payment (
    id INT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    amount INT NOT NULL,
    total DOUBLE PRECISION
);

CREATE INDEX if not exists idx_payment_userid_productid on payment (user_id, product_id);