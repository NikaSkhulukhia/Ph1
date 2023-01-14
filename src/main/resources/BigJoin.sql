SELECT
Users.first_name, 
Users.last_name,
Service_Orders.date as service_date,
Cars.year,
Cars.brand_models_id,
Brand_models.name as model_name,
Brand_models.Car_brands_id,
Car_brands.name as brand_name,
Shop_Orders.date as shop_date
FROM Users
LEFT JOIN Service_Orders ON Users.id = Service_Orders.Users_id
LEFT JOIN Cars ON Service_Orders.Cars_id = Cars.id
LEFT JOIN Brand_models ON Cars.brand_models_id = Brand_models.id
LEFT JOIN Car_brands ON Brand_models.Car_brands_id = Car_brands.id
LEFT JOIN Shop_Orders ON Users.id = Shop_Orders.Users_id

-- This query will retrieve first name, last name, date of the service, year, brand_models_id, model name, car_brands_id, car brand name and date of the order 
-- for all the users in the Users table and the corresponding information from other tables based on the foreign key constraints.
-- The date of service and date of the order will be NULL for those users that don't have a matching record in the Service_Orders and Shop_Orders table respectively.
-- The year, brand_models_id, model name, car_brands_id, car brand name will be NULL for those service_orders without 
-- a match in the Cars, Brand_models and Car_brands table respectively.