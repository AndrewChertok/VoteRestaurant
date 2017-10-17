DROP TABLE user_roles IF EXISTS;
DROP TABLE dishes IF EXISTS;
DROP TABLE restaurants IF EXISTS;
DROP TABLE users IF EXISTS;
DROP SEQUENCE main_seq IF EXISTS;

CREATE SEQUENCE MAIN_SEQ AS INTEGER START WITH 16;

CREATE TABLE users
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE MAIN_SEQ PRIMARY KEY,
  name                VARCHAR(255)            NOT NULL,
  email               VARCHAR(255)            NOT NULL,
  password            VARCHAR(255)            NOT NULL,
  voted               DATE                    NULL,
  voted_restaurant    INTEGER                 NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);


CREATE TABLE restaurants
(
  id          INTEGER GENERATED BY DEFAULT AS SEQUENCE MAIN_SEQ PRIMARY KEY,
  name        VARCHAR(255)        NOT NULL,
  votes       INTEGER             NULL,
  created     DATE DEFAULT now()  NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name ON restaurants (name);

CREATE TABLE dishes
(
  id             INTEGER GENERATED BY DEFAULT AS SEQUENCE MAIN_SEQ PRIMARY KEY,
  name           VARCHAR(255)         NOT NULL,
  price          DOUBLE               NOT NULL,
  created        DATE DEFAULT now()   NOT NULL,
  restaurant_id  INTEGER              NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE
);
