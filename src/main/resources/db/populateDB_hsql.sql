DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;

ALTER SEQUENCE main_seq RESTART WITH 1;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@gmail.ru', 'user');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 1),
  ('ROLE_ADMIN', 2),
  ('ROLE_USER', 2);


INSERT INTO RESTAURANTS (NAME, VOTES, CREATED) VALUES
  ('Mario', 0, now),
  ('Veronica', 0, now),
  ('House of Taste', 0, now),
  ('Belaggio', 0, now),
  ('Rome', 0, now);


INSERT INTO dishes (NAME, PRICE, RESTAURANT_ID) VALUES
  ('Fish', 55, 3),
  ('Meat', 44, 3),
  ('Roastbeef', 99, 4),
  ('Juice', 5, 5),
  ('Pizza', 33, 6),
  ('Salad', 22, 7),
  ('Cake', 7, 7);