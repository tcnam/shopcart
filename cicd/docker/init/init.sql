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
	created_timestamp datetime,
	created_user varchar(32),
	updated_timestamp datetime,
	updated_user varchar(32),

	primary key (image_id),
	index product_id_ind (product_id),
	foreign key (product_id) references product(product_id)
)
ENGINE=INNODB;
go


INSERT INTO category (name, created_timestamp, created_user, updated_timestamp, updated_user) VALUES
('Electronics', NOW(), 'admin', NOW(), 'admin'),
('Books', NOW(), 'admin', NOW(), 'admin'),
('Clothing', NOW(), 'admin', NOW(), 'admin'),
('Home & Kitchen', NOW(), 'admin', NOW(), 'admin'),
('Toys & Games', NOW(), 'admin', NOW(), 'admin'),
('Beauty & Health', NOW(), 'admin', NOW(), 'admin'),
('Sports & Outdoors', NOW(), 'admin', NOW(), 'admin'),
('Automotive', NOW(), 'admin', NOW(), 'admin'),
('Office Supplies', NOW(), 'admin', NOW(), 'admin'),
('Garden & Outdoor', NOW(), 'admin', NOW(), 'admin');

INSERT INTO product (brand, description, iventory, name, price, category_id, created_timestamp, created_user, updated_timestamp, updated_user) VALUES
-- Category 1: Electronics
('Sony', 'Wireless Noise Cancelling Headphones', 100, 'WH-1000XM5', 299.99, 1, NOW(), 'admin', NOW(), 'admin'),
('Apple', 'Smartphone with A17 chip', 150, 'iPhone 15', 1099.99, 1, NOW(), 'admin', NOW(), 'admin'),
('Samsung', 'Smart TV 55-inch 4K', 80, 'Samsung QLED 4K', 799.99, 1, NOW(), 'admin', NOW(), 'admin'),

-- Category 2: Books
('Penguin', 'A science fiction classic', 300, 'Dune', 19.99, 2, NOW(), 'admin', NOW(), 'admin'),
('HarperCollins', 'Fantasy epic', 250, 'Lord of the Rings', 24.99, 2, NOW(), 'admin', NOW(), 'admin'),
('Random House', 'Modern novel', 200, 'The Goldfinch', 18.49, 2, NOW(), 'admin', NOW(), 'admin'),

-- Category 3: Clothing
('Nike', 'Running shoes for men', 400, 'Air Zoom Pegasus', 129.99, 3, NOW(), 'admin', NOW(), 'admin'),
('Adidas', 'Sweatshirt for women', 180, 'Essentials Fleece', 59.99, 3, NOW(), 'admin', NOW(), 'admin'),
('Levi\'s', 'Slim fit jeans', 220, '511 Slim Fit', 69.99, 3, NOW(), 'admin', NOW(), 'admin'),

-- Category 4: Home & Kitchen
('Instant', 'Electric Pressure Cooker', 150, 'Instant Pot Duo', 89.99, 4, NOW(), 'admin', NOW(), 'admin'),
('Dyson', 'Cordless vacuum cleaner', 60, 'V11 Torque Drive', 599.99, 4, NOW(), 'admin', NOW(), 'admin'),
('Philips', 'Air Fryer XL', 75, 'Premium Airfryer', 179.99, 4, NOW(), 'admin', NOW(), 'admin'),

-- Category 5: Toys & Games
('Lego', 'Star Wars LEGO set', 500, 'Millennium Falcon', 159.99, 5, NOW(), 'admin', NOW(), 'admin'),
('Hasbro', 'Family board game', 450, 'Monopoly Classic', 29.99, 5, NOW(), 'admin', NOW(), 'admin'),
('Mattel', 'Barbie Dreamhouse', 300, 'Barbie House', 199.99, 5, NOW(), 'admin', NOW(), 'admin'),

-- Category 6: Beauty & Health
('Neutrogena', 'Sunscreen SPF 50', 600, 'Ultra Sheer Dry-Touch', 12.99, 6, NOW(), 'admin', NOW(), 'admin'),
('L\'Oréal', 'Volumizing mascara', 350, 'Voluminous Lash Paradise', 10.99, 6, NOW(), 'admin', NOW(), 'admin'),
('Olay', 'Face moisturizer with SPF', 250, 'Regenerist Whip', 28.99, 6, NOW(), 'admin', NOW(), 'admin'),

-- Category 7: Sports & Outdoors
('Wilson', 'Tennis racquet', 120, 'Pro Staff RF97', 249.99, 7, NOW(), 'admin', NOW(), 'admin'),
('Adidas', 'Soccer ball', 300, 'FIFA World Cup Ball', 34.99, 7, NOW(), 'admin', NOW(), 'admin'),
('Garmin', 'GPS smartwatch', 90, 'Forerunner 255', 349.99, 7, NOW(), 'admin', NOW(), 'admin'),

-- Category 8: Automotive
('Michelin', 'All-season tires', 200, 'Defender T+H', 119.99, 8, NOW(), 'admin', NOW(), 'admin'),
('Bosch', 'Windshield wipers', 500, 'ICON Beam Wiper Blade', 24.99, 8, NOW(), 'admin', NOW(), 'admin'),
('Armor All', 'Car cleaning kit', 150, 'Complete Car Care Kit', 29.99, 8, NOW(), 'admin', NOW(), 'admin'),

-- Category 9: Office Supplies
('HP', 'Ink cartridge set', 300, '63XL Combo Pack', 64.99, 9, NOW(), 'admin', NOW(), 'admin'),
('Canon', 'Wireless printer', 60, 'PIXMA TR4720', 89.99, 9, NOW(), 'admin', NOW(), 'admin'),
('Post-it', 'Sticky notes pack', 700, 'Super Sticky Notes', 14.99, 9, NOW(), 'admin', NOW(), 'admin'),

-- Category 10: Garden & Outdoor
('Black+Decker', 'Cordless trimmer', 80, 'LSTE525 20V MAX', 129.99, 10, NOW(), 'admin', NOW(), 'admin'),
('Scotts', 'Lawn fertilizer', 200, 'Turf Builder', 24.99, 10, NOW(), 'admin', NOW(), 'admin'),
('Weber', 'Charcoal grill', 45, 'Original Kettle 22"', 139.99, 10, NOW(), 'admin', NOW(), 'admin');


INSERT INTO image (download_url, file_name, file_type, image, product_id, created_timestamp, created_user, updated_timestamp, updated_user) VALUES
('https://example.com/images/image1.jpg', 'image1.jpg', 'image/jpeg', NULL, 23, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image2.jpg', 'image2.jpg', 'image/jpeg', NULL, 20, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image3.jpg', 'image3.jpg', 'image/jpeg', NULL, 24, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image4.jpg', 'image4.jpg', 'image/jpeg', NULL, 8, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image5.jpg', 'image5.jpg', 'image/jpeg', NULL, 12, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image6.jpg', 'image6.jpg', 'image/jpeg', NULL, 28, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image7.jpg', 'image7.jpg', 'image/jpeg', NULL, 15, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image8.jpg', 'image8.jpg', 'image/jpeg', NULL, 22, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image9.jpg', 'image9.jpg', 'image/jpeg', NULL, 4, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image10.jpg', 'image10.jpg', 'image/jpeg', NULL, 11, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image11.jpg', 'image11.jpg', 'image/jpeg', NULL, 30, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image12.jpg', 'image12.jpg', 'image/jpeg', NULL, 27, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image13.jpg', 'image13.jpg', 'image/jpeg', NULL, 1, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image14.jpg', 'image14.jpg', 'image/jpeg', NULL, 6, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image15.jpg', 'image15.jpg', 'image/jpeg', NULL, 24, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image16.jpg', 'image16.jpg', 'image/jpeg', NULL, 4, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image17.jpg', 'image17.jpg', 'image/jpeg', NULL, 26, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image18.jpg', 'image18.jpg', 'image/jpeg', NULL, 17, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image19.jpg', 'image19.jpg', 'image/jpeg', NULL, 21, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image20.jpg', 'image20.jpg', 'image/jpeg', NULL, 26, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image21.jpg', 'image21.jpg', 'image/jpeg', NULL, 17, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image22.jpg', 'image22.jpg', 'image/jpeg', NULL, 9, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image23.jpg', 'image23.jpg', 'image/jpeg', NULL, 2, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image24.jpg', 'image24.jpg', 'image/jpeg', NULL, 5, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image25.jpg', 'image25.jpg', 'image/jpeg', NULL, 18, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image26.jpg', 'image26.jpg', 'image/jpeg', NULL, 7, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image27.jpg', 'image27.jpg', 'image/jpeg', NULL, 14, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image28.jpg', 'image28.jpg', 'image/jpeg', NULL, 22, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image29.jpg', 'image29.jpg', 'image/jpeg', NULL, 2, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image30.jpg', 'image30.jpg', 'image/jpeg', NULL, 3, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image31.jpg', 'image31.jpg', 'image/jpeg', NULL, 25, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image32.jpg', 'image32.jpg', 'image/jpeg', NULL, 13, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image33.jpg', 'image33.jpg', 'image/jpeg', NULL, 27, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image34.jpg', 'image34.jpg', 'image/jpeg', NULL, 5, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image35.jpg', 'image35.jpg', 'image/jpeg', NULL, 8, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image36.jpg', 'image36.jpg', 'image/jpeg', NULL, 11, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image37.jpg', 'image37.jpg', 'image/jpeg', NULL, 12, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image38.jpg', 'image38.jpg', 'image/jpeg', NULL, 21, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image39.jpg', 'image39.jpg', 'image/jpeg', NULL, 6, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image40.jpg', 'image40.jpg', 'image/jpeg', NULL, 3, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image41.jpg', 'image41.jpg', 'image/jpeg', NULL, 24, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image42.jpg', 'image42.jpg', 'image/jpeg', NULL, 12, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image43.jpg', 'image43.jpg', 'image/jpeg', NULL, 29, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image44.jpg', 'image44.jpg', 'image/jpeg', NULL, 28, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image45.jpg', 'image45.jpg', 'image/jpeg', NULL, 9, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image46.jpg', 'image46.jpg', 'image/jpeg', NULL, 3, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image47.jpg', 'image47.jpg', 'image/jpeg', NULL, 23, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image48.jpg', 'image48.jpg', 'image/jpeg', NULL, 24, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image49.jpg', 'image49.jpg', 'image/jpeg', NULL, 18, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image50.jpg', 'image50.jpg', 'image/jpeg', NULL, 15, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image51.jpg', 'image51.jpg', 'image/jpeg', NULL, 16, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image52.jpg', 'image52.jpg', 'image/jpeg', NULL, 4, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image53.jpg', 'image53.jpg', 'image/jpeg', NULL, 18, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image54.jpg', 'image54.jpg', 'image/jpeg', NULL, 8, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image55.jpg', 'image55.jpg', 'image/jpeg', NULL, 23, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image56.jpg', 'image56.jpg', 'image/jpeg', NULL, 16, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image57.jpg', 'image57.jpg', 'image/jpeg', NULL, 13, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image58.jpg', 'image58.jpg', 'image/jpeg', NULL, 12, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image59.jpg', 'image59.jpg', 'image/jpeg', NULL, 18, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image60.jpg', 'image60.jpg', 'image/jpeg', NULL, 3, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image61.jpg', 'image61.jpg', 'image/jpeg', NULL, 8, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image62.jpg', 'image62.jpg', 'image/jpeg', NULL, 22, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image63.jpg', 'image63.jpg', 'image/jpeg', NULL, 30, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image64.jpg', 'image64.jpg', 'image/jpeg', NULL, 14, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image65.jpg', 'image65.jpg', 'image/jpeg', NULL, 8, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image66.jpg', 'image66.jpg', 'image/jpeg', NULL, 6, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image67.jpg', 'image67.jpg', 'image/jpeg', NULL, 23, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image68.jpg', 'image68.jpg', 'image/jpeg', NULL, 17, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image69.jpg', 'image69.jpg', 'image/jpeg', NULL, 11, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image70.jpg', 'image70.jpg', 'image/jpeg', NULL, 3, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image71.jpg', 'image71.jpg', 'image/jpeg', NULL, 7, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image72.jpg', 'image72.jpg', 'image/jpeg', NULL, 16, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image73.jpg', 'image73.jpg', 'image/jpeg', NULL, 10, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image74.jpg', 'image74.jpg', 'image/jpeg', NULL, 11, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image75.jpg', 'image75.jpg', 'image/jpeg', NULL, 11, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image76.jpg', 'image76.jpg', 'image/jpeg', NULL, 19, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image77.jpg', 'image77.jpg', 'image/jpeg', NULL, 9, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image78.jpg', 'image78.jpg', 'image/jpeg', NULL, 28, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image79.jpg', 'image79.jpg', 'image/jpeg', NULL, 19, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image80.jpg', 'image80.jpg', 'image/jpeg', NULL, 7, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image81.jpg', 'image81.jpg', 'image/jpeg', NULL, 27, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image82.jpg', 'image82.jpg', 'image/jpeg', NULL, 30, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image83.jpg', 'image83.jpg', 'image/jpeg', NULL, 19, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image84.jpg', 'image84.jpg', 'image/jpeg', NULL, 26, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image85.jpg', 'image85.jpg', 'image/jpeg', NULL, 7, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image86.jpg', 'image86.jpg', 'image/jpeg', NULL, 16, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image87.jpg', 'image87.jpg', 'image/jpeg', NULL, 29, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image88.jpg', 'image88.jpg', 'image/jpeg', NULL, 21, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image89.jpg', 'image89.jpg', 'image/jpeg', NULL, 15, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image90.jpg', 'image90.jpg', 'image/jpeg', NULL, 22, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image91.jpg', 'image91.jpg', 'image/jpeg', NULL, 22, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image92.jpg', 'image92.jpg', 'image/jpeg', NULL, 25, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image93.jpg', 'image93.jpg', 'image/jpeg', NULL, 18, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image94.jpg', 'image94.jpg', 'image/jpeg', NULL, 28, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image95.jpg', 'image95.jpg', 'image/jpeg', NULL, 5, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image96.jpg', 'image96.jpg', 'image/jpeg', NULL, 7, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image97.jpg', 'image97.jpg', 'image/jpeg', NULL, 26, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image98.jpg', 'image98.jpg', 'image/jpeg', NULL, 18, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image99.jpg', 'image99.jpg', 'image/jpeg', NULL, 28, NOW(), 'admin', NOW(), 'admin'),
('https://example.com/images/image100.jpg', 'image100.jpg', 'image/jpeg', NULL, 25, NOW(), 'admin', NOW(), 'admin');

commit;