# joins

# use db
use mydb;

# left
SELECT Cars.id, Cars.year, Cars.user_id, Cars.Car_brands_id, Cars.Brand_Models_id, Users.first_name, Users.last_name
FROM mydb.Cars
LEFT JOIN mydb.Users ON Cars.user_id = Users.id;

SELECT Users.id, Users.first_name, Users.last_name, Users.id_number, Users.phone, Cars.year, Cars.Car_brands_id, Cars.Brand_Models_id
FROM mydb.Users
LEFT JOIN mydb.Cars ON Users.id = Cars.user_id;

SELECT u.id, u.first_name, u.last_name, u.id_number, u.phone, cb.name, bm.name, c.year
FROM mydb.Users u
LEFT JOIN mydb.Cars c ON u.id = c.user_id
LEft JOIN mydb.Car_brands cb ON c.Car_brands_id = cb.id
LEft JOIN mydb.Brand_models bm ON c.Brand_Models_id = bm.id;

SELECT Service_stations.id, Service_stations.name, Service_stations.address, Service_orders.date, Car_services.name, Car_brands.name, Brand_models.name
FROM mydb.Service_stations
LEFT JOIN mydb.Service_orders ON Service_stations.id = Service_orders.Service_Stations_id
LEFT JOIN mydb.Cars ON Service_orders.Cars_id = Cars.id
LEFT JOIN mydb.Car_brands ON Cars.Car_brands_id = Car_brands.id
LEFT JOIN mydb.Brand_models ON Cars.Brand_Models_id = Brand_models.id
LEFT JOIN mydb.Car_services ON Service_orders.Car_Services_id = Car_services.id;

SELECT Brand_models.id, Brand_models.name, Brand_models.Car_brands_id, Car_parts.name, Models_parts_compatibility.Car_Parts_id
FROM mydb.Brand_models
LEFT JOIN mydb.Models_parts_compatibility ON Brand_models.id = Models_parts_compatibility.Brand_Models_id
LEFT JOIN mydb.Car_parts ON Models_parts_compatibility.Car_Parts_id = Car_parts.id;

SELECT Car_part_categories.id, Car_part_categories.name, Car_parts.name, Shops.name
FROM mydb.Car_part_categories
LEFT JOIN mydb.Car_parts ON Car_part_categories.id = Car_parts.Car_part_categories_id
LEFT JOIN mydb.Shops ON Car_parts.Shops_id = Shops.id;

# right
SELECT Users.id, Users.first_name, Users.last_name, Users.id_number, Users.phone, Cars.year, Cars.Car_brands_id, Cars.Brand_Models_id
FROM mydb.Users
right JOIN mydb.Cars ON Users.id = Cars.user_id;

SELECT Cars.id, Cars.year, Cars.user_id, Cars.Car_brands_id, Cars.Brand_Models_id, Users.first_name, Users.last_name
FROM mydb.Cars
right JOIN mydb.Users ON Cars.user_id = Users.id;

SELECT * FROM Users
RIGHT JOIN Service_Orders
ON Users.id = Service_Orders.Users_id;

SELECT * FROM Cars
RIGHT JOIN Service_Orders
ON Cars.id = Service_Orders.Cars_id;

SELECT * FROM Users
RIGHT JOIN Shop_Orders
ON Users.id = Shop_Orders.Users_id;

-- This statement will retrieve first name, last name, car brand, car model, and year of the car for all the users and cars in the Cars table.
-- It will also include any users and cars that don't have a matching record in the Service_Orders table, 
-- by using RIGHT JOIN on the Users table and LEFT JOIN on the Car_brands and Brand_models tables.
SELECT Users.first_name, Users.last_name, Car_brands.name, Brand_models.name, Cars.year
FROM Users
RIGHT JOIN Cars
ON Users.id = Cars.User_id
LEFT JOIN Brand_models
ON Cars.Brand_models_id = Brand_models.id
LEFT JOIN Car_brands
ON Brand_models.Car_brands_id = Car_brands.id;

# inner
SELECT Users.id, Users.first_name, Users.last_name, Users.id_number, Users.phone, Cars.year, Cars.Car_brands_id, Cars.Brand_Models_id
FROM mydb.Users
inner JOIN mydb.Cars ON Users.id = Cars.user_id;

SELECT Users.first_name, Users.last_name, Service_Orders.Car_Services_id, Service_Orders.date
FROM Users
INNER JOIN Service_Orders
ON Users.id = Service_Orders.Users_id;

SELECT Cars.year, Cars.brand_models_id, Brand_models.name, Brand_models.Car_brands_id, Car_brands.name
FROM Cars
INNER JOIN Brand_models
ON Cars.brand_models_id = Brand_models.id
INNER JOIN Car_brands
ON Brand_models.Car_brands_id = Car_brands.id;

SELECT Users.first_name, Users.last_name, Shop_Orders.Car_Parts_id, Shop_Orders.date
FROM Users
INNER JOIN Shop_Orders
ON Users.id = Shop_Orders.Users_id;

SELECT Service_Orders.Car_Services_id, Service_Orders.date, Cars.year, Cars.brand_models_id
FROM Service_Orders
INNER JOIN Cars
ON Service_Orders.Cars_id = Cars.id;
