DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS orders_products;
DROP TABLE IF EXISTS orders;

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL,
  price       NUMERIC(10, 2),
  color       INTEGER,
  capacity    INTEGER,
  display     TEXT,
  description TEXT
);


DROP TABLE IF EXISTS material_for_product;
DROP TABLE IF EXISTS product_in_check;
DROP TABLE IF EXISTS checks;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS material_count;
DROP TABLE IF EXISTS material;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;


CREATE TABLE orders (
  id           SERIAL PRIMARY KEY,
  total_amount NUMERIC(10, 2)           NOT NULL,
  datetime     TIMESTAMP WITH TIME ZONE NOT NULL,
  name         TEXT                     NOT NULL,
  email        TEXT                     NOT NULL,
  phone        TEXT,
  address      TEXT                     NOT NULL,
  user_id      INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE orders_products (
  order_id   INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);

CREATE TABLE comments (
  id         SERIAL PRIMARY KEY,
  product_id INTEGER                  NOT NULL,
  author     TEXT                     NOT NULL,
  datetime   TIMESTAMP WITH TIME ZONE NOT NULL,
  text       TEXT,
  rating     INTEGER,
  FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);


CREATE TABLE product (
  id             SERIAL PRIMARY KEY,
  name           TEXT NOT NULL,
  description  TEXT NOT NULL,
  price_for_sale NUMERIC(10, 2)
);


CREATE TABLE material (
  id            SERIAL PRIMARY KEY,
  price NUMERIC(10, 2),
  name         TEXT,
  provider TEXT,

  date_buy      TIMESTAMP WITH TIME ZONE
);


CREATE TABLE material_for_product (
  id          SERIAL PRIMARY KEY,
  product_id  INTEGER,
  material_id INTEGER,
  FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE SET NULL,

  FOREIGN KEY (material_id) REFERENCES material (id) ON DELETE SET NULL
);

CREATE TABLE checks (
  id                SERIAL PRIMARY KEY,

  code_card_visitor TEXT,
  date_came         TIMESTAMP WITH TIME ZONE NOT NULL,
  date_pay          TIMESTAMP WITH TIME ZONE NOT NULL,
  position          INTEGER,
  user_id           INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE product_in_check (
  id         SERIAL PRIMARY KEY,
  check_id   INTEGER,
  product_id INTEGER,
  FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE SET NULL,

  FOREIGN KEY (check_id) REFERENCES checks (id) ON DELETE SET NULL
);



