DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (description,calories,datetime)
VALUES ('Завтрак', 500,'2020-01-30 10:00:00'),
       ('Обед', 1000,'2020-01-30 13:00:00'),
       ('Ужин', 500, '2020-01-30 20:00:00'),
       ('Еда на граничное значение', 100, '2020-01-31 00:00:00'),
       ('Завтрак', 1000, '2020-01-31 10:00:00'),
       ('Обед', 500, '2020-01-31 13:00:00'),
       ('Ужин', 410,'2020-01-31 20:00:00')
       ;
