-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Июн 13 2017 г., 09:05
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
-- Структура таблицы `availability`
--

CREATE TABLE `availability` (
  `id` int(11) NOT NULL,
  `model_id` int(11) NOT NULL,
  `serial_number` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `availability`
--

INSERT INTO `availability` (`id`, `model_id`, `serial_number`, `status`) VALUES
(1, 1, 225904, 1),
(2, 1, 114052, 1),
(3, 1, 648521, 1),
(4, 1, 654891, 1),
(5, 1, 435824, 1),
(6, 2, 165456, 1),
(7, 2, 115645, 1),
(8, 2, 846351, 1),
(9, 3, 649824, 1),
(10, 3, 926458, 1),
(11, 4, 452896, 1),
(12, 4, 452897, 1),
(13, 4, 397562, 1),
(14, 5, 156879, 1),
(15, 5, 456825, 1),
(16, 6, 697542, 1),
(17, 6, 745632, 1),
(18, 6, 468534, 1),
(19, 7, 456853, 1),
(20, 7, 469825, 1),
(21, 7, 456852, 1),
(22, 8, 458625, 1),
(23, 9, 468524, 1),
(24, 9, 658245, 1),
(25, 10, 753542, 1),
(26, 10, 445825, 1),
(27, 11, 225488, 1),
(28, 11, 785699, 1),
(29, 12, 955246, 1),
(30, 13, 103255, 1),
(31, 13, 125387, 1),
(32, 14, 345852, 1),
(33, 14, 397850, 1),
(34, 15, 112359, 1),
(35, 15, 115866, 1),
(42, 10, 445820, 1),
(43, 11, 225486, 1),
(44, 11, 785692, 1),
(45, 12, 955246, 1),
(46, 13, 103254, 1),
(47, 13, 125386, 1),
(48, 14, 346852, 1),
(49, 14, 397852, 1),
(50, 15, 112358, 1),
(51, 15, 115865, 1);

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
(5, 'Gibson');

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
(15, 5, 'Junior');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `availability`
--
ALTER TABLE `availability`
  ADD PRIMARY KEY (`id`),
  ADD KEY `model_id` (`model_id`);

--
-- Индексы таблицы `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`ID`);

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
-- AUTO_INCREMENT для таблицы `availability`
--
ALTER TABLE `availability`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT для таблицы `brand`
--
ALTER TABLE `brand`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `model`
--
ALTER TABLE `model`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `availability`
--
ALTER TABLE `availability`
  ADD CONSTRAINT `availability_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `model` (`ID`);

--
-- Ограничения внешнего ключа таблицы `model`
--
ALTER TABLE `model`
  ADD CONSTRAINT `model_ibfk_1` FOREIGN KEY (`Brand_ID`) REFERENCES `brand` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
