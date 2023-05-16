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
('Arturo', 'arturonb51236@gmail.com', 'C/ Pesetas, 64', 'Tomelloso', '123garito', 'admin'),
('Felix', 'felisucojunior@gmail.com', 'C/ Norte, 13', 'Alcázar de San Juan', '123garito', 'admin'),
('Javier', 'javive2004vehiculos@gmail.com', 'C/ Montesinos, 7', 'Arenales de San Gregorio', '123garito', 'admin'),
('Enrique', 'kryke10@gmail.com', 'C/ Cervantes, 33', 'Alcázar de San Juan', '123garito', 'admin'),
('Carlos', 'dawcarlospereira@gmail.com', 'Av. Los Enterradores, 108', 'Alcázar de San Juan', '123garito', 'admin'),
('Julián', 'julitoherrera443@gmail.com', 'C/ Mostoles, 22', 'Torrent', 'puñetapuñeta4', 'socio'),
('Pedro', 'pedrosalinas5@gmail.com', 'C/ Torreznos, 40', 'Barcelona', 'porlaraza##', 'mozo');

# TARJETAS
CREATE TABLE `tarjetas` (
  `numero` varchar(50) NOT NULL,
  `idsocio` int(15) NOT NULL,
  PRIMARY KEY (`numero`),
  CONSTRAINT FK_IDSOCIO_TARJETAS FOREIGN KEY (`idsocio`) REFERENCES socios(`idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `tarjetas` (`numero`, `idsocio`) VALUES
('6252411494821632-12/26-432', '2');

# EMPRESAS
CREATE TABLE `empresas` (
  `idempresas` int(15) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `cif` varchar(50) NOT NULL,
  `domiciliofiscal` varchar(50) NOT NULL,
  PRIMARY KEY (`idempresas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `empresas` (`nombre`, `cif`, `domiciliofiscal`) VALUES
('CONTOM', '02999816A', 'España'),
('Gastrom Ltd.', '05952174J', 'Suiza'),
('Hi-Shoes', '02645723H', 'Estonia');

# RUTAS
CREATE TABLE `rutas` (
  `idruta` int(15) NOT NULL AUTO_INCREMENT,
  `areainfluencia` varchar(200) NOT NULL,
  `diasreparto` varchar(50) NOT NULL,
  `idempresa` int(15) NOT NULL,
  PRIMARY KEY (`idruta`),
  CONSTRAINT FK_IDEMPRESA_RUTAS FOREIGN KEY (`idempresa`) REFERENCES empresas(`idempresas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `rutas` (`areainfluencia`, `diasreparto`, `idempresa`) VALUES
('Los Barrios, Algeciras, El Pelayo, El Bujeo, Tarifa', '1-30', '1'),
('Tomelloso, Alcázar de San Juan, Manzanares, La Solana, Villarrobledo, Villacañas', '1-15', '2'),
('Cheste, Ribarroja de Turia, Torrent, Manises, Silla, Valencia', '15-30', '3');

# PEDIDOS
CREATE TABLE `pedidos` (
  `idpedido` int(15) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` float(50) NOT NULL,
  `idsocio` int(15) NOT NULL,
  `idruta` int(15) NOT NULL,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`idpedido`),
  CONSTRAINT FK_IDSOCIO_PEDIDOS FOREIGN KEY (`idsocio`) REFERENCES socios(`idsocio`),
  CONSTRAINT FK_IDRUTA_PEDIDOS FOREIGN KEY (`idruta`) REFERENCES rutas(`idruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
  
INSERT INTO `pedidos` (`fecha`, `total`, `idsocio`, `idruta`, `estado`) VALUES
('2023-04-23', '1300', '1', '1', 'pendiente'),
('2022-09-12', '7000', '2', '2', 'pendiente'),
('2022-12-01', '13000', '3', '3', 'pendiente');

# CAMPANIAS
CREATE TABLE `campanias` (
  `idcampania` int(15) NOT NULL AUTO_INCREMENT,
  `anio` int(15) NOT NULL,
  `temporada` varchar(50) NOT NULL,
  PRIMARY KEY (`idcampania`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `campanias` (`anio`, `temporada`) VALUES
('2021', 'Primavera/Verano'),
('2021', 'Otoño/Invierno'),
('2022', 'Primavera/Verano'),
('2022', 'Otoño/Invierno');

# ARTICULOS
CREATE TABLE `articulos` (
 `idarticulo` int(15) NOT NULL AUTO_INCREMENT,
 `nombre` varchar(50) NOT NULL,
 `precio` float NOT NULL,
 `descripcion` varchar(200) NOT NULL,
 `material` varchar(50) NOT NULL,
 `stock` int(15) NOT NULL,
 `fotografia` varchar(50) NOT NULL,
 `tipozapato` varchar(50),
 `numerozapato` float,
 `tipobolso` varchar(50),
 `tallacomplemento` int(15),
 `idcampania` int(15) NOT NULL,
  PRIMARY KEY (`idarticulo`),
  CONSTRAINT FK_IDCAMPANIA_ARTICULOS FOREIGN KEY (`idcampania`) REFERENCES campanias(`idcampania`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `articulos` (`nombre`, `precio`, `descripcion`, `material`, `stock`, `fotografia`, `tipozapato`, `numerozapato`, `tipobolso`, `tallacomplemento`, `idcampania`) VALUES
('Nike Performance Mercurial Vapor 15', '60', 'Botas de fútbol con tacos blancas', 'Fibra', '100', 'nikeperfomancemv15.png', 'Fútbol', '42', NULL, NULL, '1'),
('Vivienne Westwood Colette Pendant', '125', 'Collar color platino de latón', 'Latón', '10', 'viviennewestwoodcp.png', NULL, NULL, NULL, '40', '2'),
('Guess Nell Reversible Adjust Belt', '40', 'Cinturón estampado con cierre de hebilla de placa', 'Cuero Sintético', '500', 'guessnellrab.png', NULL, NULL, NULL, '80', '2'),
('Gucci Tote Ophidia', '1390', 'Bolso universo de Ophidia con lana GG', 'Piel y Lana GG', '30', 'toteophidiag.png', NULL, NULL, 'Aplique doble asa', NULL, '3');

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
('1', '1', '2023-04-25', 'El camión encargado del transporte ha tenido una avería en la A4');
