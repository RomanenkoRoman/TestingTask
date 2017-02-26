CREATE DATABASE play
WITH
OWNER = postgres
ENCODING = 'UTF8'
LC_COLLATE = 'Russian_Russia.1251'
LC_CTYPE = 'Russian_Russia.1251'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;

INSERT INTO note (id, achar, date, integer, varchar) VALUES
  (99999, '%', '2012-12-12', 148, 'one'),
  (99998, '*', '2028-12-12', 124, 'two'),
  (99997, '&', '2064-12-12', 2, 'three'),
  (99996, '^', '2021-12-12', 3432, 'four'),
  (99995, ')', '2001-12-12', 34, 'five'),
  (99994, '#', '1990-12-12', 654, 'six'),
  (99993, ':', '1844-12-12', 723, 'seven'),
  (99992, '=', '1956-12-12', 5, 'eight'),
  (99991, '@', '1900-12-12', 46, 'nine'),
  (99990, 'V', '2200-12-12', 34643, 'ten'),
  (99989, '\', '1909-12-12', 523, 'eleven'),
  (99988, '}', '1906-12-12', 543, 'twelve'),
  (99987, '|', '2007-12-12', 2234, 'thirteen'),
  (99986, '$', '2016-12-12', 765, 'fourteen'),
  (99985, '!', '2017-12-12', 237, 'fifteen'),
  (99984, '^', '2203-12-12', 843, 'sixteen'),
  (99983, '*', '2019-12-12', 5623, 'seventeen'),
  (99982, '$', '2012-12-12', 456, 'eighteen');