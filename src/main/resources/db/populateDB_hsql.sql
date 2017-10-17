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


INSERT INTO RESTAURANTS (NAME, VOTES, CREATED, ID) VALUES
  ('Mario', 0, now, 4),
  ('Veronica', 0, now, 5),
  ('House of Taste', 0, now, 6),
  ('Belaggio', 0, now, 7),
  ('Rome', 0, now, 8);


INSERT INTO dishes (NAME, PRICE, RESTAURANT_ID, ID) VALUES
  ('Fish', 55, 4, 9),
  ('Meat', 44, 4, 10),
  ('Roastbeef', 99, 5, 11),
  ('Juice', 5, 6, 12),
  ('Pizza', 33, 7, 13),
  ('Salad', 22, 7, 14),
  ('Cake', 7, 8, 15);