-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2025 at 04:15 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookings`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `no_of_days` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `starting_date` date NOT NULL,
  `car_id` int(11) NOT NULL,
  `car_brand` varchar(50) NOT NULL,
  `car_model` varchar(50) NOT NULL,
  `car_price` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `no_of_days`, `status`, `starting_date`, `car_id`, `car_brand`, `car_model`, `car_price`) VALUES
(1, 5, 'pending', '2025-03-10', 0, '', '', 0),
(2, 3, 'confirmed', '2025-03-12', 0, '', '', 0),
(3, 7, 'pending', '2025-03-15', 0, '', '', 0),
(4, 2, 'cancelled', '2025-03-18', 0, '', '', 0),
(5, 4, 'confirmed', '2025-03-20', 0, '', '', 0),
(6, 2, 'Pending', '2025-03-20', 4, 'BMW', 'X5', 100),
(7, 5, 'Pending', '2025-03-20', 3, 'Ford', 'Focus', 45),
(8, 5, 'Pending', '2025-03-22', 1, 'Toyota', 'Corolla', 50),
(9, 6, 'Pending', '2025-03-27', 1, 'Toyota', 'Corolla', 50),
(10, 4, 'Pending', '2025-03-14', 1, 'Toyota', 'Corolla', 50),
(11, 5, 'Pending', '2025-03-27', 1, 'Toyota', 'Corolla', 50),
(12, 3, 'Pending', '2025-03-22', 1, 'Toyota', 'Corolla', 50),
(13, 10, 'Pending', '2025-03-29', 3, 'Ford', 'Focus', 45),
(14, 2, 'Pending', '2025-03-29', 3, 'Ford', 'Focus', 45),
(15, 10, 'Pending', '2025-03-28', 3, 'Ford', 'Focus', 45),
(16, 2, 'Pending', '2025-03-21', 1, 'Toyota', 'Corolla', 50),
(17, 2, 'Pending', '2025-03-28', 3, 'Ford', 'Focus', 45);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
