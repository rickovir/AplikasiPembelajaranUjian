-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2017 at 09:39 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pembelajaran_ujian`
--

-- --------------------------------------------------------

--
-- Table structure for table `matapelajaran`
--

CREATE TABLE IF NOT EXISTS `matapelajaran` (
  `idMataPelajaran` int(11) NOT NULL,
  `namaMataPelajaran` varchar(50) NOT NULL,
  `idKelas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE IF NOT EXISTS `nilai` (
  `idNilai` int(11) NOT NULL,
  `besarNilai` varchar(50) NOT NULL,
  `grade` varchar(3) NOT NULL,
  `idUjian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE IF NOT EXISTS `pengguna` (
  `idPengguna` int(9) NOT NULL,
  `namaPengguna` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `verificationStatus` enum('1','0') NOT NULL,
  `idKelas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `soal`
--

CREATE TABLE IF NOT EXISTS `soal` (
  `idSoal` int(11) NOT NULL,
  `isiSoal` text NOT NULL,
  `jawabanA` varchar(255) NOT NULL,
  `jawabanB` varchar(255) NOT NULL,
  `jawabanC` varchar(255) NOT NULL,
  `jawabanD` varchar(255) NOT NULL,
  `idUjian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tingkatkelas`
--

CREATE TABLE IF NOT EXISTS `tingkatkelas` (
  `idKelas` int(11) NOT NULL,
  `namaKelas` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ujian`
--

CREATE TABLE IF NOT EXISTS `ujian` (
  `idUjian` int(11) NOT NULL,
  `namaUjian` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `idMataPelajaran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `matapelajaran`
--
ALTER TABLE `matapelajaran`
  ADD PRIMARY KEY (`idMataPelajaran`),
  ADD KEY `idKelas` (`idKelas`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`idNilai`),
  ADD KEY `idUjian` (`idUjian`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`idPengguna`),
  ADD KEY `idKelas` (`idKelas`);

--
-- Indexes for table `soal`
--
ALTER TABLE `soal`
  ADD PRIMARY KEY (`idSoal`),
  ADD KEY `idUjian` (`idUjian`);

--
-- Indexes for table `tingkatkelas`
--
ALTER TABLE `tingkatkelas`
  ADD PRIMARY KEY (`idKelas`);

--
-- Indexes for table `ujian`
--
ALTER TABLE `ujian`
  ADD PRIMARY KEY (`idUjian`),
  ADD KEY `idMataPelajaran` (`idMataPelajaran`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `matapelajaran`
--
ALTER TABLE `matapelajaran`
  ADD CONSTRAINT `matapelajaran_ibfk_1` FOREIGN KEY (`idKelas`) REFERENCES `tingkatkelas` (`idKelas`),
  ADD CONSTRAINT `matapelajaran_ibfk_2` FOREIGN KEY (`idKelas`) REFERENCES `tingkatkelas` (`idKelas`);

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`idUjian`) REFERENCES `ujian` (`idUjian`),
  ADD CONSTRAINT `nilai_ibfk_2` FOREIGN KEY (`idUjian`) REFERENCES `ujian` (`idUjian`);

--
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `pengguna_ibfk_1` FOREIGN KEY (`idKelas`) REFERENCES `tingkatkelas` (`idKelas`);

--
-- Constraints for table `soal`
--
ALTER TABLE `soal`
  ADD CONSTRAINT `soal_ibfk_1` FOREIGN KEY (`idUjian`) REFERENCES `ujian` (`idUjian`),
  ADD CONSTRAINT `soal_ibfk_2` FOREIGN KEY (`idUjian`) REFERENCES `ujian` (`idUjian`);

--
-- Constraints for table `ujian`
--
ALTER TABLE `ujian`
  ADD CONSTRAINT `ujian_ibfk_1` FOREIGN KEY (`idMataPelajaran`) REFERENCES `matapelajaran` (`idMataPelajaran`),
  ADD CONSTRAINT `ujian_ibfk_2` FOREIGN KEY (`idMataPelajaran`) REFERENCES `matapelajaran` (`idMataPelajaran`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
