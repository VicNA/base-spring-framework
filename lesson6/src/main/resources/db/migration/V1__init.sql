create table if not exists category (
      id bigserial primary key
    , name varchar(255)
    );

insert into category (name)
values
('Телевизоры'),
('Смартфоны'),
('Бытовая техника');

create table if not exists product (
      id bigserial primary key
    , name varchar(255)
    , category_id bigint
    );

insert into product (name, category_id)
values
('Телевизор1', 1),
('Телевизор2', 1),
('Смартфон1', 2),
('Смартфон2', 2),
('Смартфон3', 2),
('Техника1', 3),
('Техника2', 3);