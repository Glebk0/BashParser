-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Июн 20 2017 г., 08:23
-- Версия сервера: 5.5.23
-- Версия PHP: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `guitars`
--

-- --------------------------------------------------------

--
-- Структура таблицы `brand`
--

CREATE TABLE `brand` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `brand`
--

INSERT INTO `brand` (`ID`, `Name`) VALUES
(1, 'Martin'),
(2, 'Taylor'),
(3, 'Takamine'),
(4, 'Guild'),
(5, 'Deep');

-- --------------------------------------------------------

--
-- Структура таблицы `description`
--

CREATE TABLE `description` (
  `id` int(11) NOT NULL,
  `serial_number` int(11) NOT NULL,
  `model_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(30) NOT NULL,
  `color` varchar(30) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `description`
--

INSERT INTO `description` (`id`, `serial_number`, `model_id`, `price`, `type`, `color`, `status`) VALUES
(1, 101, 1, 450, 'Acoustic', 'Black', 0),
(2, 102, 1, 420, 'Acoustic', 'White', 1),
(3, 103, 2, 600, 'Acoustic', 'Black', 1),
(4, 104, 2, 630, 'Acoustic', 'White', 1),
(5, 105, 3, 1000, 'Electro', 'Coral', 1),
(6, 106, 3, 1200, 'Electro', 'Blue', 1),
(7, 107, 4, 360, 'Acoustic', 'White', 1),
(8, 108, 4, 360, 'Acoustic', 'Yellow', 0),
(9, 109, 5, 520, 'Acoustic', 'Black', 1),
(10, 110, 5, 525, 'Acoustic', 'Red', 1),
(11, 111, 6, 399, 'Acoustic', 'White', 1),
(12, 112, 6, 422, 'Acoustic', 'Grey', 1),
(13, 113, 7, 900, 'Electro', 'White', 1),
(14, 114, 7, 980, 'Electro', 'Fire Spray', 1),
(15, 115, 8, 990, 'Electro-acoustic', 'White', 1),
(16, 116, 8, 990, 'Electro-acoustic', 'Yellow', 1),
(17, 117, 9, 450, 'Acoustic', 'White', 1),
(18, 118, 9, 450, 'Acoustic', 'Dark yellow', 1),
(19, 119, 10, 500, 'Acoustic', 'White', 1),
(20, 120, 10, 555, 'Acoustic', 'Brown', 1),
(21, 121, 11, 400, 'Acoustic', 'White', 1),
(22, 122, 11, 400, 'Acoustic', 'Black', 1),
(23, 123, 12, 320, 'Acoustic', 'White', 1),
(24, 124, 12, 325, 'Acoustic', 'Orange', 1),
(25, 125, 13, 550, 'Acoustic', 'White', 1),
(26, 126, 13, 550, 'Acoustic', 'Purple', 1),
(27, 127, 14, 800, 'Electro', 'Black', 1),
(28, 128, 14, 780, 'Electro', 'Blue', 1),
(29, 129, 15, 415, 'Acoustic', 'White', 1),
(30, 130, 15, 430, 'Acoustic', 'Smoke on the water', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `model`
--

CREATE TABLE `model` (
  `ID` int(11) NOT NULL,
  `Brand_ID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `model`
--

INSERT INTO `model` (`ID`, `Brand_ID`, `Name`) VALUES
(1, 1, 'Navojoa'),
(2, 1, 'OMXAE BLACK'),
(3, 1, 'Sikamore'),
(4, 2, 'Academy'),
(5, 2, 'MiniBoss'),
(6, 2, 'Rosewood'),
(7, 3, 'Dreadnought'),
(8, 3, 'Classical'),
(9, 3, 'Nat'),
(10, 4, 'Vintage'),
(11, 4, 'Antique'),
(12, 4, 'Troubadour'),
(13, 5, 'GoldTop'),
(14, 5, 'Custom'),
(15, 5, 'Purple');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `description`
--
ALTER TABLE `description`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `serial_number` (`serial_number`),
  ADD KEY `model_id` (`model_id`);

--
-- Индексы таблицы `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Brand_id` (`Brand_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `brand`
--
ALTER TABLE `brand`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `description`
--
ALTER TABLE `description`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT для таблицы `model`
--
ALTER TABLE `model`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `description`
--
ALTER TABLE `description`
  ADD CONSTRAINT `description_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `model` (`ID`);

--
-- Ограничения внешнего ключа таблицы `model`
--
ALTER TABLE `model`
  ADD CONSTRAINT `model_ibfk_1` FOREIGN KEY (`Brand_ID`) REFERENCES `brand` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
