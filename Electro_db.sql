# SQL Manager 2005 Lite for MySQL 3.6.5.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : Electro_db


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `Electro_db`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

#
# Structure for the `electrodomestico` table : 
#

CREATE TABLE `electrodomestico` (
  `id_electro` int(11) NOT NULL auto_increment,
  `descripcion` varchar(50) character set latin1 NOT NULL,
  `color_elect` varchar(20) character set latin1 NOT NULL,
  `consumo_elect` char(2) character set latin1 NOT NULL,
  `precio_elect` decimal(11,2) NOT NULL,
  `peso_elect` int(11) NOT NULL,
  `carga_lava` decimal(11,2) default NULL,
  `Resol_tele` decimal(11,2) default NULL,
  `Sintoniz_tele` tinyint(1) default NULL,
  PRIMARY KEY  (`id_electro`),
  UNIQUE KEY `id_electro` (`id_electro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB';

#
# Data for the `electrodomestico` table  (LIMIT 0,500)
#

INSERT INTO `electrodomestico` (`id_electro`, `descripcion`, `color_elect`, `consumo_elect`, `precio_elect`, `peso_elect`, `carga_lava`, `Resol_tele`, `Sintoniz_tele`) VALUES 
  (1,'abcdef','Blanco','B',1860,100,NULL,NULL,NULL),
  (2,'LavarropaB','Negro','B',1670,150,25,NULL,NULL),
  (3,'idkfa','Azul','A',1470,90,NULL,29,0),
  (6,'PAPA','BLANCO','B',90,12,NULL,NULL,NULL),
  (7,'ASA','BLANCO','A',110,1,NULL,NULL,NULL),
  (8,'aa','BLANCO','A',111,1,NULL,NULL,NULL),
  (9,'dddd','AZUL','A',120,10,NULL,NULL,NULL),
  (10,'Televisor','Blanco','A',100,100,NULL,29,1);

COMMIT;

