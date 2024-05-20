-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:33061
-- Generation Time: Mar 21, 2024 at 12:23 PM
-- Server version: 8.0.36
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `army`
--

-- --------------------------------------------------------

--
-- Table structure for table `adress_info`
--

CREATE TABLE `adress_info` (
  `s_id` int NOT NULL,
  `state` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `adress_info`
--

INSERT INTO `adress_info` (`s_id`, `state`, `address`) VALUES
(22, 'Karnataka', 'Mysore'),
(33, 'Karnataka', 'Benagaluru');

-- --------------------------------------------------------

--
-- Table structure for table `awards_info`
--

CREATE TABLE `awards_info` (
  `sd_id` int NOT NULL,
  `award_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `awards_info`
--

INSERT INTO `awards_info` (`sd_id`, `award_name`) VALUES
(22, 'Vir chakra'),
(33, 'Maha vir chakra'),
(55, 'Chakra');

-- --------------------------------------------------------

--
-- Table structure for table `family_info`
--

CREATE TABLE `family_info` (
  `sol_id` int NOT NULL,
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `relationship` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ph_no` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `family_info`
--

INSERT INTO `family_info` (`sol_id`, `name`, `relationship`, `ph_no`) VALUES
(22, 'Gopal', 'Father', 8374384783),
(33, 'sindhu', 'wife', 6362343723);

-- --------------------------------------------------------

--
-- Table structure for table `personal_info`
--

CREATE TABLE `personal_info` (
  `soldier_id` int NOT NULL,
  `s_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dob` date NOT NULL,
  `blood_group` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date_of_join` date NOT NULL,
  `regi_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `personal_info`
--

INSERT INTO `personal_info` (`soldier_id`, `s_name`, `gender`, `dob`, `blood_group`, `date_of_join`, `regi_name`) VALUES
(11, 'manju', 'M', '2003-10-29', 'Dogra', '2020-07-08', 'Dogra'),
(22, 'megharaja', 'M', '1999-07-09', 'o+ ', '2016-06-03', 'Parachute '),
(33, 'Kishan', 'M', '1987-04-06', 'B+', '2017-08-08', 'Parachute '),
(55, 'Annappa', 'M', '2024-03-12', 'B+', '2024-03-05', 'Sikkim Scouts');

-- --------------------------------------------------------

--
-- Table structure for table `regiment_info`
--

CREATE TABLE `regiment_info` (
  `reg_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `center` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `regiment_info`
--

INSERT INTO `regiment_info` (`reg_name`, `center`) VALUES
('Dogra', 'Uttar Pradesh'),
('Ladakh  Scouts', 'Leh, Ladak'),
('Maratha Light', 'Belagam'),
('Parachute ', 'Bengaluru'),
('Sikkim Scouts', 'Lucknow');

-- --------------------------------------------------------

--
-- Table structure for table `traininf_info`
--

CREATE TABLE `traininf_info` (
  `so_id` int NOT NULL,
  `type` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `r_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `duration` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `traininf_info`
--

INSERT INTO `traininf_info` (`so_id`, `type`, `r_name`, `duration`) VALUES
(22, 'First Aid', 'Ladakh  Scouts', '1 year'),
(33, 'Basic survival', 'Parachute ', '1 year');

-- --------------------------------------------------------

--
-- Table structure for table `weapon_info`
--

CREATE TABLE `weapon_info` (
  `sr_id` int NOT NULL,
  `wp_id` int NOT NULL,
  `wp_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `weapon_info`
--

INSERT INTO `weapon_info` (`sr_id`, `wp_id`, `wp_name`) VALUES
(22, 2222, 'AK47'),
(33, 3333, 'MK14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adress_info`
--
ALTER TABLE `adress_info`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `awards_info`
--
ALTER TABLE `awards_info`
  ADD PRIMARY KEY (`sd_id`);

--
-- Indexes for table `family_info`
--
ALTER TABLE `family_info`
  ADD PRIMARY KEY (`sol_id`);

--
-- Indexes for table `personal_info`
--
ALTER TABLE `personal_info`
  ADD PRIMARY KEY (`soldier_id`),
  ADD KEY `fk0` (`regi_name`);

--
-- Indexes for table `regiment_info`
--
ALTER TABLE `regiment_info`
  ADD PRIMARY KEY (`reg_name`);

--
-- Indexes for table `traininf_info`
--
ALTER TABLE `traininf_info`
  ADD PRIMARY KEY (`so_id`),
  ADD KEY `fk4` (`r_name`);

--
-- Indexes for table `weapon_info`
--
ALTER TABLE `weapon_info`
  ADD PRIMARY KEY (`sr_id`,`wp_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adress_info`
--
ALTER TABLE `adress_info`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`s_id`) REFERENCES `personal_info` (`soldier_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `awards_info`
--
ALTER TABLE `awards_info`
  ADD CONSTRAINT `fk6` FOREIGN KEY (`sd_id`) REFERENCES `personal_info` (`soldier_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `family_info`
--
ALTER TABLE `family_info`
  ADD CONSTRAINT `fk2` FOREIGN KEY (`sol_id`) REFERENCES `personal_info` (`soldier_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `personal_info`
--
ALTER TABLE `personal_info`
  ADD CONSTRAINT `fk0` FOREIGN KEY (`regi_name`) REFERENCES `regiment_info` (`reg_name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `traininf_info`
--
ALTER TABLE `traininf_info`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`so_id`) REFERENCES `personal_info` (`soldier_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk4` FOREIGN KEY (`r_name`) REFERENCES `regiment_info` (`reg_name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `weapon_info`
--
ALTER TABLE `weapon_info`
  ADD CONSTRAINT `fk5` FOREIGN KEY (`sr_id`) REFERENCES `personal_info` (`soldier_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
