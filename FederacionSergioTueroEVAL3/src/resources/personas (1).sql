-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-03-2022 a las 21:00:08
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdfederacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `nifnie` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nifnie` (`nifnie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `nombre`, `telefono`, `nifnie`) VALUES
(1, 'Jesus Perez Garcia', '697032897', '68901414SS'),
(2, 'Carlos Fernandez Avia', '685432819', 'Y4715841GG'),
(3, 'Luis Martinez Diaz', '695342871', '18190036AA'),
(4, 'Carmen Corrales Vega', '645532881', '17423141CC'),
(5, 'Daniel Ruiz Blanco', '921342819', '36038981MM'),
(6, 'Pedro Gonzalez Puig', '690552712', '45957238HH'),
(7, 'Martin Ibarra Encina', '683542893', 'X5543403NN'),
(8, 'Dinia Pino Novell', '685302577', '97053397KK'),
(9, 'Maria Frisuelos Ruiz', '605437884', '25601151NN'),
(10, 'Hector Garcia Perez', '607332815', '78329739LL'),
(11, 'Carmen Perez Foz', '945707801', 'Z1569047SS'),
(12, 'Francisco Plaza Ayuso', '694432818', '13099318JJ'),
(13, 'Maria Jesus Perez Salinas', '635714801', '91010023NN'),
(14, 'Laura Castro Llorente', '695432805', 'Z6917035CC'),
(15, 'Gabriela del Rio Severo', '681232816', '46785000XX'),
(16, 'Carla Gallo Pedroso', '687342207', 'Y9935495SS'),
(17, 'Alberto Perez Lago', '695382349', '59128588GG'),
(18, 'Aser Linares Nobel', '685337834', 'Z6738297SS'),
(19, 'Daniel Suarez Melano', '680734341', '62441986EE'),
(20, 'Raquel Gonzalez Banda', '985334823', '87886112FF'),
(21, 'Maria Calvo Egea', '930332814', 'Z1989983MM'),
(22, 'Hugo Blasco Rato', '684035810', 'Z1219264QQ'),
(23, 'Andrés Martinez Real', '671332800', '22419476LL'),
(24, 'Raul Velazquez Garcia', '690352881', '60764599WW'),
(25, 'Asuncion Garcia Perez', '603330818', '02381923CC'),
(26, 'Juan Jesus Ruiz Volantes', '620932819', 'Z5601650MM'),
(27, 'Cecilio Gallo Garcia', '684012713', 'Z8962289EE'),
(28, 'Sandra Vega Cuena', '605384817', 'Y9896107AA'),
(29, 'Sergio Poo Martinez', '608332113', 'X1092620MM'),
(30, 'Pedro Toca Gutierrez', '985432713', '58277243GG'),
(31, 'Borja Perez Suarez', '680332801', '23868652BB'),
(32, 'Ander Santos Higuera', '682452807', '14523337XX'),
(33, 'Dominica Gonzalez Perez', '650237810', '70933798GG'),
(34, 'Laura Suarez Blasco', '680345912', 'Z6782816YY'),
(35, 'Almudena Diaz Maltras', '685482881', '40905510XX'),
(36, 'Nicolasa Serrano Soto', '647002899', '08728082LL'),
(37, 'Maria Jesus Ibarra Montoya', '678305812', '73614330RR'),
(38, 'Yolanda Lopez Garcia', '684372315', '49444323GG'),
(39, 'Renata Prieto Fernandez', '605399813', '65081279LL'),
(40, 'Antonia Garcia Herrera', '675332884', '73183159BB'),
(41, 'Diego Diez Murcia', '645572813', '61841899MM'),
(42, 'Agatha Fernandez Marron', '644382856', 'Y3202398FF'),
(43, 'Luis Plaza Martinez', '607332436', 'Y1644972AA'),
(44, 'Alberto Corrales Suarez', '629332834', '60163895NN'),
(45, 'Pedro del Val Almendro', '678433858', 'X5560893EE'),
(46, 'Teresa Gonzalez Garcia', '615432888', '52316109XX'),
(47, 'Luisa Pina Soto', '605332720', 'Z2450362QQ'),
(48, 'Jana Blanco Garcia', '635337841', '71635126QQ'),
(49, 'Cristina Pedrosa Garcia', '605372412', 'Z3079146AA'),
(50, 'Daniel Pares Mendez', '985357417', '35768298DD'),
(51, 'Martin Velazquez Melendez', '913232811', 'Y5999085DD'),
(52, 'Candida Rato Linares', '605332872', '86003904GG'),
(53, 'Sebastian Castro Castro', '985372809', 'Y6024461QQ'),
(54, 'Carlos del Pino Inda', '685332817', '88472225BB'),
(55, 'Lucia Santos Fresneda', '949332872', '19378341JJ'),
(56, 'Andrés Diaz Lago', '609332927', '92435125BB'),
(57, 'Brigida Fernandez Fernandez', '675332819', '65795578FF'),
(58, 'Carlos Melano Largo', '685932817', '05081165MM'),
(59, 'Maria Rox Suarez', '985538470', '96322000RR'),
(60, 'Francisco Calvo Real', '604832312', '53433103DD'),
(61, 'Diego Egea Gutierres', '987932838', '92174257DD'),
(62, 'Pablo Diez Vega', '67133591', 'Z3836755SS'),
(63, 'Hector Suarez Gonzalez', '670358827', 'Z4200951YY'),
(64, 'Andrés Gonzalez Res', '935332801', '53029393HH'),
(65, 'Juan Encina Panes', '609132923', '50576170KK'),
(66, 'Asier Mendez Blanco', '642782839', '57353981PP'),
(67, 'Luis Rajoy Garcia', '695282109', '27941945GG'),
(68, 'Rafael Pis Pedrosa', '685332913', '51862798YY'),
(69, 'Federico Ruiz Fresno', '685722391', '50818026DD'),
(70, 'Rosa Feroz Corbato', '645332823', '54648956JJ'),
(71, 'Rai Jordan Riego Garcia', '918332819', '96502695PP'),
(72, 'Carmen Lago Par', '649332871', '12101767HH'),
(73, 'Asuncion Serrano Vega', '635839771', 'Z6825932CC'),
(74, 'Marina Castro Garcia', '659331801', 'Z8246606FF'),
(75, 'Maria Ana de la Riva Suarez', '685932890', '24806613DD'),
(76, 'Maria Salas Fernandez', '675331829', 'Z7542810BB'),
(77, 'Amaya Fernandez Muela', '97539218', 'Y7658122XX'),
(78, 'Sandra Peres Robles', '929352801', '75431194AA'),
(79, 'Ursula Suarez Diaz', '645702851', 'X1042996SS'),
(80, 'Gabriel Julio Sol', '985372858', '20019726CC'),
(81, 'Carlos Culto Medina', '6230328710', '18570348XX'),
(82, 'Natasha Puig Garcia', '625159802', '18057228CC'),
(83, 'Dario Linares Gutierrez', '988032859', '81318197HH'),
(84, 'Diego Bolo Garcia', '659373808', 'Z7852146CC'),
(85, 'Alberto Agujas Montoya', '930832821', '41885849CC'),
(86, 'Martin Garcia Garcia', '698501818', '34113665LL'),
(87, 'Jorge Ibarretxe Gallo', '680392814', '36446895ZZ'),
(88, 'Daniel Muela Velazquez', '682312841', '56367936LL'),
(89, 'Teresa Martinez Vivo', '680372845', '58100636ZZ'),
(90, 'Borja Lagos Perez', '699332873', '87084836MM'),
(91, 'Andrés Gonzalez Galvez', '989300959', 'Z1435229BB'),
(92, 'Maria Garcia de Vivar', '938332801', '73306967XX'),
(93, 'Juan Robles Sello', '689337821', '31233665XX'),
(94, 'Pablo Leon Garcia', '685409720', '19579239YY'),
(95, 'Amalia del Pino Gutierrez', '910832839', '39747369BB'),
(96, 'Raul Plaza Corbato', '694937805', '08401300KK'),
(97, 'Padro Santos Diaz', '637339880', '47179956XX'),
(98, 'Juaquin Dalmata Serrano', '929330831', '12891728KK'),
(99, 'Francisco Suarez Serrano', '970309833', '83751810RR'),
(100, 'Emma Fernandez Corral', '941272809', '94308209KK'),
(1001, 'Sonia Montoya Torna', '671250081', '35286840XX'),
(1002, 'Natalia Prado Aguja', '680235891', '51486965QQ'),
(1003, 'Martin Puig Fernandez', '694382839', '70063260QQ'),
(1004, 'Juan Alvarez Roig', '685732413', 'X2144674QQ'),
(1005, 'Carlos Diez Cobo', '675312945', 'Z3583122AA'),
(1006, 'Carmen Martinez Tazones', '958232831', '07103619TT'),
(1007, 'Hector Calvo Blanco', '688257823', 'Z4517509SS'),
(1008, 'Pablo Linares Altamira', '697131831', '72958938VV'),
(1009, 'Hugo Fuero Ruiz', '951832859', 'X4108732NN'),
(1010, 'Luis Garcia Gonzalez', '681952317', '83888954LL'),
(1011, 'Carmen Diaz Castro', '61734815', 'Z6009146XX'),
(1012, 'Borja Vega Martinez', '688215870', '59259617WW'),
(1013, 'Carlos Garcia Perez', '650732808', '52411973XX'),
(1014, 'Maria Ruiz Fernandez', '652732818', '36982390TT'),
(1015, 'Emma del Rio Flores', '650732111', '84136310XX'),
(2001, 'Rosario Prado Blanco', '627943650', '65300276XX'),
(2002, 'Laura Torices Fernandez', '685334056', '16376136KK'),
(2003, 'Manuel Santiago Diez', '638135956', 'Y4944105QQ'),
(2004, 'Alfredo Garcia Gallo', '608364550', 'X5900223XX'),
(2005, 'Ramon Garcia Lazo', '694267193', '60238660GG'),
(2006, 'Rosa Diez Lucas', '628324853', '07339853RR'),
(2007, 'Ana Ruiz Arenas', '629304871', 'Z3093877ZZ'),
(2008, 'Alvaro Osorno Soto', '654768870', '25962533HH'),
(2009, 'Bernabe Ruiz Garcia', '623804841', '17684187QQ'),
(2010, 'Elisabeth Salamanca Blanco', '669359871', '30393701YY'),
(2011, 'Ana Ruiz Jurado', '609304772', '19808954CC'),
(2012, 'Maria Cuena Velazquez', '672340851', '19066941XX'),
(2013, 'Juana de la Riva Gutierrez', '629904871', '87228110NN'),
(2014, 'Damian Ortiz Arenas', '681331773', '54610188TT'),
(2015, 'Cesar Gutierrez Fernandez', '690302861', '61766541HH');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
