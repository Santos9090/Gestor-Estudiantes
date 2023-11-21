-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2023 a las 21:09:08
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `estudiantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Curso` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`ID`, `Nombre`, `Edad`, `Curso`) VALUES
(1, 'Paco Sanz', 15, 'Estafa'),
(2, 'Juan Pérez', 22, 'Matemáticas'),
(3, 'María García', 20, 'Historia'),
(4, 'Luis Rodríguez', 23, 'Inglés'),
(5, 'Ana Torres', 21, 'Ciencias'),
(6, 'Carlos Martínez', 52, 'Geografía'),
(7, 'Laura Gómez', 19, 'Física'),
(8, 'Javier Fernández', 24, 'Química'),
(9, 'Sofía López', 20, 'Literatura'),
(10, 'Daniel Ruiz', 21, 'Biología'),
(11, 'Lucía Castro', 24, 'Economía'),
(12, 'Alejandro Morales', 23, 'Filosofía'),
(13, 'Isabel Herrera', 20, 'Arte'),
(14, 'Manuel Díaz', 22, 'Música'),
(15, 'Elena Flores', 21, 'Programación'),
(16, 'Pedro Ramírez', 20, 'Estadística'),
(17, 'Carmen Vargas', 23, 'Derecho'),
(18, 'Adrián Soto', 22, 'Psicología'),
(19, 'Raquel Ortiz', 20, 'Sociología'),
(20, 'Gonzalo Medina', 24, 'Antropología'),
(21, 'Marina Ramos', 21, 'Medicina'),
(22, 'Héctor Castro', 22, 'Enfermería'),
(23, 'Natalia Gutiérrez', 23, 'Nutrición'),
(24, 'Roberto Torres', 20, 'Odontología'),
(25, 'Verónica Mendoza', 21, 'Veterinaria'),
(26, 'Francisco Ruiz', 23, 'Ingeniería Civi'),
(27, 'Marta Jiménez', 22, 'Ingeniería Eléc'),
(28, 'Antonio Sánchez', 20, 'Ingeniería Mecá'),
(29, 'Silvia Martínez', 21, 'Ingeniería Quím'),
(30, 'David Serrano', 23, 'Ingeniería de S'),
(31, 'Cristina García', 22, 'Arquitectura'),
(32, 'Jorge Rodríguez', 24, 'Diseño Gráfico'),
(33, 'Patricia Navarro', 20, 'Publicidad'),
(34, 'Ricardo Gómez', 21, 'Periodismo'),
(35, 'Beatriz Pérez', 22, 'Comunicación'),
(36, 'Alberto López', 23, 'Marketing'),
(37, 'Eva Fernández', 20, 'Recursos Humano'),
(38, 'Juanita Ramírez', 21, 'Psiquiatría'),
(39, 'Miguel Ángel Díaz', 22, 'Psicoterapia'),
(40, 'Nerea García', 23, 'Terapia Ocupaci'),
(41, 'Ángel Martín', 20, 'Trabajo Social'),
(42, 'Lucas Torres', 22, 'Educación Infan'),
(43, 'María José Herrera', 21, 'Educación Prima'),
(44, 'Gabriel Soto', 23, 'Pedagogía'),
(45, 'Catalina Gutiérrez', 20, 'Psicopedagogía'),
(46, 'Diego Medina', 21, 'Historia del Ar'),
(47, 'Paula Navarro', 22, 'Arqueología'),
(48, 'Roberto Serrano', 23, 'Turismo'),
(49, 'Sandra Jiménez', 20, 'Gastronomía'),
(50, 'Ernesto Martínez', 22, 'Hotelería'),
(51, 'Lorena García', 21, 'Administración '),
(52, 'Pablo Castro', 24, 'Contabilidad'),
(53, 'Mónica López', 23, 'Economía Empres'),
(54, 'Javier Martín', 20, 'Finanzas'),
(55, 'Esther Ramírez', 21, 'Marketing Digit'),
(56, 'Raúl Díaz', 22, 'Comercio Intern'),
(57, 'Juan Pérez', 22, 'Matemáticas'),
(58, 'María García', 20, 'Historia'),
(59, 'Luis Rodríguez', 23, 'Inglés'),
(60, 'Ana Torres', 21, 'Ciencias'),
(61, 'Carlos Martínez', 22, 'Geografía'),
(62, 'Laura Gómez', 19, 'Física'),
(63, 'Javier Fernández', 24, 'Química'),
(64, 'Sofía López', 20, 'Literatura'),
(65, 'Daniel Ruiz', 21, 'Biología'),
(66, 'Lucía Castro', 22, 'Economía'),
(67, 'Alejandro Morales', 23, 'Filosofía'),
(68, 'Isabel Herrera', 20, 'Arte'),
(69, 'Manuel Díaz', 22, 'Música'),
(70, 'Elena Flores', 45, 'Programación'),
(71, 'Pedro Ramírez', 20, 'Estadística'),
(72, 'Carmen Vargas', 23, 'Derecho'),
(73, 'Adrián Soto', 22, 'Psicología'),
(74, 'Raquel Ortiz', 20, 'Sociología'),
(75, 'Gonzalo Medina', 24, 'Antropología'),
(76, 'Marina Ramos', 21, 'Medicina'),
(77, 'Héctor Castro', 22, 'Enfermería'),
(78, 'Natalia Gutiérrez', 23, 'Nutrición'),
(79, 'Roberto Torres', 20, 'Odontología'),
(80, 'Verónica Mendoza', 21, 'Veterinaria'),
(81, 'Francisco Ruiz', 23, 'Ingeniería Civi'),
(82, 'Marta Jiménez', 22, 'Ingeniería Eléc'),
(83, 'Antonio Sánchez', 20, 'Ingeniería Mecá'),
(84, 'Silvia Martínez', 21, 'Ingeniería Quím'),
(85, 'David Serrano', 23, 'Ingeniería de S'),
(86, 'Cristina García', 22, 'Arquitectura'),
(87, 'Jorge Rodríguez', 24, 'Diseño Gráfico'),
(88, 'Patricia Navarro', 20, 'Publicidad'),
(89, 'Ricardo Gómez', 21, 'Periodismo'),
(90, 'Beatriz Pérez', 22, 'Comunicación'),
(91, 'Alberto López', 23, 'Marketing'),
(92, 'Eva Fernández', 20, 'Recursos Humano'),
(93, 'Juanita Ramírez', 21, 'Psiquiatría'),
(94, 'Miguel Ángel Díaz', 22, 'Psicoterapia'),
(95, 'Nerea García', 23, 'Terapia Ocupaci'),
(96, 'Ángel Martín', 20, 'Trabajo Social'),
(97, 'Lucas Torres', 22, 'Educación Infan'),
(98, 'María José Herrera', 21, 'Educación Prima'),
(99, 'Gabriel Soto', 23, 'Pedagogía'),
(100, 'Catalina Gutiérrez', 20, 'Psicopedagogía'),
(101, 'Diego Medina', 21, 'Historia del Ar'),
(102, 'Paula Navarro', 22, 'Arqueología'),
(103, 'Roberto Serrano', 23, 'Turismo'),
(104, 'Sandra Jiménez', 20, 'Gastronomía'),
(105, 'Ernesto Martínez', 22, 'Hotelería'),
(106, 'Lorena García', 21, 'Administración '),
(107, 'Pablo Castro', 24, 'Contabilidad'),
(108, 'Mónica López', 23, 'Economía Empres'),
(109, 'Javier Martín', 20, 'Finanzas'),
(110, 'Esther Ramírez', 21, 'Marketing Digit'),
(111, 'Raúl Díaz', 22, 'Comercio Intern'),
(112, 'Celia Sánchez', 20, 'Derecho Empresa');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
