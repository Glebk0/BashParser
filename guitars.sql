-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Май 27 2017 г., 09:20
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
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `availability`
--

INSERT INTO `availability` (`id`, `model_id`, `quantity`) VALUES
(1, 1, 14),
(2, 2, 19),
(3, 3, 6),
(4, 4, 14),
(5, 5, 8),
(6, 6, 15),
(7, 7, 22),
(8, 8, 25),
(9, 9, 15),
(10, 10, 3),
(11, 11, 11),
(12, 12, 0),
(13, 13, 15),
(14, 14, 23),
(15, 15, 19);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
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
  ADD CONSTRAINT `availability_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `model` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `model`
--
ALTER TABLE `model`
  ADD CONSTRAINT `model_ibfk_1` FOREIGN KEY (`Brand_ID`) REFERENCES `brand` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
