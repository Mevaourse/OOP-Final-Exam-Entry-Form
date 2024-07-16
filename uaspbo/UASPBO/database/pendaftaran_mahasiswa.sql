-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2024 at 01:09 PM
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
-- Table structure for table `jurusan`
--

CREATE TABLE `jurusan` (
  `namajurusan` varchar(100) NOT NULL,
  `biayagedung` int(11) NOT NULL,
  `totalskssemester1` int(11) NOT NULL,
  `biayapersks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jurusan`
--

INSERT INTO `jurusan` (`namajurusan`, `biayagedung`, `totalskssemester1`, `biayapersks`) VALUES
('Akuntansi', 11000000, 25, 300000),
('Broadcasting D3', 8500000, 19, 450000),
('DKV', 10000000, 20, 500000),
('Doktor Ilmu Komputer', 15000000, 24, 700000),
('FTV', 9000000, 22, 300000),
('Ilmu Komunikasi', 9000000, 21, 550000),
('Magister Teknik Informatika', 12000000, 22, 600000),
('Manajemen', 9000000, 23, 230000),
('Sistem Informasi', 8000000, 20, 200000),
('Teknik Elektro', 9000000, 24, 230000),
('Teknik Informatika', 10000000, 21, 250000),
('Teknik Informatika D3', 8000000, 18, 400000),
('Teknik Informatika PJJ', 7500000, 20, 350000);

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
(111, 'PBW', '4 SKS'),
(112, 'Matematika', '4 SKS'),
(113, 'PBW', '4 SKS'),
(221, 'Elektronika Dasar', '4 SKS'),
(222, 'Sistem Kontrol', '3 SKS'),
(445, 'Sistem Informasi', '3 SKS'),
(446, 'Teori Warna', '3 SKS'),
(447, 'Desain Karakter', '3 SKS'),
(448, 'Desain Grafis', '3 SKS'),
(449, 'Pengolahan Suara', '3 SKS'),
(450, 'Animasi 2D', '3 SKS'),
(451, 'Teori Komunikasi', '3 SKS'),
(452, 'Metode Penelitian Komunikasi', '3 SKS'),
(453, 'Metodologi Penelitian', '3 SKS'),
(454, 'Pemrograman Lanjut', '4 SKS'),
(455, 'Pemrograman Android', '4 SKS'),
(456, 'Pengantar Ilmu Komunikasi', '3 SKS'),
(457, 'Teori Komunikasi', '3 SKS'),
(458, 'Kecerdasan Buatan', '3 SKS'),
(459, 'Fotografi Digital', '3 SKS'),
(460, 'Pengembangan Game', '3 SKS'),
(461, 'Analisis Film', '3 SKS'),
(462, 'Teori Pers', '3 SKS'),
(463, 'Metode Penelitian Komunikasi', '3 SKS'),
(464, 'Algoritma Genetika', '3 SKS'),
(465, 'Desain Web', '3 SKS'),
(466, 'Sistem Informasi Geografis', '3 SKS'),
(467, 'Rekayasa Perangkat Lunak', '3 SKS'),
(468, 'Aljabar Linier', '3 SKS'),
(469, 'Manajemen Proyek', '3 SKS'),
(470, 'Kalkulus', '3 SKS'),
(471, 'Matematika Diskrit', '3 SKS'),
(472, 'Pengolahan Citra', '3 SKS'),
(473, 'Pemrograman Visual', '3 SKS'),
(474, 'Pemrograman Berorientasi Objek', '3 SKS'),
(475, 'Statistika', '3 SKS'),
(476, 'Teori Bahasa dan Otomata', '3 SKS'),
(477, 'Pemrograman Lanjut', '4 SKS'),
(478, 'Pemrograman Web', '3 SKS'),
(479, 'Jaringan Komputer', '3 SKS'),
(480, 'Manajemen Database', '3 SKS'),
(481, 'Sistem Operasi', '3 SKS'),
(482, 'Struktur Data', '4 SKS'),
(483, 'Grafika Komputer', '3 SKS'),
(484, 'Animasi 3D', '3 SKS'),
(485, 'Desain Interaksi', '3 SKS'),
(486, 'Pengolahan Audio', '3 SKS'),
(487, 'Media Massa', '3 SKS'),
(488, 'Jurnalisme', '3 SKS'),
(489, 'Kebudayaan dan Komunikasi', '3 SKS'),
(490, 'Komunikasi Bisnis', '3 SKS'),
(491, 'Komunikasi Interpersonal', '3 SKS'),
(492, 'Pemrograman Berbasis Web', '3 SKS'),
(493, 'Pemrograman Perangkat Bergerak', '3 SKS'),
(494, 'Pengembangan Perangkat Lunak', '3 SKS'),
(495, 'Pengolahan Bahasa Alami', '3 SKS'),
(496, 'Sistem Informasi Geografis', '3 SKS'),
(497, 'Sistem Informasi Manajemen', '3 SKS'),
(498, 'Sistem Terdistribusi', '3 SKS'),
(499, 'Manajemen Proyek Teknologi Informasi', '3 SKS'),
(500, 'Filsafat Ilmu', '3 SKS'),
(501, 'Pemrograman Lanjut', '4 SKS'),
(502, 'Kecerdasan Buatan', '3 SKS'),
(503, 'Grafika Komputer', '3 SKS'),
(504, 'Keamanan Komputer', '3 SKS'),
(505, 'Kriptografi', '3 SKS'),
(506, 'Manajemen Proyek', '3 SKS'),
(507, 'Manajemen Jaringan', '3 SKS'),
(508, 'Metode Numerik', '3 SKS'),
(509, 'Manajemen Jaringan', '3 SKS'),
(510, 'Pemrosesan Paralel', '3 SKS'),
(511, 'Pemrograman Game', '3 SKS'),
(512, 'Pemrograman Client-Server', '3 SKS'),
(513, 'Pemrosesan Bahasa Alami', '3 SKS'),
(514, 'Pengembangan Game', '3 SKS'),
(515, 'Visi Komputer', '3 SKS'),
(516, 'Sistem Temu Kembali Informasi', '3 SKS'),
(517, 'Pengujian Perangkat Lunak', '3 SKS'),
(518, 'Tugas Akhir', '4 SKS');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `id_siswa` int(11) NOT NULL,
  `totalbayar` int(11) DEFAULT NULL,
  `status` enum('Lunas','Belom Lunas','','') DEFAULT 'Belom Lunas'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_siswa`, `totalbayar`, `status`) VALUES
(1001, 1, 1500000000, 'Lunas'),
(1002, 4, 15250000, 'Lunas'),
(1003, 2, 15250000, 'Belom Lunas'),
(1004, 25, 12000000, 'Belom Lunas'),
(1005, 26, 12000000, 'Belom Lunas'),
(1006, 27, 14520000, 'Belom Lunas'),
(1007, 28, 14290000, 'Belom Lunas'),
(1008, 29, 14290000, 'Belom Lunas'),
(1009, 30, 18500000, 'Belom Lunas'),
(1010, 31, 18500000, 'Belom Lunas'),
(1011, 32, 14520000, 'Belom Lunas'),
(1012, 33, 15600000, 'Belom Lunas'),
(1013, 34, 15200000, 'Belom Lunas'),
(1014, 35, 20000000, 'Belom Lunas'),
(1015, 36, 17050000, 'Belom Lunas'),
(1016, 37, 25200000, 'Belom Lunas'),
(1017, 38, 20550000, 'Belom Lunas'),
(1018, 39, 31800000, 'Belom Lunas'),
(1019, 40, 14500000, 'Belom Lunas'),
(1020, 41, 15200000, 'Belom Lunas'),
(1021, 42, 20000000, 'Belom Lunas'),
(1022, 43, 17050000, 'Belom Lunas'),
(1037, 154, 15250000, 'Belom Lunas'),
(1038, 155, 12000000, 'Belom Lunas'),
(1039, 156, 20000000, 'Lunas'),
(1040, 157, 15250000, 'Belom Lunas'),
(1041, 158, 17050000, 'Belom Lunas'),
(1042, 159, 25200000, 'Belom Lunas'),
(1043, 160, 15600000, 'Belom Lunas'),
(1044, 161, 20550000, 'Belom Lunas'),
(1045, 162, 15200000, 'Belom Lunas'),
(1046, 163, 31800000, 'Belom Lunas'),
(1047, 164, 15250000, 'Belom Lunas'),
(1048, 165, 12000000, 'Belom Lunas'),
(1049, 166, 20000000, 'Belom Lunas'),
(1050, 167, 15250000, 'Belom Lunas'),
(1051, 168, 17050000, 'Belom Lunas'),
(1052, 169, 25200000, 'Belom Lunas'),
(1053, 170, 15600000, 'Belom Lunas'),
(1054, 171, 20550000, 'Belom Lunas'),
(1055, 172, 15200000, 'Belom Lunas'),
(1056, 173, 31800000, 'Belom Lunas'),
(1057, 174, 15250000, 'Belom Lunas'),
(1058, 175, 12000000, 'Belom Lunas'),
(1059, 176, 20000000, 'Belom Lunas'),
(1060, 177, 15250000, 'Belom Lunas'),
(1061, 178, 17050000, 'Belom Lunas'),
(1062, 179, 25200000, 'Belom Lunas'),
(1063, 180, 15600000, 'Belom Lunas'),
(1064, 181, 20550000, 'Belom Lunas'),
(1065, 182, 15200000, 'Belom Lunas'),
(1066, 183, 31800000, 'Belom Lunas'),
(1067, 184, 15250000, 'Belom Lunas'),
(1068, 185, 12000000, 'Belom Lunas'),
(1069, 186, 20000000, 'Belom Lunas'),
(1070, 187, 15250000, 'Belom Lunas'),
(1071, 188, 17050000, 'Belom Lunas'),
(1072, 189, 25200000, 'Belom Lunas'),
(1073, 190, 15600000, 'Belom Lunas'),
(1074, 191, 20550000, 'Belom Lunas'),
(1075, 192, 15200000, 'Belom Lunas'),
(1076, 193, 31800000, 'Belom Lunas'),
(1077, 194, 15250000, 'Belom Lunas'),
(1078, 195, 12000000, 'Belom Lunas'),
(1079, 196, 20000000, 'Belom Lunas'),
(1080, 197, 15250000, 'Belom Lunas'),
(1081, 198, 17050000, 'Belom Lunas'),
(1082, 199, 25200000, 'Belom Lunas'),
(1083, 200, 15600000, 'Belom Lunas'),
(1084, 201, 20550000, 'Belom Lunas'),
(1085, 202, 15200000, 'Belom Lunas'),
(1086, 203, 31800000, 'Belom Lunas'),
(1087, 204, 14520000, 'Belom Lunas');

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
(32, 'Alex', 'Jakarta', '0831231236', 1, 'Teknik Elektro', 65.00, 'SMA N 23 Jakarta', 'Alo', '0812356778'),
(33, 'Romo', 'Purwodadi', '09012891511', 1, 'FTV', 80.00, 'SMA N 1 Purwodadi', 'Liana', '0812312355'),
(34, 'Ahmad Fathoni', 'Jalan Merdeka No. 1', '081234567890', 1, 'Teknik Informatika D3', 85.00, 'SMA Negeri 1 Jakarta', 'Budi Santoso', '081298765432'),
(35, 'Rina Setiawati', 'Jalan Sudirman No. 12', '081234567891', 1, 'DKV', 88.00, 'SMA Negeri 2 Bandung', 'Siti Aminah', '081298765433'),
(36, 'Dedi Pratama', 'Jalan Gatot Subroto No. 5', '081234567892', 1, 'Broadcasting D3', 90.00, 'SMA Negeri 3 Surabaya', 'Udin Wahyudi', '081298765434'),
(37, 'Lestari Anindya', 'Jalan Thamrin No. 3', '081234567893', 1, 'Magister Teknik Informatika', 92.00, 'SMA Negeri 4 Medan', 'Agus Supriyadi', '081298765435'),
(38, 'Budi Hartono', 'Jalan Diponegoro No. 9', '081234567894', 1, 'Ilmu Komunikasi', 87.00, 'SMA Negeri 5 Yogyakarta', 'Yanti Sulastri', '081298765436'),
(39, 'Nina Astuti', 'Jalan Jenderal Sudirman No. 14', '081234567895', 1, 'Doktor Ilmu Komputer', 93.00, 'SMA Negeri 6 Semarang', 'Rahmat Subekti', '081298765437'),
(40, 'Ardiansyah Putra', 'Jalan M.H. Thamrin No. 7', '081234567896', 1, 'Teknik Informatika PJJ', 86.00, 'SMA Negeri 7 Makassar', 'Fitria Hasanah', '081298765438'),
(41, 'Siti Fatimah', 'Jalan Pahlawan No. 11', '081234567897', 1, 'Teknik Informatika D3', 89.00, 'SMA Negeri 8 Palembang', 'Hamzah Mulyadi', '081298765439'),
(42, 'Eka Priyanto', 'Jalan Pemuda No. 8', '081234567898', 1, 'DKV', 91.00, 'SMA Negeri 9 Malang', 'Herlina Wijaya', '081298765440'),
(43, 'Dewi Sartika', 'Jalan Kartini No. 10', '081234567899', 1, 'Broadcasting D3', 94.00, 'SMA Negeri 10 Pekanbaru', 'Samsul Arifin', '081298765441'),
(154, 'John Doe', '123 Main St, Cityville', '123456789', 1, 'Teknik Informatika', 85.50, 'SMAN 1 Cityville', 'Jane Doe', '987654321'),
(155, 'Jane Smith', '456 Elm St, Townville', '987654321', 1, 'Sistem Informasi', 78.00, 'SMAN 2 Townville', 'John Smith', '123456789'),
(156, 'Michael Johnson', '789 Oak St, Villageton', '567890123', 1, 'DKV', 82.75, 'SMAN 3 Villageton', 'Emily Johnson', '345678901'),
(157, 'Emily Williams', '234 Pine St, Hamletville', '345678901', 1, 'Teknik Informatika', 88.25, 'SMAN 4 Hamletville', 'James Williams', '678901234'),
(158, 'David Brown', '567 Maple St, Countryside', '234567890', 1, 'Broadcasting D3', 75.50, 'SMAN 5 Countryside', 'Sarah Brown', '456789012'),
(159, 'Sarah Lee', '890 Cedar St, Riverside', '456789012', 1, 'Magister Teknik Informatika', 91.00, 'Universitas Riverside', 'Kevin Lee', '789012345'),
(160, 'Christopher Martinez', '123 Birch St, Hillside', '321098765', 1, 'FTV', 79.75, 'SMAN 6 Hillside', 'Jessica Martinez', '567890123'),
(161, 'Matthew Rodriguez', '789 Poplar St, Mountainview', '789012345', 1, 'Ilmu Komunikasi', 86.25, 'SMAN 8 Mountainview', 'Ashley Rodriguez', '234567890'),
(162, 'Ashley Wilson', '234 Magnolia St, Oceanville', '890123456', 1, 'Teknik Informatika D3', 77.00, 'SMAN 9 Oceanville', 'Matthew Wilson', '678901234'),
(163, 'Joshua Lopez', '567 Laurel St, Baytown', '901234567', 1, 'Doktor Ilmu Komputer', 94.50, 'Universitas Baytown', 'Olivia Lopez', '123456789'),
(164, 'Olivia Hernandez', '890 Pineapple St, Beachside', '012345678', 1, 'Teknik Informatika', 89.75, 'SMAN 10 Beachside', 'Ethan Hernandez', '456789012'),
(165, 'Daniel Gonzales', '123 Orange St, Forestville', '543210987', 1, 'Sistem Informasi', 76.50, 'SMAN 11 Forestville', 'Ava Gonzales', '789012345'),
(166, 'Ava Wilson', '456 Lemon St, Grovetown', '210987654', 1, 'DKV', 81.25, 'SMAN 12 Grovetown', 'Noah Wilson', '543210987'),
(167, 'Emma Moore', '789 Grape St, Hilltop', '987654321', 1, 'Teknik Informatika', 87.00, 'SMAN 13 Hilltop', 'Logan Moore', '210987654'),
(168, 'Logan Clark', '234 Banana St, Summitville', '654321098', 1, 'Broadcasting D3', 74.25, 'SMAN 14 Summitville', 'Grace Clark', '876543210'),
(169, 'James Young', '567 Cherry St, Valleyview', '321098765', 1, 'Magister Teknik Informatika', 92.75, 'Universitas Valleyview', 'Sophia Young', '543210987'),
(170, 'Sophia Hall', '890 Pear St, Lakeshore', '098765432', 1, 'FTV', 78.50, 'SMAN 15 Lakeshore', 'Benjamin Hall', '210987654'),
(171, 'Hannah Baker', '456 Olive St, Woodside', '543210987', 1, 'Ilmu Komunikasi', 85.75, 'SMAN 17 Woodside', 'Lucas Baker', '876543210'),
(172, 'Lucas Adams', '789 Walnut St, Hillcrest', '210987654', 1, 'Teknik Informatika D3', 76.00, 'SMAN 18 Hillcrest', 'Lily Adams', '543210987'),
(173, 'Lily Scott', '234 Chestnut St, Sunsetville', '876543210', 1, 'Doktor Ilmu Komputer', 95.00, 'Universitas Sunsetville', 'Daniel Scott', '210987654'),
(174, 'Mia Green', '567 Pinecone St, Riverside', '109876543', 1, 'Teknik Informatika', 90.25, 'SMAN 19 Riverside', 'Jacob Green', '765432109'),
(175, 'Jacob Reed', '890 Bluebell St, Lakeside', '987654321', 1, 'Sistem Informasi', 77.75, 'SMAN 20 Lakeside', 'Isabella Reed', '654321098'),
(176, 'Isabella Cook', '123 Daisy St, Hillside', '876543210', 1, 'DKV', 82.50, 'SMAN 21 Hillside', 'Gabriel Cook', '543210987'),
(177, 'Gabriel Bailey', '456 Rose St, Mountainview', '765432109', 1, 'Teknik Informatika', 88.75, 'SMAN 22 Mountainview', 'Avery Bailey', '321098765'),
(178, 'Avery Rivera', '789 Tulip St, Oceanville', '654321098', 1, 'Broadcasting D3', 75.00, 'SMAN 23 Oceanville', 'Ella Rivera', '098765432'),
(179, 'Ella Parker', '234 Lily St, Baytown', '543210987', 1, 'Magister Teknik Informatika', 93.25, 'Universitas Baytown', 'Jackson Parker', '876543210'),
(180, 'Jackson Scott', '567 Sunflower St, Beachside', '432109876', 1, 'FTV', 79.00, 'SMAN 24 Beachside', 'Scarlett Scott', '654321098'),
(181, 'Nathan Ward', '123 Iris St, Grovetown', '210987654', 1, 'Ilmu Komunikasi', 86.50, 'SMAN 26 Grovetown', 'Hailey Ward', '321098765'),
(182, 'Hailey Cox', '456 Violet St, Hilltop', '109876543', 1, 'Teknik Informatika D3', 77.25, 'SMAN 27 Hilltop', 'Ethan Cox', '210987654'),
(183, 'Ethan Perry', '789 Lily St, Summitville', '098765432', 1, 'Doktor Ilmu Komputer', 96.00, 'Universitas Summitville', 'Madison Perry', '109876543'),
(184, 'Madison Hughes', '234 Rose St, Valleyview', '987654321', 1, 'Teknik Informatika', 89.25, 'SMAN 28 Valleyview', 'David Hughes', '098765432'),
(185, 'David Barnes', '567 Daisy St, Lakeshore', '876543210', 1, 'Sistem Informasi', 80.75, 'SMAN 29 Lakeshore', 'Emma Barnes', '987654321'),
(186, 'Emma Long', '890 Sunflower St, Rivertown', '765432109', 1, 'DKV', 79.50, 'SMAN 30 Rivertown', 'Oliver Long', '876543210'),
(187, 'Oliver Cook', '123 Orchid St, Woodside', '654321098', 1, 'Teknik Informatika', 87.75, 'SMAN 31 Woodside', 'Sophie Cook', '765432109'),
(188, 'Sophie Brooks', '456 Iris St, Hillcrest', '543210987', 1, 'Broadcasting D3', 78.25, 'SMAN 32 Hillcrest', 'William Brooks', '654321098'),
(189, 'William Ward', '789 Violet St, Sunsetville', '432109876', 1, 'Magister Teknik Informatika', 94.75, 'Universitas Sunsetville', 'Chloe Ward', '543210987'),
(190, 'Chloe Cox', '234 Lily St, Riverside', '321098765', 1, 'FTV', 80.00, 'SMAN 33 Riverside', 'Daniel Cox', '432109876'),
(191, 'Ava Parker', '890 Lily St, Hillside', '109876543', 1, 'Ilmu Komunikasi', 77.50, 'SMAN 35 Hillside', 'Jack Parker', '210987654'),
(192, 'Jack Scott', '123 Rose St, Mountainview', '098765432', 1, 'Teknik Informatika D3', 78.75, 'SMAN 36 Mountainview', 'Lily Scott', '109876543'),
(193, 'Lily Hill', '456 Daisy St, Oceanville', '987654321', 1, 'Doktor Ilmu Komputer', 97.00, 'Universitas Oceanville', 'Mason Hill', '098765432'),
(194, 'Mason Ward', '789 Iris St, Baytown', '876543210', 1, 'Teknik Informatika', 90.75, 'SMAN 37 Baytown', 'Olivia Ward', '987654321'),
(195, 'Olivia Cox', '234 Orchid St, Beachside', '765432109', 1, 'Sistem Informasi', 81.50, 'SMAN 38 Beachside', 'Ethan Cox', '876543210'),
(196, 'Ethan Long', '567 Sunflower St, Forestville', '654321098', 1, 'DKV', 83.25, 'SMAN 39 Forestville', 'Sophie Long', '765432109'),
(197, 'Sophie Cook', '890 Iris St, Grovetown', '543210987', 1, 'Teknik Informatika', 79.00, 'SMAN 40 Grovetown', 'William Cook', '654321098'),
(198, 'William Brooks', '123 Violet St, Hilltop', '432109876', 1, 'Broadcasting D3', 79.75, 'SMAN 41 Hilltop', 'Chloe Brooks', '543210987'),
(199, 'Chloe Ward', '456 Lily St, Summitville', '321098765', 1, 'Magister Teknik Informatika', 95.50, 'Universitas Summitville', 'Daniel Ward', '432109876'),
(200, 'Daniel Cox', '789 Rose St, Valleyview', '210987654', 1, 'FTV', 77.25, 'SMAN 42 Valleyview', 'Ava Cox', '321098765'),
(201, 'Jack Parker', '567 Lily St, Rivertown', '098765432', 1, 'Ilmu Komunikasi', 85.25, 'SMAN 44 Rivertown', 'Lily Parker', '109876543'),
(202, 'Lily Scott', '890 Rose St, Woodside', '987654321', 1, 'Teknik Informatika D3', 76.50, 'SMAN 45 Woodside', 'Mason Scott', '098765432'),
(203, 'Mason Hill', '123 Daisy St, Hillcrest', '876543210', 1, 'Doktor Ilmu Komputer', 98.00, 'Universitas Hillcrest', 'Olivia Hill', '987654321'),
(204, 'Bobi Mane', 'Semarang Europe', '019231275', 0, 'Teknik Elektro', 40.00, 'SMAN 3 Semarang', 'Boedie', '971237909521');

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
-- Indexes for table `jurusan`
--
ALTER TABLE `jurusan`
  ADD PRIMARY KEY (`namajurusan`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nama_mk` (`nama_mk`),
  ADD KEY `nama_mk_2` (`nama_mk`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `id_siswa` (`id_siswa`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=519;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1088;

--
-- AUTO_INCREMENT for table `pendaftar`
--
ALTER TABLE `pendaftar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `pendaftar` (`id`);

--
-- Constraints for table `pendaftar`
--
ALTER TABLE `pendaftar`
  ADD CONSTRAINT `pendaftar_ibfk_1` FOREIGN KEY (`jurusan`) REFERENCES `jurusan` (`namajurusan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
