USE `employee_dir`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users`
VALUES
('jana','{bcrypt}$2a$10$don4Swf9EZQOKV9si1g6rOgFRquxtO.TcXkUEPThFuXN914wjPSyS',1),
('shiva','{bcrypt}$2a$10$SQ1xRQP/Z7IhJ27wuQXyM.HKVjN4OuNQAYk7G77Ya.9UQWN.JbNvi',1),
('vardan','{bcrypt}$2a$10$xZKjQnh4VS6R2Pcy7PrY6.ZDSXvkoD6eS49aZnC5Hnw/c8VO/L2P.',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('jana','ROLE_EMPLOYEE'),
('shiva','ROLE_EMPLOYEE'),
('shiva','ROLE_MANAGER'),
('vardan','ROLE_EMPLOYEE'),
('vardan','ROLE_MANAGER'),
('vardan','ROLE_ADMIN');


