
CREATE TABLE if not exists users(
    id INT PRIMARY KEY ,
    username VARCHAR(50) NOT NULL,
    password VARCHAR NOT NULL,
    token VARCHAR,
    is_enabled bool,
    is_account_locked bool,
    role VARCHAR(20)
);

CREAtE TABLE if not exists customer(
    id INT primary key ,
    nik VARCHAR(50) unique ,
    name VARCHAR(50) NOT NULL,
    gender varchar(15),
    address varchar(100),
    email varchar(50) unique,
    phone_number varchar(15) unique,
);

CREATE INDEX if not exists idx_users_username_token on users(username, token);
CREATE INDEX if not exists idx_customer_nik_name_email_phonenumber on customer(nik,name,email,phone_number);