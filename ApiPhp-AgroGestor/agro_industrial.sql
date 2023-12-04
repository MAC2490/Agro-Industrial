CREATE TABLE `cultivos` (
  `id_cultivo` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT '',
  `tiempo_cosecha` date DEFAULT NULL,
  `estado` enum('DISPONIBLE','NO DISPONIBLE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `cultivos_finca` (
  `id_finca` int(11) NOT NULL,
  `id_cultivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `fincas` (
  `id_finca` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


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

CREATE TABLE `insumos_x_cultivos` (
  `id_cultivo` int(11) NOT NULL,
  `id_insumo` int(11) NOT NULL,
  `valor_aprox` int(11) DEFAULT NULL,
  `cantidad_pro` int(11) DEFAULT NULL,
  `unidad_medida` enum('KILOS','ARROBA','GRAMOS','LIBRAS') DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `insumo_x_finca` (
  `id_finca` int(11) NOT NULL,
  `id_insumo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `produccion_cultivos` (
  `id_produccion` int(11) NOT NULL,
  `cultivos_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `cedula` char(10) DEFAULT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL,
  `rol` enum('ADMIN','SUPER ADMIN') DEFAULT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
