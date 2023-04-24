CREATE DATABASE IF NOT EXISTS `TaconDeOro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `TaconDeOro`;

# DROPS
DROP TABLE IF EXISTS `incidencias`, `lineaspedido`, `articulos`, `campanias`, `pedidos`, `rutas`, `empresas`, `tarjetas`, `socios`;

# SOCIOS
CREATE TABLE `socios` (
  `idsocio` int(15) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `poblacion` varchar(50) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `socios` (`nombre`, `correo`, `direccion`, `poblacion`, `contrasenia`, `tipo`) VALUES
('Juan', 'juanito23@gmail.com', 'C/ Norte, 5', 'Alcazar De San Juan', '123garito', 'administrador'),
('Juan', 'juanito23@gmail.com', 'C/ Norte, 5', 'Alcazar De San Juan', '123garito', 'administrador'),
('Juan', 'juanito23@gmail.com', 'C/ Norte, 5', 'Alcazar De San Juan', '123garito', 'administrador');

# TARJETAS
CREATE TABLE `tarjetas` (
  `numero` varchar(50) NOT NULL,
  `idsocio` int(15) NOT NULL,
  PRIMARY KEY (`numero`),
  CONSTRAINT FK_IDSOCIO_TARJETAS FOREIGN KEY (`idsocio`) REFERENCES socios(`idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `tarjetas` (`numero`, `idsocio`) VALUES
('4522122391669024', '1'),
('4522122391669025', '2'),
('4522122391669026', '3');

# EMPRESAS
CREATE TABLE `empresas` (
  `idempresas` int(15) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `cif` varchar(50) NOT NULL,
  `domiciliofiscal` varchar(50) NOT NULL,
  PRIMARY KEY (`idempresas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `empresas` (`nombre`, `cif`, `domiciliofiscal`) VALUES
('alforja', '02999816A', 'suiza'),
('alforja', '02999816A', 'suiza'),
('alforja', '02999816A', 'suiza');

# RUTAS
CREATE TABLE `rutas` (
  `idruta` int(15) NOT NULL AUTO_INCREMENT,
  `areainfluencia` varchar(50) NOT NULL,
  `diasreparto` varchar(50) NOT NULL,
  `idempresa` int(15) NOT NULL,
  PRIMARY KEY (`idruta`),
  CONSTRAINT FK_IDEMPRESA_RUTAS FOREIGN KEY (`idempresa`) REFERENCES empresas(`idempresas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `rutas` (`areainfluencia`, `diasreparto`, `idempresa`) VALUES
('cuenca', 'cinco', '1'),
('cuenca', 'cinco', '2'),
('cuenca', 'cinco', '3');

# PEDIDOS
CREATE TABLE `pedidos` (
  `idpedido` int(15) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` float(50) NOT NULL,
  `idsocio` int(15) NOT NULL,
  `idruta` int(15) NOT NULL,
  PRIMARY KEY (`idpedido`),
  CONSTRAINT FK_IDSOCIO_PEDIDOS FOREIGN KEY (`idsocio`) REFERENCES socios(`idsocio`),
  CONSTRAINT FK_IDRUTA_PEDIDOS FOREIGN KEY (`idruta`) REFERENCES rutas(`idruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
  
INSERT INTO `pedidos` (`fecha`, `total`, `idsocio`, `idruta`) VALUES
('2004-09-04', '40000', '1', '1'),
('2004-09-04', '40000', '2', '2'),
('2004-09-04', '40000', '3', '3');

# CAMPANIAS
CREATE TABLE `campanias` (
  `idcampania` int(15) NOT NULL AUTO_INCREMENT,
  `anio` int(15) NOT NULL,
  `temporada` varchar(50) NOT NULL,
  PRIMARY KEY (`idcampania`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `campanias` (`anio`, `temporada`) VALUES
('2004', 'Primavera Verano'),
('2004', 'Otoño Invierno'),
('2005', 'Primavera Verano');

# ARTICULOS
CREATE TABLE `articulos` (
 `idarticulo` int(15) NOT NULL AUTO_INCREMENT,
 `nombre` varchar(50) NOT NULL,
 `precio` float NOT NULL,
 `descripcion` varchar(200) NOT NULL,
 `material` varchar(50) NOT NULL,
 `stock` int(15) NOT NULL,
 `fotografia` varchar(50) NOT NULL,
 `tipo` varchar(50) NOT NULL,
 `tipozapato` varchar(50) NOT NULL,
 `numerozapato` float NOT NULL,
 `tipobolso` varchar(50) NOT NULL,
 `tallacomplemento` int(15) NOT NULL,
 `idcampania` int(15) NOT NULL,
  PRIMARY KEY (`idarticulo`),
  CONSTRAINT FK_IDCAMPANIA_ARTICULOS FOREIGN KEY (`idcampania`) REFERENCES campanias(`idcampania`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `articulos` (`nombre`, `precio`, `descripcion`, `material`, `stock`, `fotografia`, `tipo`, `tipozapato`, `numerozapato`, `tipobolso`, `tallacomplemento`, `idcampania`) VALUES
('bota', '150', 'bota cr7', 'cuero', '200', 'foto', 'zapato', 'hight', '42', '', '0', '1'),
('collar', '400', 'collar oro', 'oro', '250', 'foto', 'complemento', '', '0', '', '45', '2'),
('Bolso Gucci', '200', 'Bolso pepo', 'piel piton', '300', 'foto', 'bolso', '', '0', 'bolsamen', '0', '3');

# LINEASPEDIDO
CREATE TABLE `lineaspedido` (
  `idpedido` int(15) NOT NULL,
  `idarticulo` int(15) NOT NULL,
  `cantidad` int(15) NOT NULL,
  PRIMARY KEY (`idpedido`, `idarticulo`),
  CONSTRAINT FK_IDPEDIDO_LINEASPEDIDO FOREIGN KEY (`idpedido`) REFERENCES pedidos(`idpedido`),
  CONSTRAINT FK_IDARTICULO_LINEASPEDIDO FOREIGN KEY (`idarticulo`) REFERENCES articulos(`idarticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `lineaspedido` (`idpedido`, `idarticulo`, `cantidad`) VALUES
('1', '1', '200'),
('2', '2', '200'),
('3', '3', '200');

# INCIDENCIAS
CREATE TABLE `incidencias` (
  `idruta` int(15) NOT NULL,
  `idpedido` int(15) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`idruta`, `idpedido`),
  CONSTRAINT FK_IDRUTA_INCIDENCIAS FOREIGN KEY (`idruta`) REFERENCES rutas(`idruta`),
  CONSTRAINT FK_IDPEDIDO_INCIDENCIAS FOREIGN KEY (`idpedido`) REFERENCES pedidos(`idpedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `incidencias` (`idruta`, `idpedido`, `fecha`, `descripcion`) VALUES
('1', '1', '2004-09-04', 'lorem ipsum'),
('2', '2', '2004-09-04', 'lorem ipsum'),
('3', '3', '2004-09-04', 'lorem ipsum');
