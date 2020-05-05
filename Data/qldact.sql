-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2020 at 05:48 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qldact`
--

-- --------------------------------------------------------

--
-- Table structure for table `congviec`
--

CREATE TABLE `congviec` (
  `MADA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `STT` int(11) NOT NULL,
  `TEN_CONG_VIEC` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `congviec`
--

INSERT INTO `congviec` (`MADA`, `STT`, `TEN_CONG_VIEC`) VALUES
('DA001', 1, 'cv01');

-- --------------------------------------------------------

--
-- Table structure for table `dean`
--

CREATE TABLE `dean` (
  `TENDA` text COLLATE utf8_unicode_ci NOT NULL,
  `MADA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DDIEM_DA` text COLLATE utf8_unicode_ci NOT NULL,
  `PHONG` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dean`
--

INSERT INTO `dean` (`TENDA`, `MADA`, `DDIEM_DA`, `PHONG`) VALUES
('De An 1', 'DA001', 'adsd', 'P001'),
('De an 2', 'DA002', 'asdf', 'P001');

-- --------------------------------------------------------

--
-- Table structure for table `diadiem_phg`
--

CREATE TABLE `diadiem_phg` (
  `MAPHG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DIADIEM` text COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `HONV` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `TENLOT` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `TENNV` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `MANV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NGSINH` date DEFAULT NULL,
  `DCHI` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHAI` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `LUONG` int(11) DEFAULT NULL,
  `MA_NQL` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHG` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`HONV`, `TENLOT`, `TENNV`, `MANV`, `NGSINH`, `DCHI`, `PHAI`, `LUONG`, `MA_NQL`, `PHG`) VALUES
('Luong', 'Thi Huyen', 'Trang', '001', '2020-05-06', 'DocMo', 'Nữ', 1000, NULL, 'P001'),
('Trang', 'Ngoc', 'Thien', '002', '2020-05-05', 'HCM', 'Nam', 2000, NULL, 'P001');

-- --------------------------------------------------------

--
-- Table structure for table `phancong`
--

CREATE TABLE `phancong` (
  `MA_NVIEN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MADA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `STT` int(11) NOT NULL,
  `THOIGIAN` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phancong`
--

INSERT INTO `phancong` (`MA_NVIEN`, `MADA`, `STT`, `THOIGIAN`) VALUES
('002', 'DA002', 1, '2020-11-12');

-- --------------------------------------------------------

--
-- Table structure for table `phongban`
--

CREATE TABLE `phongban` (
  `TENPHG` text COLLATE utf8_unicode_ci NOT NULL,
  `MAPHG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TRPHG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NG_NHANCHUC` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phongban`
--

INSERT INTO `phongban` (`TENPHG`, `MAPHG`, `TRPHG`, `NG_NHANCHUC`) VALUES
('Phong 01', 'P001', '001', '2020-05-04'),
('Phong 002', 'P002', '002', '2020-05-05'),
('Phong 003', 'P003', '001', '2020-05-05');

-- --------------------------------------------------------

--
-- Table structure for table `thannhan`
--

CREATE TABLE `thannhan` (
  `MA_NVIEN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TENTN` text COLLATE utf8_unicode_ci NOT NULL,
  `PHAI` text COLLATE utf8_unicode_ci NOT NULL,
  `NGSINH` date NOT NULL,
  `QUANHE` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `congviec`
--
ALTER TABLE `congviec`
  ADD PRIMARY KEY (`STT`),
  ADD KEY `FK_CV_DA` (`MADA`);

--
-- Indexes for table `dean`
--
ALTER TABLE `dean`
  ADD PRIMARY KEY (`MADA`),
  ADD KEY `PHONG` (`PHONG`);

--
-- Indexes for table `diadiem_phg`
--
ALTER TABLE `diadiem_phg`
  ADD PRIMARY KEY (`MAPHG`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`),
  ADD KEY `MA_NQL` (`MA_NQL`),
  ADD KEY `PHG` (`PHG`);

--
-- Indexes for table `phancong`
--
ALTER TABLE `phancong`
  ADD PRIMARY KEY (`MA_NVIEN`),
  ADD KEY `FK_PC_CV` (`STT`);

--
-- Indexes for table `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`MAPHG`),
  ADD KEY `TRPHG` (`TRPHG`);

--
-- Indexes for table `thannhan`
--
ALTER TABLE `thannhan`
  ADD PRIMARY KEY (`MA_NVIEN`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `congviec`
--
ALTER TABLE `congviec`
  ADD CONSTRAINT `FK_CV_DA` FOREIGN KEY (`MADA`) REFERENCES `dean` (`MADA`);

--
-- Constraints for table `dean`
--
ALTER TABLE `dean`
  ADD CONSTRAINT `dean_ibfk_1` FOREIGN KEY (`PHONG`) REFERENCES `phongban` (`MAPHG`);

--
-- Constraints for table `diadiem_phg`
--
ALTER TABLE `diadiem_phg`
  ADD CONSTRAINT `diadiem_phg_ibfk_1` FOREIGN KEY (`MAPHG`) REFERENCES `phongban` (`MAPHG`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`MA_NQL`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`PHG`) REFERENCES `phongban` (`MAPHG`);

--
-- Constraints for table `phancong`
--
ALTER TABLE `phancong`
  ADD CONSTRAINT `FK_PC_CV` FOREIGN KEY (`STT`) REFERENCES `congviec` (`STT`),
  ADD CONSTRAINT `FK_PC_NV` FOREIGN KEY (`MA_NVIEN`) REFERENCES `nhanvien` (`MANV`);

--
-- Constraints for table `phongban`
--
ALTER TABLE `phongban`
  ADD CONSTRAINT `phongban_ibfk_1` FOREIGN KEY (`TRPHG`) REFERENCES `nhanvien` (`MANV`);

--
-- Constraints for table `thannhan`
--
ALTER TABLE `thannhan`
  ADD CONSTRAINT `thannhan_ibfk_1` FOREIGN KEY (`MA_NVIEN`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `thannhan_ibfk_2` FOREIGN KEY (`MA_NVIEN`) REFERENCES `nhanvien` (`MANV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
