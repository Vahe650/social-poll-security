CREATE TABLE `polls` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number` bigint DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `poll_id` bigint DEFAULT NULL,
  `question_type`  enum('SINGLE','MULTIPLE','TEXT') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs9uu0i9ipek2tnqty4ohdek27` (`poll_id`),
  CONSTRAINT `FKs9uu0i9ipek2tnqty4ohdek27` FOREIGN KEY (`poll_id`) REFERENCES `polls` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type`  enum('ADMIN','USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `choices` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs9uu0i9ipek2tnqty4ohdek26` (`question_id`),
  CONSTRAINT `FKs9uu0i9ipek2tnqty4ohdek26` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `answers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `text_value` varchar(255) DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs9uu0i9ipek2tnqty4ohdek25` (`question_id`),
  CONSTRAINT `FKs9uu0i9ipek2tnqty4ohdek25` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `answer_choices` (
  `answer_id` bigint NOT NULL,
  `choice_id` bigint NOT NULL,
  KEY `answer_id` (`answer_id`),
  KEY `choice_id` (`choice_id`),
  CONSTRAINT `answer_choice_ibfk_1` FOREIGN KEY (`answer_id`) REFERENCES `answers` (`id`),
  CONSTRAINT `answer_choice_ibfk_2` FOREIGN KEY (`choice_id`) REFERENCES `choices` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
