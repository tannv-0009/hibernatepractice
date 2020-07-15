create schema if not exists pj2002 collate utf8mb4_0900_ai_ci;

create table if not exists Address
(
	id int auto_increment
		primary key,
	address_name varchar(30) null,
	idx int null,
	user_id int null
);

create table if not exists user
(
	id int auto_increment
		primary key,
	name varchar(255) charset utf8 null,
	date_of_birth date null
);

create table if not exists category
(
	category_id int auto_increment
		primary key,
	name varchar(45) not null
);

create table if not exists product
(
	product_id int auto_increment
		primary key,
	name varchar(45) null,
	description varchar(512) null,
	price float null,
	category_id int null,
	constraint product_category_category_id_fk
		foreign key (category_id) references pj2002.category (category_id)
);

  