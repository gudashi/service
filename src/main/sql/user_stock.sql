CREATE TABLE `user_stock` (
  `user_id` VARCHAR(45) NOT NULL,
  `stock_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`, `stock_id`)
);
