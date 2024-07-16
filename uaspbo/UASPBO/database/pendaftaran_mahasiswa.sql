-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2024 at 07:50 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pendaftaran_mahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `id` int(11) NOT NULL,
  `nama_mk` varchar(100) NOT NULL,
  `deskripsi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`id`, `nama_mk`, `deskripsi`) VALUES
(111, 'PBO', 'Harkespans'),
(112, 'Matematika', 'Harisu'),
(113, 'PBW', 'Heribertus'),
(221, 'Elektronika Dasar', 'Dr. Joko Susilo'),
(222, 'Sistem Kontrol', 'Dr. Lina Setiawati'),
(223, 'Pengantar Sistem Digital', 'Dr. Bambang Santoso'),
(224, 'Sistem Tenaga Listrik', 'Dr. Anita Rahayu'),
(331, 'Manajemen Operasi', 'Dr. Dini Haryanti'),
(332, 'Pemasaran', 'Dr. Agus Priyanto'),
(333, 'Manajemen Keuangan', 'Dr. Rina Wijaya'),
(334, 'Kewirausahaan', 'Dr. Iwan Hermawan'),
(441, 'Akuntansi Keuangan', 'Dr. Bambang Sugiarto'),
(442, 'Audit Sistem Informasi', 'Dr. Santi Wijaya'),
(443, 'Perpajakan', 'Dr. Yanti Suryani'),
(444, 'Akuntansi Manajemen', 'Dr. Andi Kartika');

-- --------------------------------------------------------

--
-- Table structure for table `pendaftar`
--

CREATE TABLE `pendaftar` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `status_kelulusan` tinyint(1) DEFAULT 0,
  `jurusan` varchar(100) NOT NULL,
  `rata_rata_nilai` decimal(5,2) NOT NULL,
  `asal_sekolah` varchar(100) NOT NULL,
  `nama_wali` varchar(100) NOT NULL,
  `no_hp_wali` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pendaftar`
--

INSERT INTO `pendaftar` (`id`, `nama`, `alamat`, `no_telepon`, `status_kelulusan`, `jurusan`, `rata_rata_nilai`, `asal_sekolah`, `nama_wali`, `no_hp_wali`) VALUES
(1, 'Daniel', 'Mranggen', '08123213', 1, 'Teknik Informatika', 80.00, 'Kebon Dalem', 'Bapake', '08012315'),
(2, 'Bagas', 'Semarang', '081235158375', 1, 'Teknik Informatika', 80.00, 'SMAN 1', 'Bagus', '080912736124'),
(3, 'Chiko', 'Demak', '08123123', 0, 'Teknik Informatika', 45.00, 'SMA N 38', 'Bagong', '129037126381263'),
(4, 'Memed', 'Semarang', '012731236', 1, 'Teknik Informatika', 80.00, 'SMA N 4', 'Budi', '0823155645'),
(25, 'Fani', 'Demak', '091274981264', 1, 'Sistem Informasi', 89.00, 'SMK N 7', 'Budi', '466576758234'),
(26, 'Fanie', 'Memed', '09712398721', 1, 'Sistem Informasi', 87.00, 'SMK 5', 'Budi ', '647567'),
(27, 'Doni', 'Jakarta', '081234511722', 1, 'Teknik Elektro', 89.00, 'SMA N 103 Jakarta', 'Done', '0827754321'),
(28, 'Dini', 'Jakarta', '081234511722', 1, 'Manajemen', 89.00, 'SMA N 103 Jakarta', 'Done', '0827754321'),
(29, 'Dinie', 'Jakarta', '081234511722', 1, 'Manajemen', 89.00, 'SMA N 103 Jakarta', 'Done', '0827754321'),
(30, 'Dinio', 'Jakarta', '081234511722', 1, 'Akuntansi', 89.00, 'SMA N 103 Jakarta', 'Done', '0827754321'),
(31, 'Dinia', 'Jakarta', '081234511722', 1, 'Akuntansi', 89.00, 'SMA N 103 Jakarta', 'Done', '0827754321'),
(32, 'Alex', 'Jakarta', '0831231236', 1, 'Teknik Elektro', 65.00, 'SMA N 23 Jakarta', 'Alo', '0812356778');

--
-- Triggers `pendaftar`
--
DELIMITER $$
CREATE TRIGGER `after_pendaftar_insert` AFTER INSERT ON `pendaftar` FOR EACH ROW BEGIN
    DECLARE total_bayar INT;

    SELECT (j.biayagedung + (j.totalskssemester1 * j.biayapersks)) INTO total_bayar
    FROM jurusan j
    WHERE j.namajurusan = NEW.jurusan;

    INSERT INTO pembayaran (id_siswa, totalbayar, status)
    VALUES (NEW.id, total_bayar, 'Belom Lunas');
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pendaftar`
--
ALTER TABLE `pendaftar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jurusan` (`jurusan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=445;

--
-- AUTO_INCREMENT for table `pendaftar`
--
ALTER TABLE `pendaftar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
