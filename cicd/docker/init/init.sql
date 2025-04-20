use shopcart;
go

create table if not exists category (
	category_id bigint not null auto_increment,
	name varchar(255),
	created_timestamp datetime,
	created_user varchar(32),
	updated_timestamp datetime,
	updated_user varchar(32),

	primary key(category_id)
)
ENGINE=INNODB;
go

create table if not exists product (
	product_id bigint not null auto_increment,
	brand varchar(255),
	description varchar(255),
	iventory int,
	name varchar(255),
	price decimal(38,2),
	category_id bigint,
	created_timestamp datetime,
	created_user varchar(32),
	updated_timestamp datetime,
	updated_user varchar(32),

	primary key (product_id),
	index category_id_ind (category_id),
	foreign key (category_id) references category(category_id)
)
ENGINE=INNODB;
go

create table if not exists image (
	image_id bigint not null auto_increment,
	download_url varchar(255),
	file_name varchar(255),
	file_type varchar(255),
	image mediumblob,
	product_id bigint,

	primary key (image_id),
	index product_id_ind (product_id),
	foreign key (product_id) references product(product_id)
)
ENGINE=INNODB;
go
