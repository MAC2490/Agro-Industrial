-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2023 a las 01:19:27
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agro_industrial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cultivos`
--

CREATE TABLE `cultivos` (
  `id_cultivo` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT '',
  `tiempo_cosecha` date DEFAULT NULL,
  `estado` enum('DISPONIBLE','NO DISPONIBLE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cultivos`
--

INSERT INTO `cultivos` (`id_cultivo`, `nombre`, `descripcion`, `tiempo_cosecha`, `estado`) VALUES
(1, 'ASD', 'SADA', '2023-01-15', 'DISPONIBLE'),
(2, 'Tomates', '', '2023-02-20', 'DISPONIBLE'),
(3, 'Trigo', '', '2023-03-10', 'NO DISPONIBLE'),
(4, 'Arroz', '', '2023-04-05', 'DISPONIBLE'),
(5, 'Manzanas', '', '2023-05-15', 'DISPONIBLE'),
(6, 'Uvas', '', '2023-06-20', 'NO DISPONIBLE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cultivos_finca`
--

CREATE TABLE `cultivos_finca` (
  `id_finca` int(11) NOT NULL,
  `id_cultivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cultivos_finca`
--

INSERT INTO `cultivos_finca` (`id_finca`, `id_cultivo`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fincas`
--

CREATE TABLE `fincas` (
  `id_finca` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fincas`
--

INSERT INTO `fincas` (`id_finca`, `nombre`, `direccion`, `img`, `id_usuario`) VALUES
(1, 'Finca B', 'Calle 123, Ciudad', '/img/finca 1.png', NULL),
(2, 'Finca f', 'Avenida XYZ, Pueblo', '/img/finca 1.png', NULL),
(3, 'Finca C', 'Carretera 456, Villa', NULL, 3),
(4, 'Finca D', 'Ruta 789, Pueblo', NULL, 4),
(5, 'Finca E', 'Avenida 456, Ciudad', NULL, 5),
(6, 'Finca F', 'Calle 789, Villa', NULL, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumos`
--

CREATE TABLE `insumos` (
  `insumos_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `serial` int(11) DEFAULT NULL,
  `tipo_insumo` varchar(255) DEFAULT NULL,
  `unidada_medida` varchar(255) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `costo_compra` int(11) DEFAULT NULL,
  `proveedor` varchar(255) DEFAULT NULL,
  `estado` enum('ACTIVO','DESHABILITADO') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `insumos`
--

INSERT INTO `insumos` (`insumos_id`, `name`, `serial`, `tipo_insumo`, `unidada_medida`, `cantidad`, `fecha_compra`, `costo_compra`, `proveedor`, `estado`) VALUES
(1, 'Fertilizante A', 12345, 'Fertilizante', 'Kilos', 100, '2022-12-05', 500, 'Proveedor X', 'ACTIVO'),
(2, 'Semillas B', 67890, 'Semillas', 'Kilos', 50, '2023-01-10', 200, 'Proveedor Y', 'ACTIVO'),
(3, 'Pesticida C', 24680, 'Pesticida', 'Litros', 30, '2022-11-20', 300, 'Proveedor Z', 'ACTIVO'),
(4, 'Herramienta D', 13579, 'Herramienta', 'Unidades', 10, '2023-02-15', 1000, 'Proveedor W', 'ACTIVO'),
(5, 'Abono E', 86420, 'Abono', 'Kilos', 200, '2023-03-20', 800, 'Proveedor V', 'ACTIVO'),
(6, 'Insecticida F', 97531, 'Insecticida', 'Litros', 40, '2023-04-10', 400, 'Proveedor U', 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumos_x_cultivos`
--

CREATE TABLE `insumos_x_cultivos` (
  `id_cultivo` int(11) NOT NULL,
  `id_insumo` int(11) NOT NULL,
  `valor_aprox` int(11) DEFAULT NULL,
  `cantidad_pro` int(11) DEFAULT NULL,
  `unidad_medida` enum('KILOS','ARROBA','GRAMOS','LIBRAS') DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `insumos_x_cultivos`
--

INSERT INTO `insumos_x_cultivos` (`id_cultivo`, `id_insumo`, `valor_aprox`, `cantidad_pro`, `unidad_medida`, `fecha`) VALUES
(1, 1, 10, 1, 'KILOS', '2023-01-05'),
(1, 2, 5, 1, 'KILOS', '2023-01-05'),
(2, 2, 7, 1, 'KILOS', '2023-02-10'),
(3, 3, 8, 1, 'ARROBA', '2023-03-15'),
(4, 4, 15, 1, 'LIBRAS', '2023-04-20'),
(4, 5, 25, 1, 'KILOS', '2023-04-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo_x_finca`
--

CREATE TABLE `insumo_x_finca` (
  `id_finca` int(11) NOT NULL,
  `id_insumo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `insumo_x_finca`
--

INSERT INTO `insumo_x_finca` (`id_finca`, `id_insumo`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produccion_cultivos`
--

CREATE TABLE `produccion_cultivos` (
  `id_produccion` int(11) NOT NULL,
  `cultivos_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `produccion_cultivos`
--

INSERT INTO `produccion_cultivos` (`id_produccion`, `cultivos_id`, `cantidad`, `fecha`, `total`) VALUES
(1, 1, 50, '2023-04-10', 300),
(2, 2, 30, '2023-05-15', 200),
(3, 3, 20, '2023-04-20', 100),
(4, 4, 45, '2023-06-05', 270),
(5, 5, 25, '2023-07-10', 150),
(6, 6, 35, '2023-06-20', 210);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `cedula` char(10) DEFAULT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL,
  `rol` enum('ADMIN','SUPER ADMIN') DEFAULT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `cedula`, `nombre`, `apellido`, `estado`, `rol`, `password`) VALUES
(1, '1', 'Juan Sebastian', 'Pechene Colorado', 'ACTIVO', 'SUPER ADMIN', '1'),
(2, '1088238440', 'Mauricio', 'Aguirre Cardona', 'ACTIVO', 'SUPER ADMIN', '67890'),
(3, '123', 'Sebastian', 'Garcia Murillo', 'ACTIVO', 'SUPER ADMIN', '10293'),
(4, '1090332917', 'Jhon Alberth', 'Aricapa Pinto', 'ACTIVO', 'SUPER ADMIN', '01928'),
(5, '67589031', 'Jairo Alberto', 'Boveda De La  Cruz', 'ACTIVO', 'ADMIN', '55555'),
(6, '1088004610', 'Oscar', 'Java', 'ACTIVO', 'ADMIN', 'TeamJava');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cultivos`
--
ALTER TABLE `cultivos`
  ADD PRIMARY KEY (`id_cultivo`);

--
-- Indices de la tabla `cultivos_finca`
--
ALTER TABLE `cultivos_finca`
  ADD PRIMARY KEY (`id_finca`,`id_cultivo`),
  ADD KEY `id_cultivo` (`id_cultivo`);

--
-- Indices de la tabla `fincas`
--
ALTER TABLE `fincas`
  ADD PRIMARY KEY (`id_finca`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `insumos`
--
ALTER TABLE `insumos`
  ADD PRIMARY KEY (`insumos_id`);

--
-- Indices de la tabla `insumos_x_cultivos`
--
ALTER TABLE `insumos_x_cultivos`
  ADD PRIMARY KEY (`id_cultivo`,`id_insumo`),
  ADD KEY `id_insumo` (`id_insumo`);

--
-- Indices de la tabla `insumo_x_finca`
--
ALTER TABLE `insumo_x_finca`
  ADD PRIMARY KEY (`id_finca`,`id_insumo`),
  ADD KEY `id_insumo` (`id_insumo`);

--
-- Indices de la tabla `produccion_cultivos`
--
ALTER TABLE `produccion_cultivos`
  ADD PRIMARY KEY (`id_produccion`),
  ADD KEY `cultivos_id` (`cultivos_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cultivos`
--
ALTER TABLE `cultivos`
  MODIFY `id_cultivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `fincas`
--
ALTER TABLE `fincas`
  MODIFY `id_finca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `insumos`
--
ALTER TABLE `insumos`
  MODIFY `insumos_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `produccion_cultivos`
--
ALTER TABLE `produccion_cultivos`
  MODIFY `id_produccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cultivos_finca`
--
ALTER TABLE `cultivos_finca`
  ADD CONSTRAINT `cultivos_finca_ibfk_1` FOREIGN KEY (`id_finca`) REFERENCES `fincas` (`id_finca`),
  ADD CONSTRAINT `cultivos_finca_ibfk_2` FOREIGN KEY (`id_cultivo`) REFERENCES `cultivos` (`id_cultivo`);

--
-- Filtros para la tabla `fincas`
--
ALTER TABLE `fincas`
  ADD CONSTRAINT `fincas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `insumos_x_cultivos`
--
ALTER TABLE `insumos_x_cultivos`
  ADD CONSTRAINT `insumos_x_cultivos_ibfk_1` FOREIGN KEY (`id_cultivo`) REFERENCES `cultivos` (`id_cultivo`),
  ADD CONSTRAINT `insumos_x_cultivos_ibfk_2` FOREIGN KEY (`id_insumo`) REFERENCES `insumos` (`insumos_id`);

--
-- Filtros para la tabla `insumo_x_finca`
--
ALTER TABLE `insumo_x_finca`
  ADD CONSTRAINT `insumo_x_finca_ibfk_1` FOREIGN KEY (`id_finca`) REFERENCES `fincas` (`id_finca`),
  ADD CONSTRAINT `insumo_x_finca_ibfk_2` FOREIGN KEY (`id_insumo`) REFERENCES `insumos` (`insumos_id`);

--
-- Filtros para la tabla `produccion_cultivos`
--
ALTER TABLE `produccion_cultivos`
  ADD CONSTRAINT `produccion_cultivos_ibfk_1` FOREIGN KEY (`cultivos_id`) REFERENCES `cultivos` (`id_cultivo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
