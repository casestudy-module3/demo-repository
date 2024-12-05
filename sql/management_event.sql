create database management_event;
use management_event;
create table events_organized(
id int primary key auto_increment,
name_event varchar(50),
place varchar(30),
time_event datetime not null,
image varchar(50),
scope int not null,
description_event varchar(200) not null,
status_event boolean not null
);
create table event_tickets_sale(
id int primary key auto_increment,
id_event int not null,
id_ticket int not null,
foreign key (id_event) references events_organized(id),
foreign key (id_ticket) references tickets(id)
);
create table ticket_types(
id int primary key auto_increment,
name_ticket varchar(10)
);
create table price_tickets(
id_price_ticket int primary key auto_increment,
id_ticket_type int not null,
price decimal(15,3) not null,
foreign key(id_ticket_type) references ticket_types(id)
);
create table tickets(
id int primary key auto_increment,
id_price int not null,
time_book datetime not null,
id_event int not null,
id_customer int not null,
foreign key(id_price) references price_tickets(id_price_ticket),
foreign key(id_event) references events_organized(id),
foreign key(id_customer) references customers(id)
);
create table customers(
id int primary key auto_increment,
name_customer varchar(50) not null,
email varchar(50) not null,
phone_number varchar(10) not null,
status_customer boolean not null
);
create table admins (
id int primary key auto_increment,
user_name varchar(30) not null unique,
password_ad varchar(50) not null,
full_name varchar(50) not null, 
dob date not null,
gender boolean not null,
email varchar(30) not null,
address varchar(50),
position varchar(20) not null,
phoneNumber varchar(10) not null
);
INSERT INTO admins (user_name, password_ad, full_name, dob, gender, email, address, position, phoneNumber)
VALUES 
('admin001','password123','John Doe','1990-05-20', TRUE,'admin@example.com','123 Main St','Manager',  '0123456789');
drop database management_event;
drop table admins;
INSERT INTO events_organized (name_event, place, time_event, image, scope, description_event, status_event) 
VALUES 
('Music Festival', 'Central Park', '2024-12-10 18:00:00', 'music_fest.jpg', 500, 'A grand music festival featuring famous artists.', true),
('Tech Expo', 'Tech Arena', '2024-12-15 10:00:00', 'tech_expo.png', 300, 'A technology exhibition showcasing innovations.', true),
('Book Fair', 'City Library', '2024-12-20 09:00:00', 'book_fair.jpg', 200, 'Annual book fair with discounts.', false);
INSERT INTO ticket_types (name_ticket) 
VALUES 
('VIP'), 
('Standard'), 
('Student');
INSERT INTO price_tickets (id_ticket_type, price) 
VALUES 
(1, 150.000), 
(2, 50.000), 
(3, 25.000);
INSERT INTO customers (name_customer, email, phone_number, status_customer) 
VALUES 
('John Doe', 'johndoe@example.com', 123456789, true),
('Jane Smith', 'janesmith@example.com', 987654321, false),
('Alice Brown', 'alicebrown@example.com', 456123789, true);
INSERT INTO customers (id, name_customer, email, phone_number, status_customer) 
VALUES 
(4, 'David Smith', 'david.smith@example.com', 1237890, true),
(5, 'Emily Johnson', 'emily.johnson@example.com', 98710, true),
(6, 'Frank White', 'frank.white@example.com', 4567123, false);
INSERT INTO tickets (id_price, time_book, id_event, id_customer) 
VALUES 
(1, '2024-12-01 10:00:00', 1, 1), 
(2, '2024-12-02 11:00:00', 2, 2), 
(3, '2024-12-03 09:30:00', 3, 3);

INSERT INTO tickets (id_price, time_book, id_event, id_customer) 
VALUES 
(1, '2024-12-01 10:00:00', 1, 1), 
(2, '2024-12-01 11:00:00', 1, 1),  
(3, '2024-12-02 11:00:00', 2, 2), 
(2, '2024-12-02 12:00:00', 2, 2),
(1, '2024-12-03 09:30:00', 3, 3), 
(3, '2024-12-03 10:00:00', 3, 3);
INSERT INTO event_tickets_sale (id_event, id_ticket) 
VALUES 
(1, 1), 
(2, 2), 
(3, 3);

