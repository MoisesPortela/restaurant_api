ALTER TABLE orders ADD active tinyint;
UPDATE orders SET active=1;