-- delete from Shops where id = 4;
-- delete from Shops where id = 5;
-- delete from Shops where id = 6;

# insertions in the shops table
INSERT INTO mydb.Shops (name, address) VALUES ('Auto Shop A', '123 Main St');
INSERT INTO mydb.Shops (name, address) VALUES ('Auto Shop B', '456 Park Ave');
INSERT INTO mydb.Shops (name, address) VALUES ('Auto Shop C', '789 Elm St');

# insertion in the users table
INSERT INTO mydb.Users (first_name, last_name, id_number, phone) VALUES ('John', 'Doe', '123456789', '555-555-5555');
INSERT INTO mydb.Users (first_name, last_name, id_number, phone) VALUES ('Jane', 'Smith', '987654321', '555-555-5556');
INSERT INTO mydb.Users (first_name, last_name, id_number, phone) VALUES ('Bob', 'Johnson', '111111111', '555-555-5557');
INSERT INTO mydb.Users (first_name, last_name, id_number, phone) VALUES ('Amy', 'Williams', '222222222', '555-555-5558');
INSERT INTO mydb.Users (first_name, last_name, id_number, phone) VALUES ('Michael', 'Jones', '333333333', '555-555-5559');

# insertion in the car_brands table
INSERT INTO mydb.Car_brands (name) VALUES ('Ford');
INSERT INTO mydb.Car_brands (name) VALUES ('Chevrolet');
INSERT INTO mydb.Car_brands (name) VALUES ('Toyota');
INSERT INTO mydb.Car_brands (name) VALUES ('Honda');
INSERT INTO mydb.Car_brands (name) VALUES ('Tesla');

# insertion in the brand_models table
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('F-150', 1);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Mustang', 1);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Camaro', 2);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Silverado', 2);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Corolla', 3);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Prius', 3);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Civic', 4);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Accord', 4);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Model S', 5);
INSERT INTO mydb.Brand_models (name, Car_brands_id) VALUES ('Model Y', 5);

# insertion in the cars table
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2022-01-01', 1, 1, 1);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2021-01-01', 2, 2, 3);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2020-01-01', 3, 3, 5);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2019-01-01', 4, 4, 7);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2018-01-01', 5, 5, 9);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2022-01-01', 1, 2, 4);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2021-01-01', 2, 3, 6);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2020-01-01', 3, 4, 8);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2019-01-01', 4, 5, 10);
INSERT INTO mydb.Cars (year, user_id, Car_brands_id, Brand_Models_id) VALUES ('2018-01-01', 5, 1, 2);

# insertion in the car_part_categories table
INSERT INTO mydb.Car_part_categories (name) VALUES ('Engine');
INSERT INTO mydb.Car_part_categories (name) VALUES ('Transmission');
INSERT INTO mydb.Car_part_categories (name) VALUES ('Suspension');

# insertion in the car_parts table
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Engine Block', 'E12345', '1000', 1, 1);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Transmission Gear', 'T67890', '800', 2, 2);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Suspension Coil', 'S11111', '500', 3, 3);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Engine Piston', 'E22222', '200', 1, 1);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Transmission Fluid', 'T33333', '50', 2, 2);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Suspension Strut', 'S44444', '300', 3, 3);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Engine Oil Filter', 'E55555', '20', 1, 1);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Brakes', 'A8B9C7', '120.99', 2, 1);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Brake Pad', 'F6G5H4', '150.49', 2, 2);
INSERT INTO mydb.Car_parts (name, serial_number, price, Car_part_categories_id, Shops_id) VALUES ('Oil Sensor', 'J3K2L1', '99.99', 1, 3);

# insertion in the service_stations table
INSERT INTO mydb.Service_stations (name, address) VALUES ('Service Station A', '123 Main St');
INSERT INTO mydb.Service_stations (name, address) VALUES ('Service Station B', '456 Park Ave');
INSERT INTO mydb.Service_stations (name, address) VALUES ('Service Station C', '789 Elm St');
INSERT INTO mydb.Service_stations (name, address) VALUES ('Service Station D', '111 Oak St');

# insertion in the shop_orders table
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (1, 1, 1, '2022-01-01 10:00:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (2, 2, 2, '2022-02-01 11:00:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (3, 3, 3, '2022-03-01 10:20:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (4, 1, 4, '2022-04-01 10:10:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (5, 2, 5, '2022-05-01 11:10:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (1, 3, 6, '2022-06-01 11:40:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (2, 1, 7, '2022-07-01 12:20:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (3, 2, 8, '2022-08-01 12:25:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (4, 3, 9, '2022-09-01 12:10:00');
INSERT INTO mydb.Shop_orders (Users_id, Shops_id, Car_Parts_id, date) VALUES (5, 1, 10, '2022-10-01 11:20:00');

# insertion in the car_services table
INSERT INTO mydb.Car_services (name, price) VALUES ('Oil Change', '50');
INSERT INTO mydb.Car_services (name, price) VALUES ('Tire Rotation', '40');
INSERT INTO mydb.Car_services (name, price) VALUES ('Brake Pad Replacement', '100');
INSERT INTO mydb.Car_services (name, price) VALUES ('Battery Replacement', '80');
INSERT INTO mydb.Car_services (name, price) VALUES ('Air Filter Replacement', '20');
INSERT INTO mydb.Car_services (name, price) VALUES ('Radiator Flush', '50');

# insertion in the service_orders table
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (1, 1, 1, '2022-01-01 10:00:00', 1);
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (2, 2, 2, '2022-02-01 10:00:00', 2);
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (3, 3, 3, '2022-03-01 10:00:00', 3);
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (1, 4, 4, '2022-04-01 10:00:00', 4);
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (2, 5, 5, '2022-05-01 10:00:00', 5);
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (3, 6, 6, '2022-06-01 10:00:00', 1);
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (1, 7, 1, '2022-07-01 10:00:00', 2);
INSERT INTO mydb.Service_orders (Service_Stations_id, Cars_id, Car_Services_id, date, Users_id) VALUES (2, 8, 2, '2022-08-01 10:00:00', 3);

# insertion in the model_parts_compatibility table
INSERT INTO mydb.Models_parts_compatibility (Brand_Models_id, Car_Parts_id) VALUES (1, 1);
INSERT INTO mydb.Models_parts_compatibility (Brand_Models_id, Car_Parts_id) VALUES (2, 2);
INSERT INTO mydb.Models_parts_compatibility (Brand_Models_id, Car_Parts_id) VALUES (3, 3);
INSERT INTO mydb.Models_parts_compatibility (Brand_Models_id, Car_Parts_id) VALUES (1, 4);
INSERT INTO mydb.Models_parts_compatibility (Brand_Models_id, Car_Parts_id) VALUES (2, 5);
INSERT INTO mydb.Models_parts_compatibility (Brand_Models_id, Car_Parts_id) VALUES (3, 6);
INSERT INTO mydb.Models_parts_compatibility (Brand_Models_id, Car_Parts_id) VALUES (1, 7);


-- select * from Shops;
select * from Car_parts;