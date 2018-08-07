-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5280
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table books.author
CREATE TABLE IF NOT EXISTS `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='справочник авторов';

-- Data exporting was unselected.
-- Dumping structure for table books.book
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `short_description` varchar(256) NOT NULL,
  `description` text NOT NULL,
  `ISBN` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='информация о книге';

-- Data exporting was unselected.
-- Dumping structure for table books.book_author
CREATE TABLE IF NOT EXISTS `book_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book_author_book` (`book_id`),
  KEY `FK_book_author_author` (`author_id`),
  CONSTRAINT `FK_book_author_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FK_book_author_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица соответствия авторов книгам. У одной книги может быть несколько авторов. У одного автора может быть несколько книг.';

-- Data exporting was unselected.
-- Dumping structure for table books.book_genre
CREATE TABLE IF NOT EXISTS `book_genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book_genre_book` (`book_id`),
  KEY `FK_book_genre_genre` (`genre_id`),
  CONSTRAINT `FK_book_genre_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK_book_genre_genre` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table books.genre
CREATE TABLE IF NOT EXISTS `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL COMMENT 'название жанра',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='жанр';

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
