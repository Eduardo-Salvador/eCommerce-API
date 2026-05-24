INSERT INTO categories (name) VALUES
('Electronics'),
('Mobile Devices'),
('Audio Equipment');

INSERT INTO products (category_id, name, description, price, quantity) VALUES
(1, 'Laptop', 'A high-performance laptop for work and gaming.', 999.99, 50),
(2, 'Smartphone', 'A latest model smartphone with advanced features.', 699.99, 100),
(3, 'Headphones', 'Noise-cancelling over-ear headphones.', 199.99, 200);

INSERT INTO customers (first_name, last_name, email) VALUES
('John', 'Doe', 'john_doe@gmail.com'),
('Jane', 'Smith', 'jane_smith@gmail.com'),
('Alice', 'Johnson', 'alice_johnson@gmail.com');

INSERT INTO orders (customer_id, total) VALUES
(1, 1199.98),
(2, 699.99);

INSERT INTO order_items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 999.99),
(1, 3, 1, 199.99),
(2, 2, 1, 699.99);

INSERT INTO reviews (product_id, customer_id, rating, comment) VALUES
(1, 1, 5, 'Excellent laptop! Fast and reliable.'),
(2, 2, 4, 'Great smartphone with good battery life.'),
(3, 3, 3, 'Decent headphones but could be more comfortable.');