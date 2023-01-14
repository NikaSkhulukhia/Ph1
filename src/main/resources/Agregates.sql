use mydb;

-- This query will retrieve the total number of users for each unique id_number in the Users table, 
-- using the COUNT aggregate function. The result set will include two columns, one for the total number of users and one for the id_number.
SELECT COUNT(Users.id) as total_users, Users.id_number
FROM Users
GROUP BY Users.id_number;

-- This query will retrieve the total sales for each unique id of the users in the Shop_Orders and Users table, 
-- using the SUM aggregate function. The result set will include two columns, one for the total sales and one for the first name of the user.
SELECT SUM(Car_parts.price) as total_sales, Users.first_name
FROM Shop_Orders
INNER JOIN Users ON Shop_Orders.Users_id = Users.id
INNER JOIN Car_parts ON Shop_Orders.car_parts_id = Car_parts.id
GROUP BY Users.id;

-- This query will retrieve the date of the last service for each unique car id in the Service_Orders and Cars table, 
-- using the MAX aggregate function. The query also joins the Brand_models and Car_brands table to retrieve the car brand name and car model name corresponding to each car id. 
-- The result set will include the following columns, one for the date of the last service, one for the car id, one for the car brand name and one for the car model name.
SELECT MAX(Service_Orders.date) as last_service, Cars.id, Car_brands.name as brand_name, Brand_models.name as model_name
FROM Service_Orders
INNER JOIN Cars ON Service_Orders.Cars_id = Cars.id
INNER JOIN Brand_models ON Cars.brand_models_id = Brand_models.id
INNER JOIN Car_brands ON Brand_models.Car_brands_id = Car_brands.id
GROUP BY Cars.id;

-- Description: This query will retrieve the date of the first order for each unique last name of the users in the Shop_Orders and Users table, 
-- using the MIN aggregate function. The result set will include two columns, one for the date of the first order and one for the last name of the user.
SELECT MIN(Shop_Orders.date) as first_order, Users.last_name
FROM Shop_Orders
INNER JOIN Users ON Shop_Orders.Users_id = Users.id
GROUP BY Users.last_name;

-- This query will retrieve the total number of services for each unique car brand name in the Service_Orders, Cars, Brand_models and Car_brands table, 
-- using the COUNT aggregate function. The query joins the Cars, Brand_models and Car_brands table to retrieve the car brand name corresponding to each service order. 
-- The result set will include two columns, one for the total number of services and one for the car brand name.
-- This query can be used to determine the total number of services performed on cars of each brand, which can be useful for analyzing service data 
-- and determining which brands require more maintenance or services.
SELECT COUNT(Service_Orders.id) as total_services, Car_brands.name
FROM Service_Orders
INNER JOIN Cars ON Service_Orders.Cars_id = Cars.id
INNER JOIN Brand_models ON Cars.brand_models_id = Brand_models.id
INNER JOIN Car_brands ON Brand_models.Car_brands_id = Car_brands.id
GROUP BY Car_brands.name;

-- This query will retrieve the total amount spent on each unique car part name in the Shop_Orders and Car_parts table, 
-- by summing the result using the SUM aggregate function. 
-- The result set will include two columns, one for the total amount spent and one for the name of the car part.
SELECT SUM(Car_parts.price) as total_spend, Car_parts.name
FROM Shop_Orders
INNER JOIN Car_parts ON Shop_Orders.car_parts_id = Car_parts.id
GROUP BY Car_parts.name;

-- This query will retrieve the total number of cars for each unique brand model name in the Cars and Brand_models table, 
-- using the COUNT aggregate function. The result set will include two columns, one for the total number of cars and one for the brand model name. 
-- This query can be used to determine the number of cars of each brand model, which can be useful for inventory management and analyzing sales data.
SELECT COUNT(Cars.id) as total_cars, Brand_models.name
FROM Cars
INNER JOIN Brand_models ON Cars.brand_models_id = Brand_models.id
GROUP BY Brand_models.name;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------

-- This query will retrieve the total sales for each unique first name of the users in the Shop_Orders and Users table, 
-- by summing the result using the SUM aggregate function. 
-- It will only return the first names where the total sales is greater than 555. 
-- The result set will include two columns, one for the total sales and one for the first name of the user.
SELECT SUM(Car_parts.price) as total_sales, Users.first_name
FROM Shop_Orders
INNER JOIN Users ON Shop_Orders.Users_id = Users.id
INNER JOIN Car_parts ON Shop_Orders.car_parts_id = Car_parts.id
GROUP BY Users.first_name
HAVING SUM(Car_parts.price) > 555;

-- Description: This query will retrieve the date of the last service for each unique car id in the Service_Orders and Cars table, using the MAX aggregate function. 
-- The query also joins the Brand_models and Car_brands table to retrieve the car brand name and car model name corresponding to each car id. 
-- It will only return the car ids where the date of the last service is before 2020-01-01. 
-- The result set will include the following columns, one for the date of the last service, one for the car id, one for the car brand name and one for the car model name.
SELECT MAX(Service_Orders.date) as last_service, Cars.id, Car_brands.name as brand_name, Brand_models.name as model_name
FROM Service_Orders
INNER JOIN Cars ON Service_Orders.Cars_id = Cars.id
INNER JOIN Brand_models ON Cars.brand_models_id = Brand_models.id
INNER JOIN Car_brands ON Brand_models.Car_brands_id = Car_brands.id
GROUP BY Cars.id
HAVING MAX(Service_Orders.date) < '2020-01-01';

-- Description: This query will retrieve the date of the first order for each unique last name of the users in the Shop_Orders and Users table, using the MIN aggregate function. 
-- It will only return the last names where the date of the first order is after 2019-01-01. 
-- The result set will include two columns, one for the date of the first order and one for the last name of the user.
SELECT MIN(Shop_Orders.date) as first_order, Users.last_name
FROM Shop_Orders
INNER JOIN Users ON Shop_Orders.Users_id = Users.id
GROUP BY Users.last_name
HAVING MIN(Shop_Orders.date) > '2019-01-01';

-- Description: This query will retrieve the total number of services for each unique car brand name in the Service_Orders, Cars, Brand_models and Car_brands table, using the COUNT aggregate function. 
-- It will only return the car brands where the total number of services is greater or equal to 2. 
-- The query joins the Cars, Brand_models and Car_brands table to retrieve the car brand name corresponding to each service order
SELECT COUNT(Service_Orders.id) as total_services, Car_brands.name
FROM Service_Orders
INNER JOIN Cars ON Service_Orders.Cars_id = Cars.id
INNER JOIN Brand_models ON Cars.brand_models_id = Brand_models.id
INNER JOIN Car_brands ON Brand_models.Car_brands_id = Car_brands.id
GROUP BY Car_brands.name
HAVING COUNT(Service_Orders.id) >= 2;

-- This query will retrieve the total number of users for each unique id_number in the Users table, using the COUNT aggregate function. 
-- It will only return the id_numbers where the total number of users is greater than 1. The result set will include two columns, one for the total number of users and one for the id_number. 
-- This query can be used to identify if there are any duplicate id numbers in the Users table.
SELECT COUNT(Users.id) as total_users, Users.id_number
FROM Users
GROUP BY Users.id_number
HAVING COUNT(Users.id) > 1;


-- This query will retrieve the total number of services for each unique user in the Service_Orders and Users table, using the COUNT aggregate function. 
-- It will only return the users who have more than 2 services. The query joins the Users table to retrieve the user's first and last name. 
-- The result set will include three columns, one for the total number of services, one for the user's first name, and one for the user's last name. 
-- This query can be used to determine which users have the most frequent services.
SELECT COUNT(Service_Orders.id) as total_services, Users.first_name, Users.last_name
FROM Service_Orders
INNER JOIN Users ON Service_Orders.Users_id = Users.id
GROUP BY Users.id
HAVING COUNT(Service_Orders.id) > 2;