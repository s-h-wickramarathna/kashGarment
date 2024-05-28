-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.35 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for kash
CREATE DATABASE IF NOT EXISTS `kash` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kash`;

-- Dumping structure for table kash.adress
CREATE TABLE IF NOT EXISTS `adress` (
  `ad_id` int NOT NULL AUTO_INCREMENT,
  `address` text NOT NULL,
  `city_ci_id` int NOT NULL,
  `client_cl_email` varchar(45) NOT NULL,
  PRIMARY KEY (`ad_id`),
  KEY `fk_adress_city1_idx` (`city_ci_id`),
  KEY `fk_adress_client1_idx` (`client_cl_email`),
  CONSTRAINT `fk_adress_city1` FOREIGN KEY (`city_ci_id`) REFERENCES `city` (`ci_id`),
  CONSTRAINT `fk_adress_client1` FOREIGN KEY (`client_cl_email`) REFERENCES `client` (`cl_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.adress: ~0 rows (approximately)

-- Dumping structure for table kash.city
CREATE TABLE IF NOT EXISTS `city` (
  `ci_id` int NOT NULL AUTO_INCREMENT,
  `ci_name` varchar(45) NOT NULL,
  `country_con_id` int NOT NULL,
  PRIMARY KEY (`ci_id`),
  KEY `fk_city_country1_idx` (`country_con_id`),
  CONSTRAINT `fk_city_country1` FOREIGN KEY (`country_con_id`) REFERENCES `country` (`con_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.city: ~5 rows (approximately)
REPLACE INTO `city` (`ci_id`, `ci_name`, `country_con_id`) VALUES
	(1, 'Matara', 3),
	(2, 'New York', 2),
	(3, 'Tokyo', 1),
	(4, 'Shanghai', 5),
	(5, 'Mumbai', 4);

-- Dumping structure for table kash.client
CREATE TABLE IF NOT EXISTS `client` (
  `cl_email` varchar(45) NOT NULL,
  `cl_fname` varchar(45) NOT NULL,
  `cl_lname` varchar(45) NOT NULL,
  `cl_mobile` varchar(10) NOT NULL,
  PRIMARY KEY (`cl_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.client: ~2 rows (approximately)
REPLACE INTO `client` (`cl_email`, `cl_fname`, `cl_lname`, `cl_mobile`) VALUES
	('client1@gmail.com', 'client1', 'client1', '0765555555'),
	('client2@gmail.com', 'client2', 'client2', '0765555556');

-- Dumping structure for table kash.color
CREATE TABLE IF NOT EXISTS `color` (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.color: ~5 rows (approximately)
REPLACE INTO `color` (`c_id`, `c_name`) VALUES
	(1, 'Red'),
	(2, 'Blue'),
	(3, 'Pink'),
	(4, 'Yellow'),
	(5, 'Green');

-- Dumping structure for table kash.company
CREATE TABLE IF NOT EXISTS `company` (
  `com_id` int NOT NULL AUTO_INCREMENT,
  `com_name` varchar(45) NOT NULL,
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.company: ~5 rows (approximately)
REPLACE INTO `company` (`com_id`, `com_name`) VALUES
	(1, 'Kravet'),
	(2, 'Crypton'),
	(3, 'Carole Fabric'),
	(4, 'Barrow'),
	(5, 'Covineton Fabric');

-- Dumping structure for table kash.consumption
CREATE TABLE IF NOT EXISTS `consumption` (
  `con_id` int NOT NULL,
  `material_m_id` int NOT NULL,
  `product_p_id` int NOT NULL,
  `qty` double NOT NULL,
  PRIMARY KEY (`con_id`),
  KEY `fk_material_has_product_product1_idx` (`product_p_id`),
  KEY `fk_material_has_product_material1_idx` (`material_m_id`),
  CONSTRAINT `fk_material_has_product_material1` FOREIGN KEY (`material_m_id`) REFERENCES `material` (`m_id`),
  CONSTRAINT `fk_material_has_product_product1` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.consumption: ~0 rows (approximately)

-- Dumping structure for table kash.country
CREATE TABLE IF NOT EXISTS `country` (
  `con_id` int NOT NULL AUTO_INCREMENT,
  `con_name` varchar(45) NOT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.country: ~5 rows (approximately)
REPLACE INTO `country` (`con_id`, `con_name`) VALUES
	(1, 'Japan'),
	(2, 'America'),
	(3, 'Sri Lanka'),
	(4, 'India'),
	(5, 'China');

-- Dumping structure for table kash.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_fname` varchar(45) NOT NULL,
  `emp_lname` varchar(45) NOT NULL,
  `emp_nic` varchar(12) NOT NULL,
  `emp_mobile` varchar(10) NOT NULL,
  `emp_joinDate` date NOT NULL,
  `employee_type_empt_id` int NOT NULL,
  `status_s_id` int NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `fk_employee_employee_type1_idx` (`employee_type_empt_id`),
  KEY `fk_employee_status1_idx` (`status_s_id`),
  CONSTRAINT `fk_employee_employee_type1` FOREIGN KEY (`employee_type_empt_id`) REFERENCES `employee_type` (`empt_id`),
  CONSTRAINT `fk_employee_status1` FOREIGN KEY (`status_s_id`) REFERENCES `status` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.employee: ~2 rows (approximately)
REPLACE INTO `employee` (`emp_id`, `emp_fname`, `emp_lname`, `emp_nic`, `emp_mobile`, `emp_joinDate`, `employee_type_empt_id`, `status_s_id`) VALUES
	(1, 'emp1', 'emp1', '200000000001', '0762222222', '2024-05-20', 1, 1),
	(2, 'emp2', 'emp2', '200000000002', '0763333333', '2024-05-20', 4, 1);

-- Dumping structure for table kash.employee_type
CREATE TABLE IF NOT EXISTS `employee_type` (
  `empt_id` int NOT NULL AUTO_INCREMENT,
  `empt_type` varchar(45) NOT NULL,
  PRIMARY KEY (`empt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.employee_type: ~10 rows (approximately)
REPLACE INTO `employee_type` (`empt_id`, `empt_type`) VALUES
	(1, 'Chairmen'),
	(2, 'General Manager'),
	(3, 'Technical Manager'),
	(4, 'Factory Manager'),
	(5, 'Production Manager'),
	(6, 'Quality Assuarence Manager'),
	(7, 'Quality Checker'),
	(8, 'Supervisor'),
	(9, 'Operator'),
	(10, 'Helper');

-- Dumping structure for table kash.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `g_id` int NOT NULL AUTO_INCREMENT,
  `g_type` varchar(45) NOT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.gender: ~2 rows (approximately)
REPLACE INTO `gender` (`g_id`, `g_type`) VALUES
	(1, 'Male'),
	(2, 'Female');

-- Dumping structure for table kash.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `grn_id` int NOT NULL AUTO_INCREMENT,
  `grn_total_price` double NOT NULL,
  `supplier_sup_id` int NOT NULL,
  `grn_purchesed_date` date NOT NULL,
  `user_u_id` int NOT NULL,
  PRIMARY KEY (`grn_id`),
  KEY `fk_grn_supplier1_idx` (`supplier_sup_id`),
  KEY `fk_grn_user1_idx` (`user_u_id`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_sup_id`) REFERENCES `supplier` (`sup_id`),
  CONSTRAINT `fk_grn_user1` FOREIGN KEY (`user_u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.grn: ~1 rows (approximately)
REPLACE INTO `grn` (`grn_id`, `grn_total_price`, `supplier_sup_id`, `grn_purchesed_date`, `user_u_id`) VALUES
	(1, 2500, 1, '2024-05-20', 1);

-- Dumping structure for table kash.grn_item
CREATE TABLE IF NOT EXISTS `grn_item` (
  `grni_id` int NOT NULL AUTO_INCREMENT,
  `unit_buy_price` double NOT NULL,
  `grni_qty` double NOT NULL,
  `stock_stock_id` int NOT NULL,
  `grn_grn_id` int NOT NULL,
  PRIMARY KEY (`grni_id`),
  KEY `fk_grn_item_stock1_idx` (`stock_stock_id`),
  KEY `fk_grn_item_grn1_idx` (`grn_grn_id`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_grn_id`) REFERENCES `grn` (`grn_id`),
  CONSTRAINT `fk_grn_item_stock1` FOREIGN KEY (`stock_stock_id`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.grn_item: ~1 rows (approximately)
REPLACE INTO `grn_item` (`grni_id`, `unit_buy_price`, `grni_qty`, `stock_stock_id`, `grn_grn_id`) VALUES
	(1, 65, 100, 4, 1);

-- Dumping structure for table kash.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `in_id` varchar(20) NOT NULL,
  `in_purchesed_date` date NOT NULL,
  `in_total_price` double NOT NULL,
  `user_u_id` int NOT NULL,
  PRIMARY KEY (`in_id`),
  KEY `fk_invoice_user1_idx` (`user_u_id`),
  CONSTRAINT `fk_invoice_user1` FOREIGN KEY (`user_u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.invoice: ~0 rows (approximately)

-- Dumping structure for table kash.invoice_item
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `init_id` int NOT NULL AUTO_INCREMENT,
  `product_details_pd_id` varchar(10) NOT NULL,
  `invoice_in_id` varchar(20) NOT NULL,
  PRIMARY KEY (`init_id`),
  KEY `fk_invoice_item_product_details1_idx` (`product_details_pd_id`),
  KEY `fk_invoice_item_invoice1_idx` (`invoice_in_id`),
  CONSTRAINT `fk_invoice_item_invoice1` FOREIGN KEY (`invoice_in_id`) REFERENCES `invoice` (`in_id`),
  CONSTRAINT `fk_invoice_item_product_details1` FOREIGN KEY (`product_details_pd_id`) REFERENCES `product_details` (`pd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.invoice_item: ~0 rows (approximately)

-- Dumping structure for table kash.material
CREATE TABLE IF NOT EXISTS `material` (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_name` varchar(45) NOT NULL,
  `m_description` text NOT NULL,
  `material_type_mt_id` int NOT NULL,
  PRIMARY KEY (`m_id`),
  KEY `fk_material_material_type1_idx` (`material_type_mt_id`),
  CONSTRAINT `fk_material_material_type1` FOREIGN KEY (`material_type_mt_id`) REFERENCES `material_type` (`mt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.material: ~5 rows (approximately)
REPLACE INTO `material` (`m_id`, `m_name`, `m_description`, `material_type_mt_id`) VALUES
	(1, 'Collor Button', 'yellow Collor Button', 1),
	(2, 'Cotton Fabric', 'Full Cotton Fabric', 2),
	(3, '1\'\' Ilustic', 'Rubber Illustic', 4),
	(4, 'Single Thread', 'Red Single Thread', 3),
	(5, 'Gold Zipper', 'Fat Gold Zipper', 5);

-- Dumping structure for table kash.material_color
CREATE TABLE IF NOT EXISTS `material_color` (
  `mc_id` int NOT NULL AUTO_INCREMENT,
  `material_m_id` int NOT NULL,
  `color_c_id` int NOT NULL,
  PRIMARY KEY (`mc_id`),
  KEY `fk_material_has_color_color1_idx` (`color_c_id`),
  KEY `fk_material_has_color_material1_idx` (`material_m_id`),
  CONSTRAINT `fk_material_has_color_color1` FOREIGN KEY (`color_c_id`) REFERENCES `color` (`c_id`),
  CONSTRAINT `fk_material_has_color_material1` FOREIGN KEY (`material_m_id`) REFERENCES `material` (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.material_color: ~5 rows (approximately)
REPLACE INTO `material_color` (`mc_id`, `material_m_id`, `color_c_id`) VALUES
	(1, 3, 2),
	(2, 1, 5),
	(3, 2, 3),
	(4, 5, 1),
	(5, 4, 4);

-- Dumping structure for table kash.material_type
CREATE TABLE IF NOT EXISTS `material_type` (
  `mt_id` int NOT NULL AUTO_INCREMENT,
  `mt_name` varchar(45) NOT NULL,
  PRIMARY KEY (`mt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.material_type: ~5 rows (approximately)
REPLACE INTO `material_type` (`mt_id`, `mt_name`) VALUES
	(1, 'Button'),
	(2, 'Fabric'),
	(3, 'Thread'),
	(4, 'Ilustic'),
	(5, 'Zipper');

-- Dumping structure for table kash.product
CREATE TABLE IF NOT EXISTS `product` (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `p_name` varchar(45) NOT NULL,
  `p_description` text NOT NULL,
  `client_cl_email` varchar(45) NOT NULL,
  PRIMARY KEY (`p_id`),
  KEY `fk_product_client1_idx` (`client_cl_email`),
  CONSTRAINT `fk_product_client1` FOREIGN KEY (`client_cl_email`) REFERENCES `client` (`cl_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.product: ~3 rows (approximately)
REPLACE INTO `product` (`p_id`, `p_name`, `p_description`, `client_cl_email`) VALUES
	(1, 'Ladies Frock', 'ladies Long Sleves Frock', 'client1@gmail.com'),
	(2, 'Gents Short', 'Cargo Pocket Gents Shorts', 'client2@gmail.com'),
	(3, 'Ladies TShirt', 'Collor Ladies TShirts', 'client1@gmail.com');

-- Dumping structure for table kash.product_color
CREATE TABLE IF NOT EXISTS `product_color` (
  `pc_id` int NOT NULL AUTO_INCREMENT,
  `product_p_id` int NOT NULL,
  `color_c_id` int NOT NULL,
  PRIMARY KEY (`pc_id`),
  KEY `fk_product_has_color_color1_idx` (`color_c_id`),
  KEY `fk_product_has_color_product1_idx` (`product_p_id`),
  CONSTRAINT `fk_product_has_color_color1` FOREIGN KEY (`color_c_id`) REFERENCES `color` (`c_id`),
  CONSTRAINT `fk_product_has_color_product1` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.product_color: ~2 rows (approximately)
REPLACE INTO `product_color` (`pc_id`, `product_p_id`, `color_c_id`) VALUES
	(1, 2, 2),
	(2, 1, 5);

-- Dumping structure for table kash.product_details
CREATE TABLE IF NOT EXISTS `product_details` (
  `pd_id` varchar(10) NOT NULL,
  `product_p_id` int NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `shipping_date` date NOT NULL,
  `shipping_status_ship_id` int NOT NULL,
  `pd_qty` int NOT NULL,
  `pd_unit_price` double NOT NULL,
  `pd_damage_items` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`pd_id`),
  KEY `fk_product_details_product1_idx` (`product_p_id`),
  KEY `fk_product_details_shipping_status1_idx` (`shipping_status_ship_id`),
  CONSTRAINT `fk_product_details_product1` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_product_details_shipping_status1` FOREIGN KEY (`shipping_status_ship_id`) REFERENCES `shipping_status` (`ship_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.product_details: ~2 rows (approximately)
REPLACE INTO `product_details` (`pd_id`, `product_p_id`, `start_date`, `end_date`, `shipping_date`, `shipping_status_ship_id`, `pd_qty`, `pd_unit_price`, `pd_damage_items`) VALUES
	('#da45vc', 1, '2024-05-20', '2024-07-20', '2024-07-25', 1, 500, 1000, 0),
	('#sa32ew', 2, '2024-05-21', '2024-06-20', '2024-05-27', 1, 200, 450, 2);

-- Dumping structure for table kash.product_size
CREATE TABLE IF NOT EXISTS `product_size` (
  `ps_id` int NOT NULL AUTO_INCREMENT,
  `size_s_id` int NOT NULL,
  `product_p_id` int NOT NULL,
  PRIMARY KEY (`ps_id`),
  KEY `fk_size_has_product_product1_idx` (`product_p_id`),
  KEY `fk_size_has_product_size1_idx` (`size_s_id`),
  CONSTRAINT `fk_size_has_product_product1` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_size_has_product_size1` FOREIGN KEY (`size_s_id`) REFERENCES `size` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.product_size: ~4 rows (approximately)
REPLACE INTO `product_size` (`ps_id`, `size_s_id`, `product_p_id`) VALUES
	(1, 3, 2),
	(2, 2, 2),
	(3, 4, 1),
	(4, 5, 1);

-- Dumping structure for table kash.product_state
CREATE TABLE IF NOT EXISTS `product_state` (
  `ps_id` int NOT NULL AUTO_INCREMENT,
  `state_st_id` int NOT NULL,
  `product_details_pd_id` varchar(10) NOT NULL,
  PRIMARY KEY (`ps_id`),
  KEY `fk_Product_state_state1_idx` (`state_st_id`),
  KEY `fk_Product_state_product_details1_idx` (`product_details_pd_id`),
  CONSTRAINT `fk_Product_state_product_details1` FOREIGN KEY (`product_details_pd_id`) REFERENCES `product_details` (`pd_id`),
  CONSTRAINT `fk_Product_state_state1` FOREIGN KEY (`state_st_id`) REFERENCES `state` (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.product_state: ~2 rows (approximately)
REPLACE INTO `product_state` (`ps_id`, `state_st_id`, `product_details_pd_id`) VALUES
	(1, 5, '#da45vc'),
	(2, 7, '#sa32ew');

-- Dumping structure for table kash.shipping_status
CREATE TABLE IF NOT EXISTS `shipping_status` (
  `ship_id` int NOT NULL AUTO_INCREMENT,
  `ship_name` varchar(45) NOT NULL,
  PRIMARY KEY (`ship_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.shipping_status: ~2 rows (approximately)
REPLACE INTO `shipping_status` (`ship_id`, `ship_name`) VALUES
	(1, 'Not Shiped Yet'),
	(2, 'Shiped');

-- Dumping structure for table kash.size
CREATE TABLE IF NOT EXISTS `size` (
  `s_id` int NOT NULL AUTO_INCREMENT,
  `s_name` varchar(45) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.size: ~5 rows (approximately)
REPLACE INTO `size` (`s_id`, `s_name`) VALUES
	(1, 'S'),
	(2, 'M'),
	(3, 'L'),
	(4, 'XL'),
	(5, 'XXL');

-- Dumping structure for table kash.state
CREATE TABLE IF NOT EXISTS `state` (
  `st_id` int NOT NULL AUTO_INCREMENT,
  `st_name` varchar(45) NOT NULL,
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.state: ~8 rows (approximately)
REPLACE INTO `state` (`st_id`, `st_name`) VALUES
	(1, 'Not Start'),
	(2, 'Cutting'),
	(3, 'Print'),
	(4, 'Sawing'),
	(5, 'Checking'),
	(6, 'Washing'),
	(7, 'Packing'),
	(8, 'Finish');

-- Dumping structure for table kash.status
CREATE TABLE IF NOT EXISTS `status` (
  `s_id` int NOT NULL AUTO_INCREMENT,
  `s_type` varchar(45) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.status: ~2 rows (approximately)
REPLACE INTO `status` (`s_id`, `s_type`) VALUES
	(1, 'Active'),
	(2, 'Inactive');

-- Dumping structure for table kash.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `stock_id` int NOT NULL AUTO_INCREMENT,
  `material_m_id` int NOT NULL,
  `stock_qty` double NOT NULL,
  `stock_unitPrice` double NOT NULL,
  `stock_date` date NOT NULL,
  `stock_damage_item` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`stock_id`),
  KEY `fk_stock_material1_idx` (`material_m_id`),
  CONSTRAINT `fk_stock_material1` FOREIGN KEY (`material_m_id`) REFERENCES `material` (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.stock: ~7 rows (approximately)
REPLACE INTO `stock` (`stock_id`, `material_m_id`, `stock_qty`, `stock_unitPrice`, `stock_date`, `stock_damage_item`) VALUES
	(1, 3, 100, 25, '2024-05-20', 0),
	(2, 1, 250, 3, '2024-05-20', 0),
	(3, 2, 80, 25000, '2024-05-20', 0),
	(4, 5, 500, 130, '2024-05-20', 0),
	(5, 4, 700, 70, '2024-05-20', 0),
	(6, 5, 150, 15000, '2024-05-22', 10),
	(7, 2, 105, 5000, '2024-05-22', 10);

-- Dumping structure for table kash.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `sup_id` int NOT NULL AUTO_INCREMENT,
  `sup_fname` varchar(45) NOT NULL,
  `sup_lname` varchar(45) NOT NULL,
  `sup_mobile` varchar(10) NOT NULL,
  `sup_email` varchar(45) NOT NULL,
  `company_com_id` int NOT NULL,
  PRIMARY KEY (`sup_id`),
  KEY `fk_supplier_company1_idx` (`company_com_id`),
  CONSTRAINT `fk_supplier_company1` FOREIGN KEY (`company_com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.supplier: ~2 rows (approximately)
REPLACE INTO `supplier` (`sup_id`, `sup_fname`, `sup_lname`, `sup_mobile`, `sup_email`, `company_com_id`) VALUES
	(1, 'sup1', 'sup1', '0762222222', 'sup@gmail.com', 4),
	(2, 'sup2', 'sup2', '0763333333', 'sup2@gmail.com', 1);

-- Dumping structure for table kash.user
CREATE TABLE IF NOT EXISTS `user` (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `u_password` varchar(45) NOT NULL,
  `employee_emp_id` int NOT NULL,
  PRIMARY KEY (`u_id`),
  KEY `fk_user_employee1_idx` (`employee_emp_id`),
  CONSTRAINT `fk_user_employee1` FOREIGN KEY (`employee_emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table kash.user: ~2 rows (approximately)
REPLACE INTO `user` (`u_id`, `u_password`, `employee_emp_id`) VALUES
	(1, '123456', 1),
	(2, '123456', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
